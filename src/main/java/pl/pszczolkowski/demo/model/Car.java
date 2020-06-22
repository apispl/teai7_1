package pl.pszczolkowski.demo.model;

public class Car {
    long Id;
    String Mark;
    String model;
    String color;
    int productionDate;

    public Car(long id, String mark, String model, String color, int productionDate) {
        Id = id;
        Mark = mark;
        this.model = model;
        this.color = color;
        this.productionDate = productionDate;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getMark() {
        return Mark;
    }

    public void setMark(String mark) {
        Mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(int productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Id=" + Id +
                ", Mark='" + Mark + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", productionDate=" + productionDate +
                '}';
    }
}
