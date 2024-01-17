import { Button } from "@mui/material";
import React from "react";
import { Navigate, useNavigate } from "react-router-dom";
import Title from "../../Components/title/Title";

type Props = {};

const ErrorPage = (props: Props) => {

    const navigate = useNavigate();

    const errorGo = () => {
        navigate('/')
    }
  return (
    <div>
    <Title title='Une erreur est survenue, veuillez revenir au login' />
      <Button
        variant="contained"
        color="success"
        className="movementButton"
        onClick={errorGo}
      >
        Revenir au login
      </Button>
    </div>
  );
};

export default ErrorPage;
