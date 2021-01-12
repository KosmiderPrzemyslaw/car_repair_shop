package model;

public class Status {
    private int id;
    private String adopted;
    private String approvedRepairCost;
    private String inRepair;
    private String readyForPickUp;
    private String resignation;


    public Status() {
    }

    public Status(String adopted, String approvedRepairCost, String inRepair, String readyForPickUp, String resignation) {
        this.adopted = adopted;
        this.approvedRepairCost = approvedRepairCost;
        this.inRepair = inRepair;
        this.readyForPickUp = readyForPickUp;
        this.resignation = resignation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdopted() {
        return adopted;
    }

    public void setAdopted(String adopted) {
        this.adopted = adopted;
    }

    public String getApprovedRepairCost() {
        return approvedRepairCost;
    }

    public void setApprovedRepairCost(String approvedRepairCost) {
        this.approvedRepairCost = approvedRepairCost;
    }

    public String getInRepair() {
        return inRepair;
    }

    public void setInRepair(String inRepair) {
        this.inRepair = inRepair;
    }

    public String getReadyForPickUp() {
        return readyForPickUp;
    }

    public void setReadyForPickUp(String readyForPickUp) {
        this.readyForPickUp = readyForPickUp;
    }

    public String getResignation() {
        return resignation;
    }

    public void setResignation(String resignation) {
        this.resignation = resignation;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", adopted='" + adopted + '\'' +
                ", approvedRepairCost='" + approvedRepairCost + '\'' +
                ", inRepair='" + inRepair + '\'' +
                ", readyForPickUp='" + readyForPickUp + '\'' +
                ", resignation='" + resignation + '\'' +
                '}';
    }
}
