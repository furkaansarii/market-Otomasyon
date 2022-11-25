import './App.css';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import { FooterComponent } from './component/FooterComponent';
import { HeaderComponent } from './component/HeaderComponent';
import ListProductComponent from './component/product/ListProductComponent';
import Birlestir from './component/Birlestir';
import AddProduct from './component/product/AddProduct';
import ListEmployeeComponent from './component/employee/ListEmployeeComponent'
import AddEmployee from './component/employee/AddEmployee';
import ListProductSales from './component/productSales/ListProductSales';
import AddProductSales from './component/productSales/AddProductSales';
import ListWholesaler from './component/wholesaler/ListWholesaler';
import AddWholesaler from './component/wholesaler/AddWholesaler';
import GetByNameProduct from './component/wholesaler/GetByNameProduct';
import WholesalerInfo from './component/wholesaler/WholesalerInfo';
import ListDate from './component/productSales/ListDate';
import SallestList from './component/productSales/SallestList';
import BuyAndSellList from './component/product/BuyAndSellList';
import MaxProducts from './component/product/MaxProducts';
import FindBySalary from './component/employee/FindBySalary';
import GetByMission from './component/employee/GetByMission';
import Login from './component/Login';


function App() {
  return (
    <div>
      <HeaderComponent></HeaderComponent>
      
    
      <div className="container">
      <Router>
        
        <Route exact path="/" component = {Login}></Route>
        <Route path="/home" component={Birlestir}></Route>
        <Route path="/products" component={ListProductComponent}></Route>
        <Route path="/add-product" component={AddProduct}></Route>
        <Route path="/employee" component={ListEmployeeComponent}></Route>
        <Route path="/add-employee" component={AddEmployee}></Route>
        <Route path="/productSales" component={ListProductSales}></Route>
        <Route path="/add-productSales" component={AddProductSales}></Route>
        <Route path="/wholesaler" component={ListWholesaler}></Route>
        <Route path="/add-wholesaler" component={AddWholesaler}></Route>
        <Route path="/getByNameProduct" component={GetByNameProduct}></Route>
        <Route path="/wholesalerInfo" component={WholesalerInfo}></Route>
        <Route path="/sellingDate" component={ListDate}></Route>
        <Route path="/sallestList" component={SallestList}></Route>
        <Route path="/buyAndSell" component={BuyAndSellList}></Route>
        <Route path="/maxProduct" component={MaxProducts}></Route>
        <Route path="/getBySalary" component={FindBySalary}></Route>
        <Route path="/getByMission" component={GetByMission}></Route>
        
        
          
    </Router>
        
      </div>
      <FooterComponent></FooterComponent>
  </div>
  );
}

export default App;
