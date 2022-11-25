import axios from "axios";

const PRODUCT_SALES_BASE_REST_API_URL = 'http://localhost:8080/api/productSales';

class ProductSalesService{
    getAllProductSales(){
        return axios.get(PRODUCT_SALES_BASE_REST_API_URL)
    }

    createProductSales(productSales){
        return axios.post(PRODUCT_SALES_BASE_REST_API_URL, productSales)
    }

    getProductSalesById(productSalesId){
        return axios.get(PRODUCT_SALES_BASE_REST_API_URL + '/' + productSalesId);
    }

    updateProductSales(productSalesId, productSales){
        return axios.put(PRODUCT_SALES_BASE_REST_API_URL + '/' + productSalesId, productSales);
    }

    deleteProductSales(productSalesId){
        return axios.delete(PRODUCT_SALES_BASE_REST_API_URL+'/'+productSalesId);
    }
    getDate(priceDate){
        return axios.get('http://localhost:8080/api/productSales/productSales-priceDate?priceDate=' + priceDate)
    }
    sallestList(){
        return axios.get('http://localhost:8080/api/productSales/productSales-getTopSelling-desc')
    }
}

export default new ProductSalesService();