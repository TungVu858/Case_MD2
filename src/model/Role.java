package model;

public class Role {

    private int idRole;
    private String nameRole;
    private String description;

    public Role() {
    }

    public Role(int idRole, String nameRole, String description) {
        this.idRole = idRole;
        this.nameRole = nameRole;
        this.description = description;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return idRole +
                "," + nameRole +"," + description +
                "\n";
    }
}
