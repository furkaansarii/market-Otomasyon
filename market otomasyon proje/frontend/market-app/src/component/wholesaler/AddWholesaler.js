import React ,{useState, useEffect} from 'react'
import { Link } from 'react-router-dom';
import { useHistory, useParams } from 'react-router-dom';
import WholesalerService from '../../services/WholesalerService';


const AddWholesaler = () => {

    const [companyName, setCompanyName] = useState('')
    const [phoneNumber, setPhoneNumber] = useState('')
    const [address, setAddress] = useState('')
    const [adminId, setAdminId] = useState('')
    const history = useHistory();
    const {wholesalerId} = useParams();

    const saveOrUpdateWholesaler = (e) =>{
        e.preventDefault();

        const wholesaler = {companyName, phoneNumber, address, adminId}

        if(wholesalerId){

            WholesalerService.updateWholesaler(wholesalerId, wholesaler).then((response)=>{

                history.push('/wholesaler')
            }).catch(error=>{
                console.log(error);
            })
        }else{
            WholesalerService.createWholesaler(wholesaler).then((response) =>{

                console.log(response.data)
    
                history.push('/wholesaler');
                
    
            }).catch(error =>{
                console.log(error)
            })
        }

       
    }

    useEffect(() => {
      WholesalerService.getWholesalerById(wholesalerId).then((response) =>{
        setCompanyName(response.data.companyName)
        setPhoneNumber(response.data.phoneNumber)
        setAddress(response.data.address)
        setAdminId(response.data.adminId)
      }).catch(error =>{
          console.log(error)
      })
    }, [])

    const title = () =>{
        if(wholesalerId){
            return <h2 className="text-center">Toptancı Güncelle</h2>
        }else{
            return <h2 className="text-center">Toptancı Ekle</h2>
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
                                <label className="form-label">Şirket Adı :</label>
                                <input
                                        type = "text"
                                        placeholder = "Şirket Girin"
                                        name = "companyName"
                                        className = "form-control"
                                        value = {companyName}
                                        onChange = {(e) => setCompanyName(e.target.value)}
                                    >
                                    </input>

                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Telefon No :</label>
                                <input
                                        type = "text"
                                        placeholder = "Telefon Girin"
                                        name = "phoneNumber"
                                        className = "form-control"
                                        value = {phoneNumber}
                                        onChange = {(e) => setPhoneNumber(e.target.value)}
                                    >
                                    </input>

                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Adres :</label>
                                <input
                                        type = "text"
                                        placeholder = "Adres Girin"
                                        name = "address"
                                        className = "form-control"
                                        value = {address}
                                        onChange = {(e) => setAddress(e.target.value)}
                                    >
                                    </input>

                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Admin Id :</label>
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

                            <button className="btn btn-success" onClick={(e)=> saveOrUpdateWholesaler(e)} >Kaydet</button>
                            &nbsp;
                            <Link to="/wholesaler" className="btn btn-danger">İptal</Link>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
  )
}

export default AddWholesaler