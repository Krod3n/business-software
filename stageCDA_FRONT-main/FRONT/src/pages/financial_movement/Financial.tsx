import { Box, Button, LinearProgress, Toolbar } from '@mui/material';
import { DataGrid, GridActionsCell, GridActionsCellItem, GridCellParams, GridColDef, GridColumns, GridRenderCellParams, GridRowsProp, GridToolbar } from '@mui/x-data-grid';
import React, { useCallback, useEffect, useState } from 'react';
import './Financial.css'
import { Bar, BarChart, Brush, CartesianGrid, Legend, Line, LineChart, ReferenceDot, ReferenceLine, ResponsiveContainer, Tooltip, XAxis, YAxis } from 'recharts';
import FinancialMovement from '../../models/FinancialMovement';
import FinanceService from '../../service/FinanceService';
import { useLocation, useNavigate } from 'react-router-dom';
import Title from '../../Components/title/Title';
import MonthlyMoves from '../../models/MonthlyMoves';
import clsx from 'clsx';
import CustomToolbar from '../../Components/gridData/CustomToolbar';
import DeleteIcon from '@mui/icons-material/DeleteForever';
import EditIcon from '@mui/icons-material/ModeEdit';
import { useTranslation } from 'react-i18next';
import i18n from '../../i18n';
import { getValue } from '@testing-library/user-event/dist/utils';


const Financial = () => {

  const { t } = useTranslation();

  // useEffect(() => {
  //   const lng = navigator.language;
  //   i18n.changeLanguage(lng);
  // }, []);

  const navigate = useNavigate();

  const [finances, setFinances] = useState<FinancialMovement[]>([])

  const [rawdatas, setRawdatas] = useState<any[]>([])

  useEffect(() => {
    try {
      FinanceService.getFinance()
      .then(finances => setFinances(finances))
      .catch((reason) => console.error(reason));
    } catch {
      console.log('erreur survenue pour récupérer les mouvements');
    }  
    }, []); 

    useEffect(() => {
      let data: MonthlyMoves[] = []
      finances.map((move) => {
        const year = new Date(move.date).getFullYear();
        const month = new Date(move.date).getMonth() + 1;
        let know = data.find(
          (value) => value.year === year && value.month === month
        );
        if (know === undefined) {
          know = new MonthlyMoves(year, month, 0, 0);
        }
        if (move.amount !== undefined) {
          if (move.amount < 0 ) {
            know.outcomes += move.amount
          } else {
            know.incomes += move.amount
          }
        }

        data = data.filter((values) => values.month !== month);
        console.log(know);
        
        data.push(know)
        setRawdatas(data);

      })
    }, [finances]);


  const movementCreation = () => {
    navigate("/financialForm")
  }

  const handleDelete = (id : number) => {
    FinanceService.deleteMovement(id)
    // const newFinances = finances.filter(finance => finance.id !== id)
    setFinances(finances.filter(finance => finance.id !== id))
    console.log('delete')
  }

  const editMovement = (id : number) => {
    navigate(`/editFinancialForm/${id}`)
  }

  let dat = new Date();

  const columns: GridColumns<FinancialMovement> = [
    {
      field: "date",
      headerName: t("general.date").toString(),
      headerClassName: "moveHeaderColor",
      flex: 0.5,
      type: "date",
      valueGetter: ({value}) => value && new Date(value),
      // sortingOrder
    },
    {
      field: "reference",
      headerName: t("finance.grid.invoice").toString(),
      headerClassName: "moveHeaderColor",
      flex: 0.5,
      // valueGetter
    },
    {
      field: "thirdParty",
      headerName: t("finance.grid.customer").toString(),
      headerClassName: "moveHeaderColor",
      flex: 0.5,
    },
    {
      field: "description",
      headerName: t("general.description").toString(),
      headerClassName: "moveHeaderColor",
      flex: 1,
    },
    {
      field: "amount",
      headerName: t("general.amount").toString(),
      headerClassName: "moveHeaderColor",
      headerAlign: "left",
      description: 'Montant gagné ou dépensé en € ',
      type: "number",
      align: "left",
      // sortable: false,
      flex: 0.4,
      cellClassName: (params: GridCellParams<number>) => {
        if (params.value == null) {
          return '';
        }
  
        return clsx('moveAMountColor', {
          negative: params.value < 0,
          positive: params.value > 0,
        });
      },
      renderCell: (params: GridRenderCellParams<number>) => (
        <span>
          {params.row.amount.toLocaleString(undefined, {
            minimumFractionDigits: 2,
            maximumFractionDigits: 2
          })}
           €
        </span>
      ),
    },
    {
      field: "edit",
      headerName: t("finance.grid.edit").toString(),
      headerClassName: "moveHeaderColor",
      headerAlign: "center",
      flex: 0.3,
      sortable: false,
      type: 'actions',
      renderCell: (params) => {
        return (
            <div style={{ cursor: "pointer" }} onClick={() => editMovement(params.row.id)}>
              <EditIcon sx={{color: "#1e272e"}}/>
             </div>
        );
    },
    },
    {
      field: "delete",
      headerName: t("finance.grid.delete").toString(),
      headerClassName: "moveHeaderColor",
      headerAlign: "center",
      flex: 0.3,
      sortable: false,
      type: 'actions',
      renderCell: (params) => {
        return (
            <div style={{ cursor: "pointer" }} onClick={() => handleDelete(params.row.id)}>
              <DeleteIcon sx={{color: '#1e272e'}}/>
              {/* color: #b33939 ou #b33939 */}
             </div>
        );
    },
    },
  ];



    return (
    <div className='movementContainer'>
        {/* TITLE */}
      <Title title={t("finance.title").toString()} />
        {/* CREATION BUTTON */}
        <div className="movementButtonContainer">
            <Button 
              variant="contained" 
              color='success'
              className="movementButton"
              onClick={movementCreation}
            >
              {t("finance.creation").toString()}
            </Button>
        </div>
        {/* GRID DATA & GRAPH */}
        <div className="movementInfoContainer">
            {/* GRID DATA */}
            <div className="movementGridContainer">
                <DataGrid 
                  rows={finances} 
                  columns={columns} 
                  className="MovementDataGrid" 
                  autoPageSize
                  components={{
                    Toolbar: CustomToolbar,
                  }}
                  initialState={{
                    sorting: {
                      sortModel: [{ field: 'date', sort: 'desc' }],
                    }}}
                // DATA GRID STYLE
                  sx={{
                    '.MuiDataGrid-columnSeparator': {
                      display: 'none',
                    },
                    '&.MuiDataGrid-root': {
                      border: 'none',
                    },
                    '& .moveHeaderColor': {
                      backgroundColor: '#95afc0',
                    },
                    '& .moveAMountColor.positive': {
                      backgroundColor: '#6ab04c',
                      fontWeight: '600',
                      '&:hover': {
                        backgroundColor: 'white',
                      },
                      // positif :#009432 negatif: #e84118
                    },
                    '& .moveAMountColor.negative': {
                      backgroundColor: '#d47483',
                      fontWeight: '600',
                      '&:hover': {
                        backgroundColor: 'white'
                      },
                    },
                  }}
                />
            </div>
            {/* GRAPH */}
            <div className="movementGraphContainer">
            <ResponsiveContainer width="98%" height="82%" className='movementGraphResponse'>
          <BarChart data={rawdatas} stackOffset="sign">
            <CartesianGrid strokeDasharray="3 3 " />
            <XAxis dataKey="month" name="name" type='number' domain={[1,12]} tickCount={12} padding={{ left: 30, right: 30 }} allowDecimals={false} tick={{stroke: 'white', strokeWidth: 0.4}} />
            <YAxis  tickCount={8}/>
            <Tooltip />
            <Legend verticalAlign='top' height={60}/>
            <Bar dataKey="incomes" fill="#6ab04c" name={t("finance.graph.income").toString()} stackId="stack" />
            {/* vert possible : #6ab04c , #009432 , #2ed573 , #3ae374 ,   */}
            <Bar dataKey="outcomes" fill="#d47483" name={t("finance.graph.outcome").toString()} stackId="stack" />
            {/* rouge possible :  #d47483, #b33939 */}
          
          </BarChart>
        </ResponsiveContainer>
            </div>
        </div>
    </div>
    );
};

export default Financial;