package web.DAO;

import org.springframework.stereotype.Repository;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private static List<Car> car = new ArrayList<>();

    {
        car.add(new Car("Toyota", "red", 2020));
        car.add(new Car("Nissan", "green", 2018));
        car.add(new Car("Mercedes", "black", 2016));
        car.add(new Car("Volvo", "red", 2012));
        car.add(new Car("Honda", "green", 2016));
    }


    @Override
    public List<Car> getAllCars() {
        return car;
    }

    @Override
    public List<Car> getCars(int count) {

        if (count >= 5 || count < 0) {
            return car;
        }
        return car.stream()
                .limit(count)
                .toList();
    }

}
