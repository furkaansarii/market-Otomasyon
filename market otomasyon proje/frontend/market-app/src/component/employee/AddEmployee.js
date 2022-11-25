import React ,{useState, useEffect} from 'react'
import { Link } from 'react-router-dom';
import { useHistory, useParams } from 'react-router-dom';
import EmployeeService from '../../services/EmployeeService';


const AddEmployee = () => {

    const [employeeFirstName, setEmployeeFirstName] = useState('')
    const [employeeLastName, setEmployeeLastName] = useState('')
    const [employeePhoneNumber, setEmployeePhoneNumber] = useState('')
    const [branchOffice, setBranchOffice] = useState('')
    const [salary, setSalary] = useState('')
    const [mission, setMission] = useState('')
    const [adminId, setAdminId] = useState('')
    const history = useHistory();
    const {employeeId} = useParams();

    const saveOrUpdateHome = (e) =>{
        e.preventDefault();

        const employee = {employeeFirstName, employeeLastName, employeePhoneNumber, branchOffice, salary, mission, adminId}

        if(employeeId){

            EmployeeService.updateEmployee(employeeId, employee).then((response)=>{

                history.push('/employee')
            }).catch(error=>{
                console.log(error);
            })
        }else{
            EmployeeService.createEmployee(employee).then((response) =>{

                console.log(response.data)
    
                history.push('/employee');
                
    
            }).catch(error =>{
                console.log(error)
            })
        }

       
    }

    useEffect(() => {
      EmployeeService.getEmployeeById(employeeId).then((response) =>{
          setEmployeeFirstName(response.data.employeeFirstName)
          setEmployeeLastName(response.data.employeeLastName)
          setEmployeePhoneNumber(response.data.employeePhoneNumber)
          setBranchOffice(response.data.branchOffice)
          setSalary(response.data.salary)
          setMission(response.data.mission)
          setAdminId(response.data.adminId)
      }).catch(error =>{
          console.log(error)
      })
    }, [])

    const title = () =>{
        if(employeeId){
            return <h2 className="text-center">Çalışan Güncelle</h2>
        }else{
            return <h2 className="text-center">Çalışan Ekle</h2>
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
                                <label className="form-label">Ad :</label>
                                <input
                                        type = "text"
                                        placeholder = "İsim Girin"
                                        name = "employeeFirstName"
                                        className = "form-control"
                                        value = {employeeFirstName}
                                        onChange = {(e) => setEmployeeFirstName(e.target.value)}
                                    >
                                    </input>

                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Soyad :</label>
                                <input
                                        type = "text"
                                        placeholder = "Soyisim Girin"
                                        name = "employeeLastName"
                                        className = "form-control"
                                        value = {employeeLastName}
                                        onChange = {(e) => setEmployeeLastName(e.target.value)}
                                    >
                                    </input>

                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Telefon No :</label>
                                <input
                                        type = "text"
                                        placeholder = "Telefon No Girin"
                                        name = "employeePhoneNumber"
                                        className = "form-control"
                                        value = {employeePhoneNumber}
                                        onChange = {(e) => setEmployeePhoneNumber(e.target.value)}
                                    >
                                    </input>

                            </div>
                            <div className="form-group mb-2">
                                <label className="form-label">Şube :</label>
                                <input
                                        type = "text"
                                        placeholder = "Şube Girin"
                                        name = "branchOffice"
                                        className = "form-control"
                                        value = {branchOffice}
                                        onChange = {(e) => setBranchOffice(e.target.value)}
                                    >
                                    </input>

                            </div>
                            <div className="form-group mb-2">
                                <label className="form-label">Maaş :</label>
                                <input
                                        type = "text"
                                        placeholder = "Maaş Girin"
                                        name = "salary"
                                        className = "form-control"
                                        value = {salary}
                                        onChange = {(e) => setSalary(e.target.value)}
                                    >
                                    </input>

                            </div>
                            <div className="form-group mb-2">
                                <label className="form-label">Pozisyon :</label>
                                <input
                                        type = "text"
                                        placeholder = "Mahalle Girin"
                                        name = "mission"
                                        className = "form-control"
                                        value = {mission}
                                        onChange = {(e) => setMission(e.target.value)}
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

                            <button className="btn btn-success" onClick={(e)=> saveOrUpdateHome(e)} >Kaydet</button>
                            &nbsp;
                            <Link to="/employee" className="btn btn-danger">İptal</Link>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
  )
}

export default AddEmployee