package DAO;

import model.ECategory;
import model.Product;
import model.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StorageDAO extends ConectionDB{
    public List<Storage> getAllStorage(){
        List<Storage> storageList = new ArrayList<>();
        String SELECT_ALL_storages = "SELECT * FROM storages";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_storages);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                storageList.add(new Storage(resultSet.getInt("id"), resultSet.getString("nameStorage")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return storageList;
    }
    public Storage getStorageById(int id){
        String SELECT_storages_BY_ID = "SELECT * FROM storages WHERE `productId` = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_storages_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return new Storage(resultSet.getInt("id"), resultSet.getString("nameStorage"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
