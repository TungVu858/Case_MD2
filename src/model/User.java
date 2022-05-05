package model;

import model.Role;

public class User {
    private int idUsers;
    private String userName;
    private String userPass;
    private String status;
    private Role role;

    public User() {
    }

    public User(int idUsers, String userName, String userPass, String status, Role role) {
        this.idUsers = idUsers;
        this.userName = userName;
        this.userPass = userPass;
        this.status = status;
        this.role = role;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return idUsers + "," + userName + "," + userPass + "," + status + "," + role.getIdRole() + "\n";
    }
}
