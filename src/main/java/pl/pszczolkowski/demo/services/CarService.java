package pl.pszczolkowski.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pszczolkowski.demo.dao.CarDao;
import pl.pszczolkowski.demo.model.Car;

import java.util.List;

@Service
public class CarService {

    private CarDao carDao;
    private List<Car> dbCars;

    @Autowired
    public CarService(CarDao carDao) {
        this.carDao = carDao;
        this.dbCars = carDao.getAll();

//        carDao.saveCar(1, "Kia", "Ceed", "Red", 2005);
//        carDao.saveCar(2, "BMW", "E91", "Red", 2007);
//        carDao.saveCar(3, "Fiat", "Punto", "Blue", 2009);
//        carDao.saveCar(4, "Dacia", "Duster", "Green", 2012);
//        List<Car> all = carDao.getByDate(2006,2009);
//        all.forEach(System.out::println);
    }

    public List<Car> getDbCars(){
        dbCars = carDao.getAll();
        return dbCars;
    }

    public List<Car> getCarsByDateDb(int since, int to){
        return carDao.getByDate(since, to);
    }

    public void addCarDb(Car car){
        carDao.saveCar(car.getId(), car.getMark(), car.getModel(), car.getColor(), car.getProductionDate());
    }
}
