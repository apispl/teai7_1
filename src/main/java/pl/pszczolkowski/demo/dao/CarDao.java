package pl.pszczolkowski.demo.dao;

import pl.pszczolkowski.demo.model.Car;

import java.util.List;

//CRUD
public interface CarDao {

    void saveCar(long id, String mark, String model, String color, int productionDate);
    List<Car> getAll();
    Car getCar(long id);
    void editCar(Car car);
    void deleteCar(Long id);
    List<Car> getByDate(int since, int to);

}
