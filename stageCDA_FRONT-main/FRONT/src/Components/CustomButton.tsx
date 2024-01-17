import React from 'react'
import { useTranslation } from 'react-i18next';

type Props = {}

const CustomButton = (props: Props) => {

  const { t } = useTranslation();

  // useEffect(() => {
  //   const lng = navigator.language;
  //   i18n.changeLanguage(lng);
  // }, []);

  const clearJWT = () => {
    localStorage.clear();

  }
  return (
    <div>
        <text onClick={clearJWT}>{t("sidebar.logout").toString()}</text>       
    </div>
  )
}

export default CustomButton