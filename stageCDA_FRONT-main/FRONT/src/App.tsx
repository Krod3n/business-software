import { BrowserRouter, Routes, Route } from "react-router-dom";
import Dashboard from "./pages/dashboard/Dashboard";
import Customer from "./pages/customer/Customer";
import Login from "./pages/login/Login";
import Invoice from "./pages/invoice/Invoice";
import Product from "./pages/product/Product";
import Financial from "./pages/financial_movement/Financial";
import Sidebar from "./Components/sidebar/SideBar";
import "./App.css";
import ErrorPage from "./pages/error/ErrorPage";
import FormFinancial from "./pages/financial_movement/FormFinancial";

function App() {
  return (
    <BrowserRouter>
      <Sidebar>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/customer" element={<Customer />} />
          <Route path="/invoice" element={<Invoice />} />
          <Route path="/product" element={<Product />} />
          <Route path="/financial" element={<Financial />} />
          <Route path="/financialForm" element={<FormFinancial isEditForm={false} />} />
          <Route path="/editFinancialForm/:id" element={<FormFinancial isEditForm={true}  />} />
          <Route path="/errorPage" element={<ErrorPage />} />
        </Routes>
      </Sidebar>
    </BrowserRouter>
  );
}

export default App;
