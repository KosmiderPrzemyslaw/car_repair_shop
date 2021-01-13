package dao;

import model.Car;
import util.DbUtil;

import java.sql.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    public List<Car> findAll() {
        try {
            List<Car> cars = new ArrayList<>();
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM car");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model"));
                car.setMark(resultSet.getString("mark"));
                car.setYearOfProduction(Year.of(resultSet.getInt("yearOfProduction")));
                car.setRegistrationNumber(resultSet.getString("registrationNumber"));
                car.setNextInspection(resultSet.getObject("nextInspection", LocalDate.class));
                cars.add(car);

            }
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Car create(Car car) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Car_repair_shop.car(customer_id, model, mark, yearOfProduction, registrationNumber, nextInspection) VALUES (?,?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, car.getCustomerId());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setString(3, car.getMark());
            preparedStatement.setObject(4, car.getYearOfProduction());
            preparedStatement.setString(5, car.getRegistrationNumber());
            preparedStatement.setObject(6, car.getNextInspection());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                car.setId(resultSet.getInt(1));
            }
            return car;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
