import React, {useState, useEffect} from "react";
import { Link } from 'react-router-dom'

import ProductService from "../../services/ProductService";

const ListProductComponent = () =>{
    const [products, setProducts] = useState([])
    
    useEffect(() => {
        getAllProducts();
    }, [])

    const getAllProducts = ()=>{
        ProductService.getAllProducts().then((response) =>{
            setProducts(response.data)
            console.log(response.data);
        }).catch(error =>{
            console.log(error);
        })
    }

    const deleteProduct = (productId) =>{
        ProductService.deleteProduct(productId).then((response) =>{
            getAllProducts();
        }).catch(error =>{
            console.log(error);
        })
    }

    return(
        <div className="container">
            <h2 className="text-center">Ürün Listesi</h2>
            <div>
                <Link to = "/add-product" className="btn btn-dark mb-3">Ürün Ekle</Link>
                &nbsp;
                <Link to = "/maxProduct" className="btn btn-dark mb-3">Eldeki En Fazla Ürün</Link>
                &nbsp;
                <Link to = "/buyAndSell" className="btn btn-dark mb-3">Alış Satış Listesi</Link>
                
            </div>

            <table className="table table-bordered table striped">

            <thead>
                    <tr>
                        <th>Ürün Adı</th>
                        <th>Alış Fİyatı</th>
                        <th>Satış Fiyatı</th>
                        <th>Toptancı Adı</th>                       
                    </tr>    
                </thead>
                <tbody>
                    {
                        products.map(
                            product =>
                            <tr key={product.productId}>
                                <td>{product.productName}</td>
                                <td>{product.buyingPrice}</td>
                                <td>{product.salePrice}</td>
                                <td>{product.companyName}</td>
                                <td>
                                    <Link className="btn btn-info" to={`/edit-products/${product.productId}`}>Güncelle</Link>
                                    &nbsp;
                                    <Link className="btn btn-danger" onClick={()=>deleteProduct(product.productId)}>Sil</Link>
                                </td>
                            </tr>
                        )
                    }
                </tbody>

            </table>
        </div>
    )

}
export default ListProductComponent