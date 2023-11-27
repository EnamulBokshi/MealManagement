import java.util.ArrayList;

public class Members {
    String name;
    int id;
    String phone;
    double due = 0;
    double totalCost = 0;
    double deposited = 0;
    ArrayList<Integer> meal = new ArrayList<Integer>();
    int totalMeal = 0;
    String date;
    Members(String name,String phone,int id,String date){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.date = date;
    }
    public void deposite(double amount){
        deposited += amount;
    }

}
