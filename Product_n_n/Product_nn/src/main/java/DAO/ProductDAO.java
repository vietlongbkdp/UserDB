package DAO;

import model.ECategory;
import model.Product;
import model.ProductStorage;
import model.Storage;
import service.StorageService;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends ConectionDB{
    ProductStorageDAO productStorageDAO = new ProductStorageDAO();
    StorageService storageService = new StorageService();
    public List<Product> getAllProductT(){
        List<Product> productList = new ArrayList<>();
        String SELECT_ALL_PRODUCT = "SELECT * FROM products";
//        RoleService roleService = new RoleService();
//        RoleDAO roleDAO = new RoleDAO();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                productList.add(new Product(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getBigDecimal("price"), resultSet.getString("description"),
                        ECategory.valueOf(resultSet.getString("category"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return productList;
    }
    public Product getProductbyId(int id){
        List<Product> productList = getAllProductT();
        Product product = productList.stream().filter(product1 -> product1.getId() == id).findFirst().orElse(null);
        List<Storage> storageList = storageService.getStorageListByPSList(productStorageDAO.getAllProductStorageById(id));
        if (product != null) {
            product.setStorageList(storageList);
        }
        return product;
    }

    public List<Product> getAllProductD(){
        List<Product> productList = new ArrayList<>();
        String SELECT_ALL_PRODUCT = "SELECT * FROM products";
//        RoleService roleService = new RoleService();
//        RoleDAO roleDAO = new RoleDAO();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                productList.add(getProductbyId(resultSet.getInt("id")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return productList;
    }


}
