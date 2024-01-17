import React from 'react';
import Avatar from '@mui/material/Avatar';
import './Top.css';
import kenny from '../../assets/images/kenny.jpg'

const Top = () => {

    return (
        
        <div className="top">
    <Avatar className="imgContainer"
  alt="picture"
  src={kenny}/>
            <h1 className='name'>sPiot | Omega ♥ </h1>
        </div>
    );
};
export default Top;

