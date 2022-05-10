package model;

public class CarName {
    private int id;
    private String name;

    public CarName() {
    }

    public CarName(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CarName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
