package service;

import DAO.ProductDAO;
import DAO.StorageDAO;
import model.Product;
import model.Storage;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    ProductDAO productDAO = new ProductDAO();
    private List<Product> productList = new ArrayList<>();
    public Product getProductById(int id){
        productList =  productDAO.getAllProductT();
        return productList.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }
}
