public class Members {
    String name;
    int id;
    String phone;
    double due;
    double totalCost;
    double deposited;
    int totalMeal;
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
