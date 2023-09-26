package DAO;

import model.ECategory;
import model.Product;
import model.ProductStorage;
import service.ProductService;
import service.StorageService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductStorageDAO extends ConectionDB{
//    public List<Product> getAllProductById(int id){
//        List<Product> productListId = new ArrayList<>();
//        String SELECT_ALL_PRODUCT_BY_ID = "SELECT p.*, ps.storageId FROM  products p join product_storages ps on p.id = ps.productId where p.id = ?;";
//        StorageService storageService = new StorageService();
//        StorageDAO storageDAO = new StorageDAO();
//
//        Connection connection = getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT_BY_ID);
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                productListId.add(new Product(resultSet.getInt("id"), resultSet.getString("name"),
//                        resultSet.getBigDecimal("price"), resultSet.getString("description"),
//                        ECategory.valueOf(resultSet.getString("category")), storageDAO.getStorageById(resultSet.getInt("storageId"))));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return productListId;
//    }
    public List<ProductStorage> getAllProductStorageById(int id){
        List<ProductStorage> productStorageList = new ArrayList<>();
        String SELECT_ALL_PRODUCTSTORAGE_BY_ID = "SELECT * FROM product_storages WHERE id = ?;";
        StorageService storageService = new StorageService();
        ProductService productService = new ProductService();
        StorageDAO storageDAO = new StorageDAO();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTSTORAGE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                productStorageList.add(new ProductStorage(resultSet.getInt("id"), productService.getProductById(resultSet.getInt("productId")), storageService.getStorageById(resultSet.getInt("storageId")), resultSet.getInt("quantity")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return productStorageList;
    }

    public List<ProductStorage> getAllProductStorage(){
        List<ProductStorage> productStorageList = new ArrayList<>();
        String SELECT_ALL_PRODUCTSTORAGE = "SELECT * FROM product_nn.product_storages";
        StorageService storageService = new StorageService();
        ProductService productService = new ProductService();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTSTORAGE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                productStorageList.add(new ProductStorage(resultSet.getInt("id"), productService.getProductById(resultSet.getInt("productId")), storageService.getStorageById(resultSet.getInt("storageId")), resultSet.getInt("quantity")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return productStorageList;
    }
}
