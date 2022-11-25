import React, { useState } from 'react'
import { Link } from 'react-router-dom';
import EmployeeService from '../../services/EmployeeService';





const GetByMission = () => {

    const [employees, setEmployees] = useState([])
    const [mission, setMission] = useState("")

    const findByCompanyName = () => {

        EmployeeService.getByMission(mission).then((response) => {

            setEmployees(response.data)


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

                            <h2 className="text-center">Pozisyona Göre Çalışan</h2>
                            <div className="card-body">

                                <div className="form-group mb-2">
                                    <label className="form-label">Pozisyon :</label>
                                    <input
                                        type="text"
                                        placeholder="Pozisyon Girin"
                                        name="mission"
                                        className="form-control"

                                        onChange={(e) => setMission(e.target.value)}>
                                    </input>

                                </div>




                                <button className="btn btn-success" onClick={() => findByCompanyName()}>Ara</button>
                                &nbsp;
                                <Link to="/employee" className="btn btn-danger">İptal</Link>

                            </div>
                        </div>
                    </div>
                    <div>
                        
                            <table className="table table-bordered table striped">
                        <thead>
                            <tr>
                                
                                <th>Çalışan Adı</th>
                                <th>Çalışan Soyadı</th>
                                <th>Telefon No Miktarı</th>
                                <th>Çalıştığı Ofis</th>
                                <th>Pozisyon</th>

                            </tr>
                        </thead>
                        <tbody>
                            {
                                employees.map(
                                    employee =>
                                <tr>   
                               
                               <td>{employee.employeeFirstName}</td>
                               <td>{employee.employeeLastName}</td>
                               <td>{employee.employeePhoneNumber}</td>
                               <td>{employee.branchOffice}</td>
                               <td>{employee.mission}</td>
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
export default GetByMission
