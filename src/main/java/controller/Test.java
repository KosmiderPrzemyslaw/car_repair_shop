package controller;

import dao.CustomerDao;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/")
public class Test extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDao customerDao = new CustomerDao();

        Date date = new Date(2000-12-12);
        Customer customer = new Customer();
        customer.setName("Iza");
        customer.setSecondName("Zielona");
        customer.setDateOfBirth(LocalDate.of(1991, 2, 22));
        Customer customer1 = customerDao.create(customer);
        List<Customer> allCustomers = customerDao.findAllCustomers();
        for (Customer c: allCustomers
             ) {
            PrintWriter printWriter = response.getWriter();
            printWriter.println(c);
        }



    }
}
