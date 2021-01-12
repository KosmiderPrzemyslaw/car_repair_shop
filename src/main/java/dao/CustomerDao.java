package dao;

import model.Customer;
import util.DbUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    public List<Customer> findAllCustomers() {
        try {
            List<Customer> customerList = new ArrayList<>();
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM customer");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setName(resultSet.getString("secondName"));
                customer.setDateOfBirth(resultSet.getObject("dateOfBirth", LocalDate.class));
                customerList.add(customer);
            }
            return customerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Customer create(Customer customer) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer(name, secondName, dateOfBirth) VALUES (?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getSecondName());
            preparedStatement.setObject(3, customer.getDateOfBirth());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                customer.setId(resultSet.getInt(1));
            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
