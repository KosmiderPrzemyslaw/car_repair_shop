package dao;

import model.Employee;
import model.Order;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public Employee create(Employee employee) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee(name, secondName, phone, note, man_hour) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSecondName());
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getNote());
            preparedStatement.setBigDecimal(5, employee.getManHour());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                employee.setId(resultSet.getInt(1));
                return employee;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> findAllEmployee() {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Employee> employeeList = new ArrayList<>();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSecondName(resultSet.getString("secondName"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setNote(resultSet.getString("note"));
                employee.setManHour(resultSet.getBigDecimal("man_hour"));
                employeeList.add(employee);
            }
            return employeeList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Employee findById(int employeeId) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id = ?");
            preparedStatement.setInt(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSecondName(resultSet.getString("secondName"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setNote(resultSet.getString("note"));
                employee.setManHour(resultSet.getBigDecimal("man_hour"));
                return employee;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int employeeId) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE employee FROM employee WHERE id = ?");
            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Employee employee) {

        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee SET name = ?, secondName = ?, phone = ?, note = ?, man_hour = ? where id = ?");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSecondName());
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getNote());
            preparedStatement.setBigDecimal(5, employee.getManHour());
            preparedStatement.setInt(6, employee.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> findAllOrdersByEmployeeId(int employeeId) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM orderData where orderData.employee_id = ?");
            preparedStatement.setInt(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setDateOfAcceptanceForRepair(resultSet.getObject("dateOfAcceptanceForRepair", LocalDate.class));
                order.setScheduledDateForTheStartOfRepair(resultSet.getObject("scheduledDateForTheStartOfRepair", LocalDate.class));
                order.setRepairStartDate(resultSet.getObject("repairStartDate", LocalDate.class));
                order.setDescriptionOfTheProblem(resultSet.getString("descriptionOfTheProblem"));
                order.setRepairDescription(resultSet.getString("repairDescription"));
                order.setStatusId(resultSet.getInt("status_id"));
                order.setCarId(resultSet.getInt("car_id"));
                order.setRepairCost(resultSet.getBigDecimal("repairCost"));
                order.setCostOfParts(resultSet.getBigDecimal("costOfParts"));
                order.setEmployeeManHour(resultSet.getBigDecimal("employee_man_hour"));
                order.setNumberOfManHours(resultSet.getInt("numberOfManHours"));
                orders.add(order);
            }
            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


//            while (resultSet.next()) {
//                Order order = new Order();
//                order.setId(resultSet.getInt("id"));
//                order.setDateOfAcceptanceForRepair(resultSet.getObject("dateOfAcceptanceForRepair", LocalDate.class));
//                order.setScheduledDateForTheStartOfRepair(resultSet.getObject("scheduledDataForTheStartOfRepair", LocalDate.class));
//                order.setRepairStartDate(resultSet.getObject("repairStartDate", LocalDate.class));
//                order.setDescriptionOfTheProblem(resultSet.getString("descriptionOfTheProblem"));
//                order.setRepairDescription(resultSet.getString("repairDescription"));
//                order.setRepairCost(resultSet.getBigDecimal("repairCost"));
//                order.setCostOfParts(resultSet.getBigDecimal("costOfParts"));
//                order.setEmployeeManHour(resultSet.getBigDecimal("employee_man_hour"));
//                order.setNumberOfManHours(resultSet.getInt("numberOfManHours"));
//                orders.add(order);
//            }