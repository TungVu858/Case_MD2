package manage;

import file.FileRoleCSV;
import file.Path;
import model.Role;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageRole {
    private List<Role> roles = new ArrayList<>();

    public ManageRole() throws IOException {
        roles = FileRoleCSV.readFromFile(Path.PATH_ROLE);
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void add(Role role) {
        roles.add(role);
    }

    public int findByIndexId(int id) {
        for (int i = 0; i < roles.size(); i++) {
            if (id == roles.get(i).getIdRole()) {
                return i;
            }
        }
        return -1;
    }

    public Role findById(int id) {
        return roles.get(findByIndexId(id));
    }

    public int findByNameRole(String name) {
        for (int i = 0; i < roles.size(); i++) {
            if (name.equals(roles.get(i).getNameRole())) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int id) {
        roles.remove(findByIndexId(id));
    }

    public void edit(int id, Role role) {
        roles.set(findByIndexId(id), role);
    }

    public void displayAll() {
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    public void displayRole(int id) {
        for (Role role : roles) {
            if (id == role.getIdRole()) {
                System.out.println(role);
            }
        }
    }
}
