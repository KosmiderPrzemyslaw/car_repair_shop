package dao;

import model.Car;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
                car.setYearOfProduction(resultSet.getInt("yearOfProduction"));
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

    public void delete(int carId) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM car WHERE id = ?");
            preparedStatement.setInt(1, carId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Car car) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE car SET customer_id = ?, model = ?, mark = ?, yearOfProduction = ?, registrationNumber = ?, nextInspection = ? WHERE id = ?");
            preparedStatement.setInt(1, car.getCustomerId());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setString(3, car.getMark());
            preparedStatement.setInt(4, car.getYearOfProduction());
            preparedStatement.setString(5, car.getRegistrationNumber());
            preparedStatement.setObject(6, car.getNextInspection());
            preparedStatement.setInt(7, car.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Car findById(int carId) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM car where id = ?");
            preparedStatement.setInt(1, carId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setCustomerId(resultSet.getInt("customer_id"));
                car.setModel(resultSet.getString("model"));
                car.setMark(resultSet.getString("mark"));
                car.setYearOfProduction(resultSet.getInt("yearOfProduction"));
                car.setRegistrationNumber(resultSet.getString("registrationNumber"));
                car.setNextInspection(resultSet.getObject("nextInspection", LocalDate.class));

                return car;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void assignCarToClient(int clientId, int carId) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE car SET customer_id = ? WHERE id = ?");
            preparedStatement.setInt(1, clientId);
            preparedStatement.setInt(2, carId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
