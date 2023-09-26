package DAO;

import model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends ConnectionDatabase{
    public List<Role> getAllRole(){
        List<Role> roleList = new ArrayList<>();
        String SELECT_ALL_ROLE = "SELECT * FROM roles";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROLE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                roleList.add(new Role(resultSet.getInt("id"), resultSet.getString("roleName")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return roleList;
    }
    public Role findRoleById(int id){
        String SELECT_ROLE_BY_ID = "SELECT * FROM roles WHERE id = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Role(resultSet.getInt("id"), resultSet.getString("roleName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Role findRoleByRoleName(String nameRole){
        String SELECT_ROLE_BY_ROLENAME = "SELECT * FROM roles WHERE roleName = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE_BY_ROLENAME);
            preparedStatement.setString(1, nameRole);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Role(resultSet.getInt("id"), resultSet.getString("roleName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



}
