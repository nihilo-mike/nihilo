import React  from 'react';
import {
  Navbar,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink} from 'reactstrap';

const Example = () => {
  


  return (
    <div >
      <Navbar color="light" light expand="mr" >
        <NavbarBrand style={{fontSize:"60px",fontFamily:"verdana",fontWeight:"initial"}}>Nihilo</NavbarBrand>
         <Nav className="md-auto" navbar>
            <NavItem>
              <NavLink style={{fontSize:"20px"}}>Transactions</NavLink>
            </NavItem>
            <NavItem>
              <NavLink style={{fontSize:"20px"}} >add Transactions</NavLink>
            </NavItem>
            <NavItem>
              <NavLink style={{fontSize:"20px"}} >search </NavLink>
            </NavItem>
           </Nav>
          </Navbar>
    </div>
  );
}

export default Example;