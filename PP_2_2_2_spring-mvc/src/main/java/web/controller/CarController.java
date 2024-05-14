package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;
import web.Service.CarService;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String getCar1(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        if (count == null) {
            List<Car> allCars = carService.getAllCars();
            model.addAttribute("cars", allCars);
        } else {
            List<Car> cars = carService.getCars(count);
            model.addAttribute("cars", cars);
        }
        return "cars";
    }
}
