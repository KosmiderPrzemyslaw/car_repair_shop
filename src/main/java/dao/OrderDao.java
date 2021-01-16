package dao;

import model.Order;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderDao {
    public Order create(Order order) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orderData(" +
                            "dateOfAcceptanceForRepair, scheduledDateForTheStartOfRepair, " +
                            "repairStartDate, employee_id, car_id, descriptionOfTheProblem, " +
                            "repairDescription, status_id,  repairCost, costOfParts, " +
                            "employee_man_hour, numberOfManHours) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, order.getDateOfAcceptanceForRepair());
            preparedStatement.setObject(2, order.getScheduledDateForTheStartOfRepair());
            preparedStatement.setObject(3, order.getRepairStartDate());
            preparedStatement.setInt(4, order.getEmployeeId());
            preparedStatement.setInt(5, order.getCarId());
            preparedStatement.setString(6, order.getDescriptionOfTheProblem());
            preparedStatement.setString(7, order.getRepairDescription());
            preparedStatement.setInt(8, order.getStatusId());
            preparedStatement.setBigDecimal(9, order.getRepairCost());
            preparedStatement.setBigDecimal(10, order.getCostOfParts());
            preparedStatement.setBigDecimal(11, order.getEmployeeManHour());
            preparedStatement.setInt(12, order.getNumberOfManHours());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                order.setId(resultSet.getInt(1));
            }
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int orderId) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE orderData from orderData where id = ?");
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Order order) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update orderData " +
                    "set dateOfAcceptanceForRepair=?," +
                    "scheduledDateForTheStartOfRepair=?," +
                    "repairStartDate=?," +
                    "employee_id=?," +
                    "descriptionOfTheProblem=?," +
                    "repairDescription=?," +
                    "status_id=?," +
                    "car_id=?," +
                    "repairCost=?," +
                    "costOfParts=?," +
                    "employee_man_hour=?," +
                    "numberOfManHours=? " +
                    "where id=?");
            preparedStatement.setObject(1, order.getDateOfAcceptanceForRepair());
            preparedStatement.setObject(2, order.getScheduledDateForTheStartOfRepair());
            preparedStatement.setObject(3, order.getRepairStartDate());
            preparedStatement.setInt(4, order.getEmployeeId());
            preparedStatement.setString(5, order.getDescriptionOfTheProblem());
            preparedStatement.setString(6, order.getRepairDescription());
            preparedStatement.setInt(7, order.getStatusId());
            preparedStatement.setInt(8, order.getCarId());
            preparedStatement.setBigDecimal(9, order.getRepairCost());
            preparedStatement.setBigDecimal(10, order.getCostOfParts());
            preparedStatement.setBigDecimal(11, order.getEmployeeManHour());
            preparedStatement.setInt(12, order.getNumberOfManHours());
            preparedStatement.setInt(13, order.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Order findById(int orderId) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orderData WHERE id = ?");
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setDateOfAcceptanceForRepair(resultSet.getObject("dateOfAcceptanceForRepair", LocalDate.class));
                order.setScheduledDateForTheStartOfRepair(resultSet.getObject("scheduledDateForTheStartOfRepair", LocalDate.class));
                order.setRepairStartDate(resultSet.getObject("repairStartDate", LocalDate.class));
                order.setEmployeeId(resultSet.getInt("employee_id"));
                order.setDescriptionOfTheProblem(resultSet.getString("descriptionOfTheProblem"));
                order.setRepairDescription(resultSet.getString("repairDescription"));
                order.setStatusId(resultSet.getInt("status_id"));
                order.setCarId(resultSet.getInt("car_id"));
                order.setRepairCost(resultSet.getBigDecimal("repairCost"));
                order.setCostOfParts(resultSet.getBigDecimal("costOfParts"));
                order.setEmployeeManHour(resultSet.getBigDecimal("employee_man_hour"));
                order.setNumberOfManHours(resultSet.getInt("numberOfManHours"));
                return order;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateStatus(int statusId, int orderId) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE orderData SET status_id = ? where id = ?");
            preparedStatement.setInt(1, statusId);
            preparedStatement.setInt(2, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
