import { NavLink } from "react-router-dom";
import { useState } from "react";
import Top from "./../Top/Top";
import DensityMediumIcon from "@mui/icons-material/DensityMedium";
import DashboardIcon from "@mui/icons-material/Dashboard";
import GroupIcon from "@mui/icons-material/Group";
import FileCopyIcon from "@mui/icons-material/FileCopy";
import ProductionQuantityLimitsIcon from "@mui/icons-material/ProductionQuantityLimits";
import PaymentIcon from "@mui/icons-material/Payment";
import LogoutIcon from "@mui/icons-material/Logout";
import "./SideBar.css";
import CustomButton from "../CustomButton";
import { useTranslation } from "react-i18next";

const Sidebar = ({ children, ...props }: any) => {

  const { t } = useTranslation();

  // useEffect(() => {
  //   const lng = navigator.language;
  //   i18n.changeLanguage(lng);
  // }, []);
  
  const [isOpen, setIsOpen] = useState(false);
  const toggle = () => setIsOpen(!isOpen);
  const menuItem = [
    {
      path: "/dashboard",
      name: t("sidebar.dashboard").toString(),
      icon: <DashboardIcon />,
    },
    {
      path: "/customer",
      name: t("sidebar.customers").toString(),
      icon: <GroupIcon />,
    },
    {
      path: "/invoice",
      name: t("sidebar.invoices").toString(),
      icon: <FileCopyIcon />,
    },
    {
      path: "/product",
      name: t("sidebar.products").toString(),
      icon: <ProductionQuantityLimitsIcon />,
    },
    {
      path: "/financial",
      name: t("sidebar.finance").toString(),
      icon: <PaymentIcon />,
    },
    {
      path: "/",
      name: <CustomButton />,
      icon: <LogoutIcon />,
    },
  ];

  return (
    <div className="container">
      <div style={{ width: isOpen ? "250px" : "50px" }} className="sidebar">
        <div className="top_section">
          <div style={{ marginLeft: isOpen ? "50px" : "0px" }} className="bars">
            <DensityMediumIcon onClick={toggle} />
          </div>
          <div
            style={{ display: isOpen ? "block" : "none" }}
            className="profil"
          >
            <Top />
          </div>
        </div>
        {menuItem.map((item, index) => (
          <NavLink to={item.path} key={index} className="link">
            <div className="icon">{item.icon}</div>
            <div
              style={{ display: isOpen ? "block" : "none" }}
              className="link_text"
            >
              {item.name}
            </div>
          </NavLink>
        ))}
      </div>
      <main>{children}</main>
    </div>
  );
};
export default Sidebar;
