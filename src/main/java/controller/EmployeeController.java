package controller;

import dao.EmployeeDao;
import model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/employeeController")
public class EmployeeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Employee employee = new Employee("Marcin", "Kowalski", "213212", "some note", new BigDecimal(22.44));
        EmployeeDao employeeDao = new EmployeeDao();
//        employeeDao.create(employee);
        PrintWriter printWriter = response.getWriter();
//
//
//        List<Employee> allEmployee = employeeDao.findAllEmployee();
//
//        for (Employee e:allEmployee
//             ) {
//            printWriter.println(e);
//        }
//
//        Employee employeeDaoById = employeeDao.findById(2);
//
//        printWriter.println(employeeDaoById);
//        printWriter.println();
//        employeeDao.delete(4);
//        employeeDaoById.setName("Indonezja");
//        employeeDao.update(employeeDaoById);

        List<Order> allOrdersByEmployeeId = employeeDao.findAllOrdersByEmployeeId(2);

        for (Order o: allOrdersByEmployeeId
             ) {
            printWriter.println(o);
        }

    }
}
