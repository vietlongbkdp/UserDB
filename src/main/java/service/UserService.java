package service;

import DAO.RoleDAO;
import DAO.UserDAO;
import model.EGender;
import model.Role;
import model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    private  List<User> userList;
    RoleDAO roleDAO = new RoleDAO();

    public List<User> getAllUser(){
        return userDAO.getAllUser();
    }
    public User createUser(String lastName, String firstName, String userName, String email, String dob, String gender, int role){
        User user = new User();
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setUserName(userName);
        user.setEmail(email);
        user.setDoB(LocalDate.parse(dob));
        user.setGender(EGender.valueOf(gender));
        user.setRole(roleDAO.findRoleById(role));
        user.setDeleted(false);
        return user;
    }

}
