import React, { useState } from 'react'
import { Link } from 'react-router-dom';
import ProductService from '../../services/ProductService';





const BuyAndSellList = () => {

    const [products, setProducts] = useState([])
    

    const findByCompanyName = () => {

        ProductService.buyAndSell().then((response) => {

            setProducts(response.data)


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

                            <h2 className="text-center">Alış Satış Listesi</h2>
                            <div className="card-body">

                                <button className="btn btn-success" onClick={() => findByCompanyName()}>Ara</button>
                                &nbsp;
                                <Link to="/products" className="btn btn-danger">İptal</Link>

                            </div>
                        </div>
                    </div>
                    <div>
                        
                            <table className="table table-bordered table striped">
                        <thead>
                            <tr>
                                
                                <th>Ürün Adı</th>
                                <th>Alış Fiyatı</th>
                                <th>Satış Fİyatı</th>
                                
                                

                            </tr>
                        </thead>
                        <tbody>
                            {
                                products.map(
                                    product =>
                                <tr>   
                               
                               <td>{product.productName}</td>
                               <td>{product.buyingPrice}</td>
                               <td>{product.salePrice}</td>
                               
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
export default BuyAndSellList
