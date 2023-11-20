import java.util.ArrayList;
public class Cost {
    double totalCost;
    ArrayList<DailyCost> dailyCosts = new ArrayList<>();
    public void entryDailyCost(double cost,String date){
        DailyCost dailyCost = new DailyCost();
        dailyCost.setDailyCosts(cost,date);
        this.totalCost += dailyCost.getDailyCost();
        dailyCosts.add(dailyCost);
    }
    public void getDailyCost(){
        for(DailyCost dailyCost:dailyCosts){
            dailyCost.display();
        }
    }
//    public ArrayList<DailyCost> getTotalCost(){
//        return dailyCosts;
//    }
    public double getTotalCost(){
        return totalCost;
    }
    public void display(){
        System.out.println("Total: "+this.totalCost);
   }
}
