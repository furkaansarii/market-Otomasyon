import React ,{useState, useEffect} from 'react'
import { Link } from 'react-router-dom';
import { useHistory, useParams } from 'react-router-dom';
import ProductSalesService from '../../services/ProductSalesService';


const AddProductSales = () => {

    const [priceDate, setPriceDate] = useState('')
    const [saleQuantity, setSaleQuantity] = useState('')
    const [productId, setProductId] = useState('')
    const [adminId, setAdminId] = useState('')
    const history = useHistory();
    const {productSalesId} = useParams();

    const saveOrUpdateProductSales = (e) =>{
        e.preventDefault();

        const productSales = {priceDate, saleQuantity, productId, adminId}

        if(productSalesId){

            ProductSalesService.updateProductSales(productSalesId, productSales).then((response)=>{

                history.push('/productSales')
            }).catch(error=>{
                console.log(error);
            })
        }else{
            ProductSalesService.createProductSales(productSales).then((response) =>{

                console.log(response.data)
    
                history.push('/productSales');
                
    
            }).catch(error =>{
                console.log(error)
            })
        }

       
    }

    useEffect(() => {
      ProductSalesService.getProductSalesById(productSalesId).then((response) =>{
        setPriceDate(response.data.priceDate)
        setSaleQuantity(response.data.saleQuantity)
        setProductId(response.data.productId)
        setAdminId(response.data.adminId)
      }).catch(error =>{
          console.log(error)
      })
    }, [])

    const title = () =>{
        if(productSalesId){
            return <h2 className="text-center">Satış Güncelle</h2>
        }else{
            return <h2 className="text-center">Satış Ekle</h2>
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
                                <label className="form-label">Satış Tarihi :</label>
                                <input
                                        type = "text"
                                        placeholder = "Satış Tarihi Girin"
                                        name = "priceDate"
                                        className = "form-control"
                                        value = {priceDate}
                                        onChange = {(e) => setPriceDate(e.target.value)}
                                    >
                                    </input>

                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Satış Miktarı :</label>
                                <input
                                        type = "text"
                                        placeholder = "Satış Miktarı Girin"
                                        name = "saleQuantity"
                                        className = "form-control"
                                        value = {saleQuantity}
                                        onChange = {(e) => setSaleQuantity(e.target.value)}
                                    >
                                    </input>

                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Satılan Ürün Id :</label>
                                <input
                                        type = "text"
                                        placeholder = "Ürün Id Girin"
                                        name = "productId"
                                        className = "form-control"
                                        value = {productId}
                                        onChange = {(e) => setProductId(e.target.value)}
                                    >
                                    </input>

                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">İşlem Yapan Admin Adı :</label>
                                <input
                                        type = "text"
                                        placeholder = "Admin Id Girin"
                                        name = "adminId"
                                        className = "form-control"
                                        value = {adminId}
                                        onChange = {(e) => setAdminId(e.target.value)}
                                    >
                                    </input>

                            </div>

                            <button className="btn btn-success" onClick={(e)=> saveOrUpdateProductSales(e)} >Kaydet</button>
                            &nbsp;
                            <Link to="/productSales" className="btn btn-danger">İptal</Link>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
  )
}

export default AddProductSales