package controller;

import dao.CarDao;
import model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;

@WebServlet("/carController")
public class CarController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarDao carDao = new CarDao();
        Car car = new Car();
        car.setId(22);
        car.setCustomerId(1);
        car.setModel("Escort");
        car.setMark("Ford");
        car.setRegistrationNumber("KBC1246");
        car.setYearOfProduction(Year.of(2000));
        car.setNextInspection(LocalDate.of(2021,12,11));

        Car car1 = carDao.create(car);
        List<Car> all = carDao.findAll();

        PrintWriter printWriter = response.getWriter();
        printWriter.println(car1);
        for (Car c:all
             ) {
            printWriter.println(c);
        }
    }
}
