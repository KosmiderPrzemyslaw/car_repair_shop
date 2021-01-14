package model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class Order {
    private int id;
    private LocalDate dateOfAcceptanceForRepair;
    private LocalDate scheduledDateForTheStartOfRepair;
    private LocalDate repairStartDate;
    private String descriptionOfTheProblem;
    private String repairDescription;
    private BigDecimal repairCost;
    private BigDecimal costOfParts;
    private BigDecimal employeeManHour;
    private int numberOfManHours;


    public Order() {
    }

    public Order(LocalDate dateOfAcceptanceForRepair, LocalDate scheduledDateForTheStartOfRepair, LocalDate repairStartDate, String descriptionOfTheProblem, String repairDescription, BigDecimal repairCost, BigDecimal costOfParts, BigDecimal employeeManHour, int numberOfManHours) {
        this.dateOfAcceptanceForRepair = dateOfAcceptanceForRepair;
        this.scheduledDateForTheStartOfRepair = scheduledDateForTheStartOfRepair;
        this.repairStartDate = repairStartDate;
        this.descriptionOfTheProblem = descriptionOfTheProblem;
        this.repairDescription = repairDescription;
        this.repairCost = repairCost;
        this.costOfParts = costOfParts;
        this.employeeManHour = employeeManHour;
        this.numberOfManHours = numberOfManHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateOfAcceptanceForRepair() {
        return dateOfAcceptanceForRepair;
    }

    public void setDateOfAcceptanceForRepair(LocalDate dateOfAcceptanceForRepair) {
        this.dateOfAcceptanceForRepair = dateOfAcceptanceForRepair;
    }

    public LocalDate getScheduledDateForTheStartOfRepair() {
        return scheduledDateForTheStartOfRepair;
    }

    public void setScheduledDateForTheStartOfRepair(LocalDate scheduledDateForTheStartOfRepair) {
        this.scheduledDateForTheStartOfRepair = scheduledDateForTheStartOfRepair;
    }

    public LocalDate getRepairStartDate() {
        return repairStartDate;
    }

    public void setRepairStartDate(LocalDate repairStartDate) {
        this.repairStartDate = repairStartDate;
    }

    public String getDescriptionOfTheProblem() {
        return descriptionOfTheProblem;
    }

    public void setDescriptionOfTheProblem(String descriptionOfTheProblem) {
        this.descriptionOfTheProblem = descriptionOfTheProblem;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public BigDecimal getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(BigDecimal repairCost) {
        this.repairCost = repairCost;
    }

    public BigDecimal getCostOfParts() {
        return costOfParts;
    }

    public void setCostOfParts(BigDecimal costOfParts) {
        this.costOfParts = costOfParts;
    }

    public BigDecimal getEmployeeManHour() {
        return employeeManHour;
    }

    public void setEmployeeManHour(BigDecimal employeeManHour) {
        this.employeeManHour = employeeManHour;
    }

    public int getNumberOfManHours() {
        return numberOfManHours;
    }

    public void setNumberOfManHours(int numberOfManHours) {
        this.numberOfManHours = numberOfManHours;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateOfAcceptanceForRepair=" + dateOfAcceptanceForRepair +
                ", scheduledDateForTheStartOfRepair=" + scheduledDateForTheStartOfRepair +
                ", repairStartDate=" + repairStartDate +
                ", descriptionOfTheProblem='" + descriptionOfTheProblem + '\'' +
                ", repairDescription='" + repairDescription + '\'' +
                ", repairCost=" + repairCost +
                ", costOfParts=" + costOfParts +
                ", employeeManHour=" + employeeManHour +
                ", numberOfManHours=" + numberOfManHours +
                '}';
    }

    public void setStatusId(int statusId) {
    }

    public void setCarId(int car_id) {
    }
}
