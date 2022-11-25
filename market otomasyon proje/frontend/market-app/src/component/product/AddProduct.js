import React,{ useEffect, useState } from 'react'
import { Link } from 'react-router-dom';
import { useParams } from "react-router-dom"
import { useHistory } from "react-router-dom"
import ProductService from "../../services/ProductService"



const AddProduct = () => {
    const [productName, setProductName] = useState('')
    const [buyingPrice, setBuyingPrice] = useState('')
    const [buyingQuantity, setBuyingQuantity] = useState('')
    const [salePrice, setSalePrice] = useState('')
    const [wholesalerId, setWholesalerId] = useState('')
    const [adminId, setAdminId] = useState('')
    const history = useHistory();
    const { productId } = useParams();

    const saveOrUpdateProduct = (e) => {
        e.preventDefault();


        const product = { productName, buyingPrice, buyingQuantity, salePrice, wholesalerId, adminId }

        if (productId) {
            ProductService.updateProduct(productId, product).then((response) => {
                history.push('/products')
            }).catch(error => {
                console.log(error);
            })
        } else {
            ProductService.createProduct(product).then((response) => {
                console.log(response.data)
                history.push('/products');
            }).catch(error => {
                console.log(error)
            })
        }
    }

    useEffect(() => {
        ProductService.getProductById(productId).then((response) => {
            setProductName(response.data.productName)
            setBuyingPrice(response.data.buyingPrice)
            setBuyingQuantity(response.data.buyingQuantity)
            setSalePrice(response.data.salePrice)
            setWholesalerId(response.data.wholesalerId)
            setAdminId(response.data.adminId)

        }).catch(error => {
            console.log(error)
        })
    }, [])

    const title = () => {
        if (productId) {
            return <h2 className="text-center">Ürün Güncelle</h2>
        } else {
            return <h2 className="text-center">Ürün Ekle</h2>
        }
    }

    return (
        <div>
            <br></br>
            <div className="container">
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        {
                            title()
                        }
                        <div className="card-body">
                            <form>
                                <div className="form-group mb-2">
                                    <label className="form-label">Ürün Adı :</label>
                                    <input
                                        type="text"
                                        placeholder="Ürün Adı Girin"
                                        name="product"
                                        className="form-control"
                                        value={productName}
                                        onChange={(e) => setProductName(e.target.value)}
                                    >
                                    </input>

                                </div>

                                <div className="form-group mb-2">
                                    <label className="form-label">Alış Fiyatı :</label>
                                    <input
                                        type="text"
                                        placeholder="Alış Fiyatı Girin"
                                        name="buyingPrice"
                                        className="form-control"
                                        value={buyingPrice}
                                        onChange={(e) => setBuyingPrice(e.target.value)}
                                    >
                                    </input>

                                </div>

                                <div className="form-group mb-2">
                                    <label className="form-label">Alış Miktarı :</label>
                                    <input
                                        type="text"
                                        placeholder="Alış Miktarı Girin"
                                        name="buyingQuantity"
                                        className="form-control"
                                        value={buyingQuantity}
                                        onChange={(e) => setBuyingQuantity(e.target.value)}
                                    >
                                    </input>

                                </div>

                                <div className="form-group mb-2">
                                    <label className="form-label">Satış Fiyatı :</label>
                                    <input
                                        type="text"
                                        placeholder="Satış Fiyatı Girin"
                                        name="salePrice"
                                        className="form-control"
                                        value={salePrice}
                                        onChange={(e) => setSalePrice(e.target.value)}
                                    >
                                    </input>

                                </div>

                                <div className="form-group mb-2">
                                    <label className="form-label">Toptancı Id :</label>
                                    <input
                                        type="text"
                                        placeholder="Toptancı Id Girin"
                                        name="wholesalerId"
                                        className="form-control"
                                        value={wholesalerId}
                                        onChange={(e) => setWholesalerId(e.target.value)}
                                    >
                                    </input>

                                </div>

                                <div className="form-group mb-2">
                                    <label className="form-label">Kullanıcı Id :</label>
                                    <input
                                        type="text"
                                        placeholder="Kullanıcı Id Girin"
                                        name="adminId"
                                        className="form-control"
                                        value={adminId}
                                        onChange={(e) => setAdminId(e.target.value)}
                                    >
                                    </input>

                                </div>
                                <button className="btn btn-success" onClick={(e)=> saveOrUpdateProduct(e)} >Kaydet</button>
                                &nbsp;
                                <Link to="/products" className="btn btn-danger">İptal</Link>


                            </form>

                        </div>


                    </div>



                </div>
            </div>


        </div>

    )
}
export default AddProduct