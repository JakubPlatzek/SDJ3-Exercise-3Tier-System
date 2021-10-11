package model;

public class Request {
    private String requestType;
    private double amount;

    public Request(String requestType, double amount) {
        this.requestType = requestType;
        this.amount = amount;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
