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
import java.time.LocalDate;
import java.util.List;

@WebServlet("/customer")
public class CustomerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter printWriter = response.getWriter();
//
//        Customer customer = new Customer();
//        customer.setDateOfBirth(LocalDate.of(1523, 12, 2));
//        customer.setName("Kamil");
//        customer.setSecondName("Nowak");
//        CustomerDao customerDao = new CustomerDao();
//        customerDao.create(customer);
//
//        customerDao.delete(44);
//        List<Customer> allCustomers = customerDao.findAllCustomers();
//        Customer customerById = customerDao.findCustomerById(1);
//        printWriter.println(customerById);
//        System.out.println(customerById.toString());
//        System.out.println(customerById);
//
//        for (Customer c:allCustomers
//              ) {
//            printWriter.println(c.toString());
//
//        }
//
//        customer.setName("Maciej");
//        customer.setSecondName("Kownacki");
//        customer.setDateOfBirth(LocalDate.now());
//
//        customerDao.update(customer);
//
//        for (Customer c:allCustomers
//        ) {
//            printWriter.println();
//            printWriter.println();
//            printWriter.println(c.toString());
//
//        }

        CustomerDao customerDao = new CustomerDao();
        Customer nowak = customerDao.findBySecondName("Nowak");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(nowak);
    }
}
