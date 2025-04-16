package app.models;

import java.io.Serializable;

public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
    private Double dailyIncome;
    private int daysWorked;

    public Payment() {
    }

    public Payment(String name, Double dailyIncome, int daysWorked) {
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.daysWorked = daysWorked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public int getDaysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    public Double getTotal() {
        return dailyIncome * daysWorked;
    }

}
