package dao;

import model.Car;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    public List<Car> findAll(){
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
                car.setNextInspection(resultSet.getDate("nextInspection"));
                cars.add(car);

            }
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
