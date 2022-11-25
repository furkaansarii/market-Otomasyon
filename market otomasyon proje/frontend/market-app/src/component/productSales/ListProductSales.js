import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import ProductSalesService from '../../services/ProductSalesService'



const ListProductSales = () =>{

    const [productSaless, setProductSaless] = useState([])

    useEffect(() => {
      
        getAllProductSaless();
    }, [])

    const getAllProductSaless = ()=>{
        ProductSalesService.getAllProductSales().then((response) =>{
            setProductSaless(response.data)
            console.log(response.data);
        }).catch(error =>{
            console.log(error);
        })
    }

    const deleteProductSales = (productSalesId) =>{
        ProductSalesService.deleteProductSales(productSalesId).then((response)=>{
            getAllProductSaless();
        }).catch(error=>{
            console.log(error);
        })
    }
    

    return(
        <div className="container">
            <h2 className="text-center">Satış Listesi</h2>
            <div>
                <Link to = "/add-productSales" className="btn btn-dark mb-3">Satış Ekle</Link>
                &nbsp;
                <Link to = "/sellingDate" className="btn btn-dark mb-3">Güne Göre Satış</Link>
                &nbsp;
                <Link to = "/sallestList" className="btn btn-dark mb-3">Satışları Görüntüle</Link>
                
            </div>
           
                
           
            
            <table className="table table-bordered table striped">
                <thead>
                    <tr>
                        <th>Satış Fiyatı</th>
                        <th>Satış Tarihi</th>
                        <th>Satış Miktarı</th>
                        <th>Ürün Adı</th>
                        
                    </tr>    
                </thead>
                <tbody>
                    {
                        productSaless.map(
                            productSales=>
                            <tr key ={productSales.productSalesId}>
                                <td>{productSales.salePrice}</td>
                                <td>{productSales.priceDate}</td>
                                <td>{productSales.saleQuantity}</td>
                                <td>{productSales.productName}</td>
                                <td>
                                    
                                    <Link className="btn btn-info" to={`/edit-productSales/${productSales.productSalesId}`} >Güncelle</Link>
                                    &nbsp;
                                    <Link className="btn btn-danger" onClick={()=>deleteProductSales(productSales.productSalesId)}>Sil</Link>

                                </td>

                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListProductSales