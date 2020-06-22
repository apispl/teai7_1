package pl.pszczolkowski.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.pszczolkowski.demo.model.Car;

import java.util.*;

@Repository
public class CarDaoImpl implements CarDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveCar(long id, String mark, String model, String color, int productionDate) {
        Car car = new Car(id, mark, model, color, productionDate);
        String sql = "INSERT INTO cars VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getId(), car.getMark(), car.getModel(), car.getColor(), car.getProductionDate());
    }

    @Override
    public List<Car> getAll() {
        List<Car> carList = new ArrayList<>();
        String sql = "SELECT * FROM cars";
        return getListOfCars(carList, sql);
    }

    @Override
    public Car getCar(long id) {
        String sql = "SELECT * FROM cars WHERE car_id = ?";
        return jdbcTemplate.queryForObject(sql, (resultSet, i) -> new Car(
                resultSet.getLong(1),
                resultSet.getString("mark"),
                resultSet.getString("model"),
                resultSet.getString("color"),
                resultSet.getInt("productionDate")), id);
    }

    @Override
    public void editCar(Car newCar) {
        String sql = "UPDATE cars SET cars.mark=?, cars.model=?, cars.color=?, cars.productionDate=? WHERE cars.car_id = ?";
        jdbcTemplate.update(sql, newCar.getId(), newCar.getMark(), newCar.getModel(), newCar.getColor(), newCar.getProductionDate());
    }

    @Override
    public void deleteCar(Long id) {
        String sql = "DELETE FROM cars WHERE car_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Car> getByDate(int since, int to) {
        List<Car> resultList = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE productionDate >= " + since + " AND productionDate <= " + to;
        return getListOfCars(resultList, sql);
    }

    private List<Car> getListOfCars(List<Car> resultList, String sql) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(objectMap -> resultList.add(new Car(
                Long.parseLong(String.valueOf(objectMap.get("car_id"))),
                String.valueOf(objectMap.get("mark")),
                String.valueOf(objectMap.get("model")),
                String.valueOf(objectMap.get("color")),
                Integer.parseInt(String.valueOf(objectMap.get("productionDate")))
        )));
        return resultList;
    }
}
