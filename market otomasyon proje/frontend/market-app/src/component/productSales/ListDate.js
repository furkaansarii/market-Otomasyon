import React, { useState } from 'react'
import { Link } from 'react-router-dom';
import ProductSalesService from '../../services/ProductSalesService';




const ListDate = () => {

    const [productSaless, setProductSaless] = useState([])
    const [priceDate, setPriceDate] = useState("")

    const findByCompanyName = () => {

        ProductSalesService.getDate(priceDate).then((response) => {

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

                            <h2 className="text-center">Satış Raporu Bilgileri</h2>
                            <div className="card-body">

                                <div className="form-group mb-2">
                                    <label className="form-label">Satış Tarihi :</label>
                                    <input
                                        type="text"
                                        placeholder="Şirket Adı Girin"
                                        name="priceDate"
                                        className="form-control"

                                        onChange={(e) => setPriceDate(e.target.value)}>
                                    </input>

                                </div>




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
                                
                                <th>Satış Fİyatı</th>
                                <th>Satış Tarihi</th>
                                <th>Satış Miktarı</th>
                                <th>Ürün Adı</th>

                            </tr>
                        </thead>
                        <tbody>
                            {
                                productSaless.map(
                                    productSales =>
                                <tr>   
                               
                               <td>{productSales.salePrice}</td>
                               <td>{productSales.priceDate}</td>
                               <td>{productSales.saleQuantity}</td>
                               <td>{productSales.productName}</td>
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
export default ListDate
