import React, { useState } from 'react'
import { Link } from 'react-router-dom';
import WholesalerService from '../../services/WholesalerService';



const GetByNameProduct = () => {

    const [wholesalers, setWholesalers] = useState([])
    const [companyName, setCompanyName] = useState("")

    const findByCompanyName = () => {

        WholesalerService.getByNameProduct(companyName).then((response) => {

            setWholesalers(response.data)


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

                            <h2 className="text-center">Şirket Adına Göre Ara</h2>
                            <div className="card-body">

                                <div className="form-group mb-2">
                                    <label className="form-label">Şirket Adı :</label>
                                    <input
                                        type="text"
                                        placeholder="Şirket Adı Girin"
                                        name="companyName"
                                        className="form-control"

                                        onChange={(e) => setCompanyName(e.target.value)}>
                                    </input>

                                </div>




                                <button className="btn btn-success" onClick={() => findByCompanyName()}>Ara</button>
                                &nbsp;
                                <Link to="/wholesaler" className="btn btn-danger">İptal</Link>

                            </div>
                        </div>
                    </div>
                    <div>
                        
                            <table className="table table-bordered table striped">
                        <thead>
                            <tr>
                                <th>Ürün Adı</th>
                                <th>Şirket Adı</th>

                            </tr>
                        </thead>
                        <tbody>
                            {
                                wholesalers.map(
                                    wholesaler =>
                                <tr>   
                               <td>{wholesaler.productName}</td>
                               <td>{wholesaler.companyName}</td>
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
export default GetByNameProduct
