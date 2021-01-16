package controller;

import dao.EmployeeDao;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employeeController")
public class EmployeeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employeeList = employeeDao.findAllEmployee();

        request.setAttribute("employee", employeeList);

        getServletContext().getRequestDispatcher("/pages/employee.jsp").forward(request, response);

    }
}
