package controller;

import dao.OrderDao;
import model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;

@WebServlet("/orderController")
public class OrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = new Order(LocalDate.now(), LocalDate.now(), LocalDate.now(),
                2, "problrm desc", "repair desc",
                1, 2,
                BigDecimal.valueOf(44.44),
                BigDecimal.valueOf(12.12), BigDecimal.valueOf(11.11), 10);
        Order order2 = new Order(LocalDate.now(), LocalDate.now(), LocalDate.now(),
                2, "problrm desc", "repair desc",
                1, 3,
                BigDecimal.valueOf(44.44),
                BigDecimal.valueOf(12.12), BigDecimal.valueOf(11.11), 10);

        OrderDao orderDao = new OrderDao();
        Order order1 = orderDao.create(order);
        orderDao.create(order2);
        PrintWriter printWriter = response.getWriter();
        printWriter.println(order);
        printWriter.println(order1);

        orderDao.delete(2);

        order2.setDescriptionOfTheProblem("changed using update");
        order2.setRepairDescription("changed using update");
        orderDao.update(order2);

        Order orderById = orderDao.findById(32);
        printWriter.println("FIND ORDER BY ID: \n" + orderById);

        orderDao.updateStatus(4, 32);
    }
}
