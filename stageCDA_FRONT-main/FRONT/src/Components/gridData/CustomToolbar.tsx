import { Box } from '@mui/material'
import { color } from '@mui/system'
import { GridToolbarColumnsButton, GridToolbarContainer, GridToolbarDensitySelector, GridToolbarExport, GridToolbarFilterButton } from '@mui/x-data-grid'
import React from 'react'


const CustomToolbar = () => {
  return (
    <GridToolbarContainer sx={{borderRadius: 5}}>
        <GridToolbarColumnsButton  color="inherit" />
        <GridToolbarFilterButton color="inherit" />
        <GridToolbarDensitySelector color="inherit"/>
        {/* <GridToolbarExport color="inherit" /> */}
  </GridToolbarContainer>
  )
}

export default CustomToolbar