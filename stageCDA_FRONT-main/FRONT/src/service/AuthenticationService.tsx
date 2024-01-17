import LoginRequest from "../models/LoginRequest";

export default class AuthentificationService {
  static isAuthenticated: boolean;

  static jwt: string;

  static async getJwt(login: LoginRequest): Promise<any> {
    try {
      const response = await fetch(`http://localhost:8080/auth/signin`, {
        method: "POST",
        body: JSON.stringify(login),
        headers: { "Content-Type": "application/json" },
      });
      if (response.ok) {
        // return await response.json();
        const json = await response.json();
        localStorage.setItem('JWT', json.tokenHeader+ " " + json.token);
        console.log('local', localStorage.getItem('token'))
        return { token: json.token, tokenHeader: json.tokenHeader };
      } else if (response.status === 401) {
        this.isAuthenticated = false;
      }
    } catch (error) {
      this.isAuthenticated = false;
    }
  }

  static async login(username: string, password: string): Promise<boolean> {
    await this.getJwt(new LoginRequest(username, password)).then(
      (response) => {
        console.log(response);
        if (response !== undefined) {
          this.jwt = response.tokenHeader + " " + response.token;
        } else {
          this.jwt = "";
        }
      });

    console.log(this.jwt);

    const isAuthenticated = this.jwt != undefined && this.jwt.length > 0;
    return new Promise((resolve) => {
      setTimeout(() => {
        this.isAuthenticated = isAuthenticated;
        resolve(isAuthenticated);
      }, 1000);
    });
  }

  static handleError(error: Error): void {
    // this.isAuthenticated=false;
    console.error(error);
  }
}
