import java.util.ArrayList;

public class Accounts {
    Admin admin = new Admin();
    ArrayList<Members> members = admin.members;
    Cost cost;
    double totalBalance;
    double remBalance;
    double totalCost;
    Accounts(){
        cost = new Cost();
        this.totalCost = cost.getTotalCost();
        remBalance = totalBalance-totalCost;
    }
    public void calculateTotalBalance(){
        for (Members member:members
             ) {
            totalBalance += member.deposited;
        }
    }
    public void setMembers(ArrayList<Members> members){
        this.members = members;
    }
    public double getTotalBalance() {
        calculateTotalBalance();
        return totalBalance;
    }
}
