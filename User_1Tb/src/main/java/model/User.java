package model;

import java.time.LocalDate;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private LocalDate doB;
    private Role roles;
    private EGender gender;
    private boolean deleted;
    private String password;

    public User() {
    }

    public User(int id, String firstName, String lastName, String userName, String email, LocalDate doB, Role roles, EGender gender, boolean deleted, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.doB = doB;
        this.roles = roles;
        this.gender = gender;
        this.deleted = deleted;
        this.password= password;
    }
    public User(int id, String firstName, String lastName, String userName, String email, LocalDate doB, Role roles, EGender gender, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.doB = doB;
        this.roles = roles;
        this.gender = gender;
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDoB() {
        return doB;
    }

    public void setDoB(LocalDate doB) {
        this.doB = doB;
    }

    public Role getRole() {
        return roles;
    }

    public void setRole(Role roles) {
        this.roles = roles;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
