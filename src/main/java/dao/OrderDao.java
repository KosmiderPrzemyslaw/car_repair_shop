package dao;

import model.Order;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
