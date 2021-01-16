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
                customer.setSecondName(resultSet.getString("secondName"));
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
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer(name, secondName, dateOfBirth) VALUES (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
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

    public void delete(int customerId) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE customer FROM customer WHERE id = ?");
            preparedStatement.setInt(1, customerId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Customer customer) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customer SET id = ?, name = ? , secondName = ?, dateOfBirth = ? WHERE id = ?");
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getSecondName());
            preparedStatement.setObject(4, customer.getDateOfBirth());
            preparedStatement.setInt(5, customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer findCustomerById(int id) {
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSecondName(resultSet.getString("secondName"));
                customer.setDateOfBirth(resultSet.getObject("dateOfBirth", LocalDate.class));

                return customer;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Customer findBySecondName(String secondName){
        try {
            Connection connection = DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer where secondName = ?");
            preparedStatement.setString(1, secondName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setId(resultSet.getInt( "id"));
                customer.setName(resultSet.getString("name"));
                customer.setSecondName(resultSet.getString("secondName"));
                customer.setDateOfBirth(resultSet.getObject("dateOfBirth", LocalDate.class));
                return customer;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
