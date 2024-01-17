import { useNavigate } from "react-router-dom";
import FinancialMovement from "../models/FinancialMovement";
import AuthentificationService from "./AuthenticationService";

export default class FinanceService {

static finances :FinancialMovement[];
  
// Récupère toutes les movements financiers de la base de données
static getFinance(): Promise<FinancialMovement[]> {
    return fetch('http://localhost:8080/finance/all', {
      method: "GET",
      headers: { 'Content-Type': 'application/json', 'Authorization': AuthentificationService.jwt}
      })
    .then(response => response.json())
    .catch(error => this.handleError(error));
}

static getMovement(id: number): Promise<FinancialMovement|null> {
  return fetch(`http://localhost:8080/finance/movement/${id}`, {
    method: "GET",
    headers: { 'Authorization': AuthentificationService.jwt}
    })
  .then(response => response.json())
  .then(data => this.isEmpty(data) ? null : data)
  .catch(error => this.handleError(error));
}

static addMovement(finance: FinancialMovement): Promise<FinancialMovement> {
  return fetch(`http://localhost:8080/finance/add`, {
    method: 'POST',
    body: JSON.stringify(finance),
    headers: { 'Content-Type': 'application/json', 'Authorization': AuthentificationService.jwt}
  })
  .then(response => response.json())
  .catch(error => this.handleError(error));
}

static deleteMovement(id: number): Promise<{}> {
  return fetch(`http://localhost:8080/finance/${id}`, {
    method: 'DELETE',
    headers: { 'Content-Type': 'application/json', 'Authorization': AuthentificationService.jwt}
  })
  .then(response => response.json())
  .catch(error => this.handleError(error));
}

static updateMovement(finance: FinancialMovement): Promise<FinancialMovement> {
  return fetch(`http://localhost:8080/finance/${finance.id}`, {
    method: 'PUT',
    body: JSON.stringify(finance),
    headers: { 'Content-Type': 'application/json', 'Authorization': AuthentificationService.jwt }
  })
  .then(response => response.json())
  .catch(error => this.handleError(error));
}


static isEmpty(data: Object): boolean {
return Object.keys(data).length === 0;
}



static handleError(error: Error): void {
console.error(error);
}

}