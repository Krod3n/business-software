import i18n from "i18next";
import { initReactI18next } from "react-i18next";
import LanguageDetector from "i18next-browser-languagedetector";
import { useEffect } from "react";
//import HttpBackend from "i18next-http-backend";

i18n
  // detect user language
  // learn more: https://github.com/i18next/i18next-browser-languageDetector
  .use(LanguageDetector)
  // pass the i18n instance to react-i18next.
  .use(initReactI18next)
  // init i18next
  // for all options read: https://www.i18next.com/overview/configuration-options
  .init({
    debug: true,
    fallbackLng: "en",
    interpolation: {
      escapeValue: false, // not needed for react as it escapes by default
    },
    resources: {
      en: {
        translation: {
          general: {
            date: "Date",
            description: "Description",
            amount: "Amount",
            cancel: "Cancel",
            submit: "Submit",
          },
          sidebar: {
            dashboard: "Dashboard",
            customers: "Customers",
            invoices: "Invoices",
            products: "Products",
            finance: "Finance",
            logout: "Logout"
          },
          login: {
            title: "Login",
            username: "username",
            password: "password",
            userRequired: "Username is required",
            pwdRequired: "Password is required",
            userError: "Username is not valid",
            pwdError: "Password is not valid",
            time: "Attempting to login...",
            msgError: "Username or password not valid",
            ok: "Connection in progress..."
            
          },
          finance: {
            title: "Financial movements",
            creation: "Creation of a movement",
            graph: {
              income: "Incomes",
              outcome: "Outcomes"
            },
            grid: {
              invoice: "Ref invoice",
              customer: "Customer",
              description: "Description",
              edit: "Edit",
              delete: "Delete"
            },
            form: {
              creation: "Creation of a financial movement",
              edit: "Modification of a financial movement",
              thirdparty: "Third party",
              amount: "Amount",
              payment: "Payment method",
              virement: "Bank transfer"
            }
          }
      }},
      fr: {
        translation: {
        general: {
          date: "Date",
          description: "Description",
          amount: "Montant",
          cancel: "Annuler",
          submit: "Valider",
        },
        sidebar: {
          dashboard: "Dashboard",
          customers: "Customers",
          invoices: "Invoices",
          products: "Products",
          finance: "Finance",
          logout: "Logout"
        },
        login: {
          title: "Connexion",
          username: "identifiant",
          password: "mot de passe",
          userRequired: "L'identifiant est obligatoire",
          pwdRequired: "Le mot de passe est obligatoire",
          userError: "L'identifiant n'est pas valide",
          pwdError: "Le mot de passe n'est pas valide",
          time: "Tentative de connexion...",
          msgError: "Identifiant ou mot de passe incorrect",
          ok: "Connexion en cours..."
        },
        finance: {
          title: "Mouvements financiers",
          creation: "Création d'un mouvement",
          graph: {
            income: "Recettes",
            outcome: "Dépenses"
          },
          grid: {
            Date: "Date",
            invoice: "Ref facture",
            customer: "Client",
            edit: "Modifier",
            delete: "Supprimer"
          },
          form: {
            creation: "Création d'un mouvement financier",
            edit: "Modification d'un mouvement financier",
            thirdparty: "Fournisseur",
            amount: "Montant",
            payment: "Méthode de paiement",
            virement: "Virement bancaire"
          }
        }
      },
    },
    },

  });

export default i18n;