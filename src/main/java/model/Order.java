package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Order {
    private int id;
    private Date dateOfAcceptanceForRepair;
    private Date scheduledDateForTheStartOfRepair;
    private Date repairStartDate;
    private String descriptionOfTheProblem;
    private String repairDescription;
    private BigDecimal repairCost;
    private BigDecimal costOfParts;
    private BigDecimal employeeManHour;
    private int numberOfManHours;

    public Order(Date scheduledDateForTheStartOfRepair, Date repairStartDate, String descriptionOfTheProblem, String repairDescription, BigDecimal repairCost, BigDecimal costOfparts, BigDecimal employeeManHour, int numberOfManHours) {
        this.scheduledDateForTheStartOfRepair = scheduledDateForTheStartOfRepair;
        this.repairStartDate = repairStartDate;
        this.descriptionOfTheProblem = descriptionOfTheProblem;
        this.repairDescription = repairDescription;
        this.repairCost = repairCost;
        this.costOfParts = costOfparts;
        this.employeeManHour = employeeManHour;
        this.numberOfManHours = numberOfManHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfAcceptanceForRepair() {
        return dateOfAcceptanceForRepair;
    }

    public void setDateOfAcceptanceForRepair(Date dateOfAcceptanceForRepair) {
        this.dateOfAcceptanceForRepair = dateOfAcceptanceForRepair;
    }

    public Date getScheduledDateForTheStartOfRepair() {
        return scheduledDateForTheStartOfRepair;
    }

    public void setScheduledDateForTheStartOfRepair(Date scheduledDateForTheStartOfRepair) {
        this.scheduledDateForTheStartOfRepair = scheduledDateForTheStartOfRepair;
    }

    public Date getRepairStartDate() {
        return repairStartDate;
    }

    public void setRepairStartDate(Date repairStartDate) {
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
}
