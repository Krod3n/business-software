import { Visibility, VisibilityOff } from "@mui/icons-material";
import Button from "@mui/material/Button";
import FormControl from "@mui/material/FormControl";
import IconButton from "@mui/material/IconButton";
import InputAdornment from "@mui/material/InputAdornment";
import InputLabel from "@mui/material/InputLabel";
import OutlinedInput from "@mui/material/OutlinedInput";
import TextField from "@mui/material/TextField";
import { useFormik } from "formik";
import * as Yup from "yup";
import React, { useEffect, useState } from "react";
import "./Login.css";
import { FormHelperText } from "@mui/material";
import { useNavigate } from "react-router-dom";
import AuthentificationService from "./../../service/AuthenticationService";
import { useTranslation } from "react-i18next";
import i18n from "../../i18n";

const Login = () => {
  const navigate = useNavigate();

  const { t } = useTranslation();

  useEffect(() => {
    const lng = navigator.language;
    i18n.changeLanguage(lng);
  }, []);

  // REGLES DE GESTION
  const validationSchema = Yup.object().shape({
    username: Yup.string()
      .min(4, t("login.userError").toString())
      .max(30, t("login.userError").toString())
      .required(t("login.userRequired").toString()),
    password: Yup.string()
      .min(6, t("login.pwdError").toString())
      .max(20, t("login.pwdError").toString())
      .required(t("login.pwdRequired").toString()),
  });

  // Pour message de connexion
  const [message, setMessage] = useState<string>("");
  const [color, setColor] = useState<string>("");

  
  // VALIDATION FORMIK
  const formik = useFormik({
    initialValues: {
      username: "",
      password: "",
    },
    onSubmit: (values) => {
      console.log(JSON.stringify(values));
      setColor("#2f3640");
      setMessage(t("login.time").toString());
      AuthentificationService.login(values.username, values.password).then(
        (isAuthenticated: any) => {
          if (!isAuthenticated) {
            setColor("#c0392b");
            setMessage(t("login.msgError").toString());
            console.log("Username or password not valid");
            return;
          }
          setMessage(t("login.ok").toString());
          navigate("/dashboard");
        }
      );
    },
    validationSchema: validationSchema,
  });

  // CONSTANTES POUR LE PASSWORD
  const [showPassword, setShowPassword] = React.useState(false);
  const handleClickShowPassword = () => setShowPassword((show) => !show);
  const handleMouseDownPassword = (
    event: React.MouseEvent<HTMLButtonElement>
  ) => {
    event.preventDefault();
  };

  return (
    <div className="container">
      <div className="loginContainer">
        {/* LOGO */}
        <h1 className="log">{t("login.title").toString()}</h1>
        {/* FORMULAIRE DE CONNEXION */}
        <form onSubmit={formik.handleSubmit}>
          <div className="loginInput">
            {/* USERNAME */}
            <TextField
              id="username"
              label={t("login.username")}
              variant="outlined"
              className="usernameInput"
              name="username"
              margin="dense"
              fullWidth
              value={formik.values.username}
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              error={formik.touched.username && Boolean(formik.errors.username)}
              helperText={formik.touched.username && formik.errors.username}
            />
            {/* PASSWORD */}
            <FormControl
              fullWidth
              margin="normal"
              variant="outlined"
              className="passwordInput"
              error={formik.touched.password && Boolean(formik.errors.password)}
            >
              <InputLabel htmlFor="password">{t("login.password")}</InputLabel>
              <OutlinedInput
                id="password"
                type={showPassword ? "text" : "password"}
                endAdornment={
                  <InputAdornment position="end">
                    <IconButton
                      aria-label="toggle password visibility"
                      onClick={handleClickShowPassword}
                      onMouseDown={handleMouseDownPassword}
                      edge="end"
                    >
                      {showPassword ? <VisibilityOff /> : <Visibility />}
                    </IconButton>
                  </InputAdornment>
                }
                label={t("login.password")}
                value={formik.values.password}
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
              />
              <FormHelperText>
                {formik.touched.password && formik.errors.password}
              </FormHelperText>
            </FormControl>
            {/* BUTTON VALIDATION */}
            <Button variant="outlined" className="loginButton" type="submit">
              {t("general.submit").toString()}
            </Button>
            {/* MESSAGE D'ERREUR => Connexion impossible */}
          </div>
          {/* MESSAGE D'ERREUR => Connexion impossible */}
          <p className="LogError" style={{ color: color, fontWeight: 450 }}>
            {message}
          </p>
        </form>
      </div>
    </div>
  );
};

export default Login;
