package com.models;

public class PaymentDto {
    public String name;
    public Double dailyIncome;
    public int daysWorked;
    public Double total;

    public PaymentDto() {
    }

    public PaymentDto(String name, Double dailyIncome, int daysWorked, Double total) {
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.daysWorked = daysWorked;
        this.total = total;
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
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    

}
