package pl.pszczolkowski.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pszczolkowski.demo.services.CarService;
import pl.pszczolkowski.demo.model.Car;

import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin("*")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCars(){
        return carService.getDbCars();
    }

    @GetMapping("/{since}/{to}")
    public List<Car> getCarsByDate(@PathVariable int since, @PathVariable int to){
        return carService.getCarsByDateDb(since, to);
    }

    @PostMapping
    public Car addCar(@RequestBody Car car){
        carService.addCarDb(car);
        return car;
    }

}
