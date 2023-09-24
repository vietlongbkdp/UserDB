package DAO;

import model.EGender;
import model.Role;
import model.User;
import service.RoleService;
import service.UserService;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDAO extends ConnectionDatabase{
    public List<User> getAllUser(){
        List<User> userList = new ArrayList<>();
        String SELECT_ALL_USER = "SELECT * FROM users";
//        RoleService roleService = new RoleService();
        RoleDAO roleDAO = new RoleDAO();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                userList.add(new User(resultSet.getInt("id"), resultSet.getString("firstName"),
                        resultSet.getString("lastName"), resultSet.getString("userName"),
                        resultSet.getString("email"), LocalDate.parse(resultSet.getString("dob")),
                        roleDAO.findRoleById(resultSet.getInt("roleId")), EGender.valueOf(resultSet.getString("gender")),
                        Boolean.parseBoolean(resultSet.getString("deleted"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

//    public static void main(String[] args) {
//        UserDAO userDAO = new UserDAO();
//        List<User> userList = userDAO.getAllUser();
//        System.out.println(userList.stream().filter(user -> user.getId() == 4).findFirst().orElse(null).getRole().getRoles());
//    }

    public void createUser(User user){
        String ADD_NEW_USER = "INSERT INTO `userdb`.`users` (`firstName`, `lastName`, `userName`, `email`, `doB`, `roleId`, `gender`, `deleted`) VALUES (?, ?, ?, ?, ?, ?, ?,'false');";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_USER);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setDate(5, Date.valueOf(user.getDoB()));
            preparedStatement.setInt(6, user.getRole().getId());
            preparedStatement.setString(7, String.valueOf(user.getGender()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    public void deleteUserById(int idDelete) {
        String DELETE_USER = "UPDATE `userdb`.`users` SET deleted = 'true' WHERE id = ?";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setInt(1, idDelete);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public List<User> getAllUserShow(boolean deleted) {
        return getAllUser().stream().filter(user -> user.isDeleted() == deleted).collect(Collectors.toList());
    }

    public void restoreListId(List<Integer> listIdRestore){
        String RESTORE_BY_ID = "UPDATE `userdb`.`users` SET deleted = 'false' WHERE id = ?";
        try {
            for (Integer i: listIdRestore) {
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(RESTORE_BY_ID);
                preparedStatement.setInt(1, i);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public User getUserById(int id) {
        String SELECT_USER_BY_ID = "SELECT * FROM `userdb`.`users` WHERE id = ?";
        RoleDAO roleDAO = new RoleDAO();
        User user = new User();
        Connection connection =getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setUserName(resultSet.getString("userName"));
                user.setEmail(resultSet.getString("email"));
                user.setDoB(LocalDate.parse(resultSet.getString("doB")));
                user.setRole(roleDAO.findRoleById(resultSet.getInt("roleId")));
                user.setGender(EGender.valueOf(resultSet.getString("gender")));
                user.setDeleted(false);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;

    }

    public void editUser(User user, int id) {
        String UPDATE_BY_ID = "UPDATE `userdb`.`users` SET `firstName` = ?, `lastName` = ?, `userName` = ?, `email` = ?, `doB` = ?, `roleId` = ?, `gender` = ? WHERE (`id` = ?)";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setDate(5, Date.valueOf(user.getDoB()));
            preparedStatement.setInt(6, user.getRole().getId());
            preparedStatement.setString(7, String.valueOf(user.getGender()));
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
