package dao;

import model.Employee;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                Employee employee = getEmployeeFromDb(resultSet);
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
            ResultSet resultSet = preparedStatement.executeQuery();

            getEmployeeFromDb(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Employee getEmployeeFromDb(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        while (resultSet.next()) {
            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getNString("name"));
            employee.setSecondName(resultSet.getString("secondName"));
            employee.setPhone(resultSet.getString("phone"));
            employee.setNote(resultSet.getString("note"));
            employee.setManHour(resultSet.getBigDecimal("man_hour"));
        }
        return employee;
    }
}
