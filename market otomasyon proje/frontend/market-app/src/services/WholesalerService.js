import axios from 'axios'

const WHOLESALER_BASE_REST_API_URL = 'http://localhost:8080/api/wholesaler';

class WholesalerService{

    getAllWholesaler(){
        return axios.get(WHOLESALER_BASE_REST_API_URL)
    }

    createWholesaler(wholesaler){
        return axios.post(WHOLESALER_BASE_REST_API_URL, wholesaler)
    }

    getWholesalerById(wholesalerId){
        return axios.get(WHOLESALER_BASE_REST_API_URL + '/' + wholesalerId);
    }

    updateWholesaler(wholesalerId, wholesaler){
        return axios.put(WHOLESALER_BASE_REST_API_URL + '/' + wholesalerId, wholesaler);
    }

    deleteWholesaler(wholesalerId){
        return axios.delete(WHOLESALER_BASE_REST_API_URL+'/'+wholesalerId);
    }
    getByNameProduct(companyName){
        return axios.get('http://localhost:8080/api/wholesaler/wholesaler-getPrdouct?companyName=' + companyName)
    }
    getByWholesalerInfo(companyName){
        return axios.get('http://localhost:8080/api/wholesaler/wholesaler-name?companyName=' + companyName)
    }
}

export default new WholesalerService();