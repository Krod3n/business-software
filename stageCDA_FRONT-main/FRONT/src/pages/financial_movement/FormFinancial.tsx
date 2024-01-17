import { Button, FormControl, InputAdornment, TextField } from "@mui/material";
import Grid from "@mui/material/Grid"; // Grid version 1
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import Title from "../../Components/title/Title";
import "./FormFinancial.css";
import EuroOutlinedIcon from "@mui/icons-material/EuroOutlined";
import { useFormik } from "formik";
import * as Yup from "yup";
import FinanceService from "../../service/FinanceService";
import FinancialMovement from "../../models/FinancialMovement";
import { useTranslation } from 'react-i18next';

type Props = {
  isEditForm: boolean
};

const FormFinancial = ({isEditForm}: Props) => {

  const navigate = useNavigate();

  const { t } = useTranslation();

  const params = useParams();

    const [movement, setMovement] = useState<FinancialMovement|null>(null);

    useEffect(() => {
        FinanceService.getMovement(Number(params.id)).then(movement => setMovement(movement))
    },[Number(params.id)])
  

  const validationSchema = Yup.object().shape({
    date: Yup.date()
      .required('La date est obligatoire'),
    thirdParty: Yup.string()
      .min(1, "Le fournisseur est trop court")
      .max(50, "Le fournisseur est trop long")
      .required("Le fournisseur est obligatoire"),
    description: Yup.string()
      .min(1, "La description est trop courte")
      .max(50, "La description est trop longue"),
    amount: Yup.number()
      .required("Montant obligatoire"),
    payment: Yup.string()
      .required("Le mode de paiement est obligatoire"),
  });


  const updateMovement = (values: any) => {
    FinanceService.updateMovement(values)
    alert('update bidule : ' + JSON.stringify(values))
  }

  const addMovement = (values: any) => {
    FinanceService.addMovement(values)
    alert('add movement : ' + JSON.stringify(values))
  }


  // VALIDATION FORMIK
  const formik = useFormik({
    initialValues: {
      id: movement?.id  , 
      date: movement?.date,
      thirdParty: movement?.thirdParty,
      description: movement?.description,
      amount: movement?.amount,
      payment: t("finance.form.virement").toString(),
    },
    validationSchema: validationSchema,
    enableReinitialize: true,
    onSubmit: (values) => {
      console.log(JSON.stringify(values));
      navigate("/financial");
      isEditForm ? updateMovement(values) : addMovement(values)
      // addMovement(values);
    }
  });

  const backMovement = () => {
    navigate("/financial");
  };

  return (
    <div>
      {!isEditForm && (
      <Title title={t("finance.form.creation").toString()} />
      )}
      {isEditForm && (
      <Title title={t("finance.form.edit").toString()} />
      )}
      {/* BUTTON BACK CONTAINER */}
      <div className="formMovementButtonContainer">
      </div>
      {/* FORMULAIRE */}    
      <form onSubmit={formik.handleSubmit}>
        {/* GRID FORM CONTAINER */}
        <Grid container className="FormMovementContainer" rowGap={3}>
          {/* LIGNE 1 */}
          {/* DATE INPUT */}
          <Grid item xs={1.5} >
            <TextField
              name="date"
              id="date"
              type="date"
              label={t("general.date").toString()}
              variant="filled"
              style={{ width: "85%" }}
              className="movFormInput"
              color="success"
              InputLabelProps={{ shrink: true }}
              value={formik.values.date}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              error={formik.touched.date && Boolean(formik.errors.date)}
              helperText={formik.touched.date && formik.errors.date}
            />
          </Grid>
          {/* FOURNISSEUR INPUT */}
          <Grid item xs={9.5} >
            <TextField
              name="thirdParty"
              id="thirdParty"
              variant="filled"
              fullWidth
              className="movFormInput"
              color="success"
              label={t("finance.form.thirdparty").toString()}
              InputLabelProps={{ shrink: true }}
              value={formik.values.thirdParty}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              error={
                formik.touched.thirdParty && Boolean(formik.errors.thirdParty)
              }
              helperText={formik.touched.thirdParty && formik.errors.thirdParty}
            />
          </Grid>
          {/* LIGNE 2 */}
          {/* DESCRIPTION INPUT */}
          <Grid item xs={11}>
            <TextField
              name="description"
              id="description"
              variant="filled"
              label={t("general.description").toString()}
              fullWidth
              className="movFormInput"
              color="success"
              InputLabelProps={{ shrink: true }}
              value={formik.values.description}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              error={
                formik.touched.description && Boolean(formik.errors.description)
              }
              helperText={
                formik.touched.description && formik.errors.description
              }
            />
          </Grid>
          {/* LIGNE 3 */}
          {/* MONTANT INPUT */}
          <Grid item xs={1.5}>
            <TextField
              name="amount"
              id="amount"
              label={t("general.amount").toString()}
              type="number"
              variant="filled"
              color="success"
              style={{ width: "85%" }}
              className="movFormInput"
              InputProps={{
                startAdornment: (
                  <InputAdornment position="start">
                    <EuroOutlinedIcon color="inherit" />
                  </InputAdornment>
                ),
              }}
              InputLabelProps={{ shrink: true }}
              placeholder="0"
              value={formik.values.amount}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              error={formik.touched.amount && Boolean(formik.errors.amount)}
              helperText={formik.touched.amount && formik.errors.amount}
            />
          </Grid>
          {/* METHOD PAIEMENT INPUT */}
          <Grid item xs={4}>
            <TextField
              name="payment"
              id="payment"
              label={t("finance.form.payment")}
              variant="filled"
              color="success"
              style={{ width: "80%" }}
              className="movFormInput"
              value={formik.values.payment}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              error={formik.touched.payment && Boolean(formik.errors.payment)}
              helperText={formik.touched.payment && formik.errors.payment}
            />
          </Grid>
        </Grid>
        
        {/* BUTTON VALIDATION CONTAINER */}
        <div className="formValidMovementContainer">
        <Button
          variant="outlined"
          color="warning"
          className="movementFormBack"
          onClick={backMovement}
        >
          {t("general.cancel").toString()}
        </Button>
          <Button
            variant="contained"
            color="success"
            className="movementFormValid"
            type="submit"
          >
            {t("general.submit").toString()}
          </Button>
        </div>
      </form>
    </div>
  );
};

export default FormFinancial;
