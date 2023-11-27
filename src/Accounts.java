import java.util.ArrayList;

public class Accounts {
    ArrayList<Members> members ;
    Cost cost = new Cost();
    double totalBalance;
    double balance;
    double remBalance;
    double totalCost;
//    public void calculator(){
//        for (Members member:members
//             ) {
//            totalBalance += member.deposited;
//            System.out.println("Now total Balance is (accounts.java) : "+totalBalance);
//        }
//        totalBalance = totalBalance/2;
//        totalCost = cost.getTotalCost();
//        remBalance = totalBalance-totalCost;
//    }
    public void setMembers(ArrayList<Members> members){
        this.members = members;

    }
    public void setAccounts(int totalCost){
        balance = 0;
        for(Members member : members){
            balance+=member.deposited;
        }

        this.totalCost = totalCost;
        System.out.println("Total cost: "+totalCost);
        remBalance = totalBalance-totalCost;
        System.out.println("Remaining balance: "+remBalance);
        totalBalance = balance;
    }
    public double getTotalBalance() {
        return totalBalance;
    }

    public void displayAccounts(){
        System.out.println("Total Collected Amount: "+this.totalBalance);
        System.out.println("Total Cost: "+this.totalCost);
        System.out.println("Remaining Balance: "+this.remBalance);
    }
    public void calculations(int totalCost){

    }
}
