import axios from "axios";

const EMPLOYEE__BASE_REST_API_URL = 'http://localhost:8080/api/employee';

class EmployeeService{
    getAllEmployee(){
        return axios.get(EMPLOYEE__BASE_REST_API_URL)
    }

    createEmployee(employee){
        return axios.post(EMPLOYEE__BASE_REST_API_URL, employee)
    }

    getEmployeeById(employeeId){
        return axios.get(EMPLOYEE__BASE_REST_API_URL + '/' + employeeId);
    }

    updateEmployee(employeeId, employee){
        return axios.put(EMPLOYEE__BASE_REST_API_URL + '/' + employeeId, employee);
    }

    deleteEmployee(employeeId){
        return axios.delete(EMPLOYEE__BASE_REST_API_URL+'/'+employeeId);
    }
    getBySalary(salary){
        return axios.get('http://localhost:8080/api/employee/employee-getBySalary?salary='+salary);
    }
    getByMission(mission){
        return axios.get('http://localhost:8080/api/employee/employee-getByMission?mission=' + mission);
    }
}

export default new EmployeeService();