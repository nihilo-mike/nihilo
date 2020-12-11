import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

import 'bootstrap/dist/css/bootstrap.min.css';
import reportWebVitals from './reportWebVitals';
import Example from './Navbar';

ReactDOM.render(
  <React.StrictMode>
   <div style={{border:"3px solid rgba(217, 255, 0, 0.863)"}}>
     <Example />
</div>

<div style={{display: "flex",  justifyContent:'center', alignItems:'center',paddingTop:"200px"}}>
    <text style={{fontSize:"100px",color:"whitesmoke"}}>welcome</text> 
</div>
    
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
