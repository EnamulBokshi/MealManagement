import java.util.ArrayList;
import java.util.Scanner;
public class Cost {
//    double totalCost = 0;
    private double totalCost;
    double cost;
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> costList = new ArrayList<>();
    ArrayList<Double> costs = new ArrayList<>();
    ArrayList<DailyCost> dailyCosts = new ArrayList<>();
//    public void entryDailyCost(double cost,String date){
//        DailyCost dailyCost = new DailyCost();
//        dailyCost.setDailyCosts(cost,date);
//        this.totalCost += dailyCost.getDailyCost();
//        dailyCosts.add(dailyCost);
//    }
    private void calculateTotalCost(){
//        for (DailyCost cost: dailyCosts){
//            totalCost += cost.getDailyCost();
//        }

        for (Double cost: costs){
            this.totalCost += cost;
        }
        System.out.println("Total cost in Cost Calculation: "+totalCost);
    }
    public double getTotalCost(){
        calculateTotalCost();
        //display();
        return totalCost;
    }
    public void entryCost(){
        System.out.println("Enter today cost: ");
//        double todayCost  = sc.nextDouble();
//        costs.add(todayCost);
        int todayCost = sc.nextInt();
        costList.add(todayCost);
    }
    public void displayCosts(){
       int costCount = 0;
       for (Integer cost: costList){
           costCount += cost;
       }


//        for (Double costss: costs){
//            allCost+=costss;
//            System.out.println("Cots: "+costss);
//        }

        System.out.println("Cost List: "+costList);
    }
}
