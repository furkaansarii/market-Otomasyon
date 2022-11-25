import React, { useState } from 'react'
import { Link } from 'react-router-dom';
import ProductSalesService from '../../services/ProductSalesService';




const SallestList = () => {

    const [productSaless, setProductSaless] = useState([])
   

    const findByCompanyName = () => {

        ProductSalesService.sallestList().then((response) => {

            setProductSaless(response.data)


        }).catch(error => {
            console.log(error);
        })
    }


    return (
        <div>
            <div>
                <br></br>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">

                            <h2 className="text-center">Satış Listesi</h2>
                            <div className="card-body">

                               
                                <button className="btn btn-success" onClick={() => findByCompanyName()}>Ara</button>
                                &nbsp;
                                <Link to="/productSales" className="btn btn-danger">İptal</Link>

                            </div>
                        </div>
                    </div>
                    <div>
                        
                            <table className="table table-bordered table striped">
                        <thead>
                            <tr>
                                
                                
                                <th>Ürün Adı</th>
                                <th>Satış Miktarı</th>

                            </tr>
                        </thead>
                        <tbody>
                            {
                                productSaless.map(
                                    productSales =>
                                <tr>   
                              
                               <td>{productSales.productName}</td>
                               <td>{productSales.saleQuantity}</td>
                               </tr>         



                                )
                            }
                        </tbody>
                    </table>
              
                </div>

            </div>
        </div>
    </div >
  )
}
export default SallestList
