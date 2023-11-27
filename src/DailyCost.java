import java.util.*;
public class DailyCost {
    private double totalCost;
    private double todayCost = 0;
    private String date;
    public void setDailyCosts(double costAmount,String date){
       this.todayCost = costAmount;
        this.date = date;
    }
    public double getDailyCost(){
       return todayCost;
    }
    public void display(){
        System.out.println(" DailyCost data ");
        System.out.println("Amount: "+this.totalCost+"Date: "+this.date);
    }
}
