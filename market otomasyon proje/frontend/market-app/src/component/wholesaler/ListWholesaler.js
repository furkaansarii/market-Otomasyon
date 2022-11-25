import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import WholesalerService from '../../services/WholesalerService'



const ListWholesaler = () =>{

    const [wholesalers, setWholesalers] = useState([])

    useEffect(() => {
      
        getAllWholesaler();
    }, [])

    const getAllWholesaler = ()=>{
        WholesalerService.getAllWholesaler().then((response) =>{
            setWholesalers(response.data)
            console.log(response.data);
        }).catch(error =>{
            console.log(error);
        })
    }

    const deleteWholesaler = (wholesalerId) =>{
        WholesalerService.deleteWholesaler(wholesalerId).then((response)=>{
            getAllWholesaler();
        }).catch(error=>{
            console.log(error);
        })
    }
    

    return(
        <div className="container">
            <h2 className="text-center">Toptancı Listesi</h2>
            <div>
                <Link to = "/add-wholesaler" className="btn btn-dark mb-3">Toptancı Ekle</Link>
                &nbsp;
                <Link to = "/wholesalerInfo" className="btn btn-dark mb-3">Toptancı Bilgileri</Link>
                &nbsp;
                <Link to = "/getByNameProduct" className="btn btn-dark mb-3">Markaya Göre Ürün</Link>
                
            </div>
           
                
           
            
            <table className="table table-bordered table striped">
                <thead>
                    <tr>
                        <th>Şirket Adı</th>
                        <th>Telefon No</th>
                        <th>Adres</th>
                        <th>Admin Id</th>
                        
                    </tr>    
                </thead>
                <tbody>
                    {
                        wholesalers.map(
                            wholesaler=>
                            <tr key ={wholesaler.wholesalerId}>
                                <td>{wholesaler.companyName}</td>
                                <td>{wholesaler.phoneNumber}</td>
                                <td>{wholesaler.address}</td>
                                <td>{wholesaler.adminId}</td>
                                <td>
                                    
                                    <Link className="btn btn-info" to={`/edit-wholesaler/${wholesaler.wholesalerId}`} >Güncelle</Link>
                                    &nbsp;
                                    <Link className="btn btn-danger" onClick={()=>deleteWholesaler(wholesaler.wholesalerId)}>Sil</Link>

                                </td>

                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListWholesaler