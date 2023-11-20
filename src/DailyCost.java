import java.util.*;
public class DailyCost {
    private double totalCost;
    private String date;
    public void setDailyCosts(double costAmount,String date){
        totalCost += costAmount;
        this.date = date;
    }
    public double getDailyCost(){
       return totalCost;
    }
    public void display(){
        System.out.println("Amount: "+totalCost+"Date: "+date);
    }
}
