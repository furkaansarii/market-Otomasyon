import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import EmployeeService from '../../services/EmployeeService'

const ListEmployeeComponent = () =>{

    const [employees, setEmployees] = useState([])

    useEffect(() => {
      
        getAllEmployees();
    }, [])

    const getAllEmployees = ()=>{
        EmployeeService.getAllEmployee().then((response) =>{
            setEmployees(response.data)
            console.log(response.data);
        }).catch(error =>{
            console.log(error);
        })
    }

    const deleteEmployee = (employeeId) =>{
        EmployeeService.deleteEmployee(employeeId).then((response)=>{
            getAllEmployees();
        }).catch(error=>{
            console.log(error);
        })
    }
    

    return(
        <div className="container">
            <h2 className="text-center">Çalışan Listesi</h2>
            <div>
                <Link to = "/add-employee" className="btn btn-dark mb-3">Çalışan Ekle</Link>
                &nbsp;
                <Link to = "/getBySalary" className="btn btn-dark mb-3">Maaşa Göre Getir</Link>
                &nbsp;
                <Link to = "/getByMission" className="btn btn-dark mb-3">Pozisyona Göre Getir</Link>
                
            </div>
           
                
           
            
            <table className="table table-bordered table striped">
                <thead>
                    <tr>
                        <th>Ad</th>
                        <th>Soyad</th>
                        <th>Telefon No</th>
                        <th>Ofis</th>
                        <th>Maaş</th>
                        <th>Pozisyon</th>
                    </tr>    
                </thead>
                <tbody>
                    {
                        employees.map(
                            employee=>
                            <tr key ={employee.employeeId}>
                                <td>{employee.employeeFirstName}</td>
                                <td>{employee.employeeLastName}</td>
                                <td>{employee.employeePhoneNumber}</td>
                                <td>{employee.branchOffice}</td>
                                <td>{employee.salary}</td>
                                <td>{employee.mission}</td>
                                <td>
                                    
                                    <Link className="btn btn-info" to={`/edit-employees/${employee.employeeId}`} >Güncelle</Link>
                                    &nbsp;
                                    <Link className="btn btn-danger" onClick={()=>deleteEmployee(employee.employeeId)}>Sil</Link>

                                </td>

                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListEmployeeComponent

