import axios from "axios";

const PRODUCT_BASE_REST_API_URL = 'http://localhost:8080/api/product';
class ProductService{
    getAllProducts(){
        return axios.get(PRODUCT_BASE_REST_API_URL)
    }

    createProduct(product){
        return axios.post(PRODUCT_BASE_REST_API_URL, product)
    }
    getProductById(productId){
        return axios.get(PRODUCT_BASE_REST_API_URL + '/' + productId);
    }

    updateProduct(productId, product){
        return axios.put(PRODUCT_BASE_REST_API_URL + '/' + productId, product);
    }

    deleteProduct(productId){
        return axios.delete(PRODUCT_BASE_REST_API_URL + '/' + productId);
    }
    buyAndSell(){
        return axios.get('http://localhost:8080/api/product/product/asc');
    }
    maxProduct(){
        return axios.get('http://localhost:8080/api/product/products/desc')
    }
   
}

export default new ProductService();