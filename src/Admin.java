import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
 public class Admin{
    ArrayList<Members> members = new ArrayList<>();
    ArrayList<Integer>CostList = new ArrayList<>();
    Accounts accounts = new Accounts();
   //StackOverflow with accounts.java: 14
    Cost cost = new Cost();
    int mealCount = 0;
    double mealRate = 0;
    int id = 10000;
    int totalMeal = 0;
    int totalCost = 0;
    double remBalance = 0;
    double totalBalance = 0;
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    public void menu(){
        System.out.println("Welcome to Mess Control Panel");
        int inp;
        do{
            System.out.println("Please select your operation (0 for exit): ");
            System.out.println("1.Add member\n2.Remove member\n3.Display members\n4.Find a Member\n5.Deposit\n6.Accounts Operations\n7.Meal Operations");
            inp = sc.nextInt();
            if(inp == 1) {
                try{
                    int n;
                    System.out.print("How many members wants to add? ");
                    n = sc.nextInt();
                    addMember(n);
                }catch (Exception e){
                    System.out.println("Error: member add failed! "+ e);
                }
            }
            else if(inp == 2) removeMember();
            else if(inp == 3) displayMembers();
            else if (inp == 4){
                System.out.println("Enter id: ");
                int id = sc.nextInt();
                profilePrint(id);
            }
            else if(inp == 5){
                try {
                    System.out.println("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.println("Enter amount: ");
                    double amount = sc.nextDouble();
                    deposite(id,amount);
                }catch (Exception e){
                    System.out.println("Member not found! please try again!");
                }
            } else if (inp==6) {
                System.out.println("**         Select Operation:              **");
                System.out.println("           -----------------                ");
                System.out.println("1. Entry Daily Cost.\n2.See Accounts Status");
                inp = sc.nextInt();
                if (inp == 1) {
//                    System.out.println("Enter Daily Cost: ");
//                    double amount = sc.nextDouble();
//                    String currentDate = formatter.format(date);
//                    cost.entryDailyCost(amount, currentDate);
                    int cost = sc.nextInt();
                    costEntry(cost);
                } else if (inp == 2) {
                    displayAccounts();
                }
            }
            else if (inp == 7) {
                System.out.println("**         Select Operation:              **");
                System.out.println("           -----------------                ");

                System.out.println("1.Entry Daily Meal.\n2.See Meal Status\n0 for quit");
                int userChoice;
                userChoice = sc.nextInt();
                do {
                    if (userChoice == 1){
                        System.out.println("Enter id: ");
                        int id;
                        id = sc.nextInt();
                        System.out.println("Enter Today Meal (including guest meal): ");
                        int meal;
                        meal = sc.nextInt();
                        mealEntry(id, meal);
                    }
                    else if (userChoice == 2){
                        displayMeal();
                    }
                    else if (userChoice == 0){
                        System.out.println("Exited Successfully! ");
                    }else {
                        System.out.println("Invalid choice! please choice from options");
                        break;
                    }
//                    System.out.print("Wanna continue?y/n");
//                    String  choice;
//                    choice = sc.nextLine();
//                    choice = sc.nextLine();
//                   if (!Objects.equals(choice, "y")) userChoice = 0;
                    System.out.println("1.Entry Daily Meal.\n2.See Meal Status\n00 for quit");
                    userChoice = sc.nextInt();
                } while (userChoice != 0);
//                inp = sc.nextInt();
//                if (inp == 1) {
//                    do {
//                        System.out.println("Enter id: ");
//                        int id;
//                        id = sc.nextInt();
//                        System.out.println("Enter Today Meal (including guest meal: ");
//                        int meal;
//                        meal = sc.nextInt();
//                        mealEntry(id, meal);
//                        System.out.println("Enter 1 for another entry 00 for quit");
//                        inp = sc.nextInt();
//                    } while (inp != 00);
//                } else if (inp == 2) {
//                    displayMeal();
//                }
            }
            else System.out.println("Invalid Choice!. ");

        }while (inp != 0);
    }
    private void addMember(int n) {
//        try {
            sc.nextLine();
            while(n>0){
                String name;
                String phone;
                System.out.println("Please Provide All the below information");
                System.out.println("-------------------------");
                System.out.println("Name: ");
                name =sc.nextLine();
                System.out.println("Phone: ");
                phone = sc.nextLine();
                members.add(new Members(name,phone,id,formatter.format(date)));
                id++;
                n--;
            }
//        }catch (Exception e){
//            System.out.println("You have entered invalid data!!");
//        }

    }
    private void removeMember() {
        System.out.println("Enter id of the member:  ");
        int id = sc.nextInt();
        if(findMember(id) != null){
            members.remove(findMember(id));
        }
       else{
            System.out.println("No member exits!! ");
        }
    }
    public Members findMember(int id){
        for (Members member: members
        ) {
            if(member.id == id){
               return member;
            }
        }
       return null;
    }
    public void displayMembers() {
        for(Members member: members){
            System.out.println("Name: "+member.name);
            System.out.println("Id: "+member.id);
            System.out.println("Phone: "+member.phone);
            System.out.println("Deposited Amount: "+member.deposited);
            System.out.println("Entry Date: "+member.date);
            //Total meal counting
            int totalMeal = 0;
            for (Integer meal: member.meal){
                totalMeal+=meal;
            }
            System.out.println("Total meal: "+totalMeal);

            System.out.println("Total Cost: "+member.totalCost);
            System.out.println("Total due (- means remaining): "+member.due);
        }
    }
    public void deposite(int id,double amount){
        final Members member = findMember(id);
        assert member != null;
        member.deposite(amount);
    }
    public void profilePrint(int id){
        final Members member = findMember(id);
        assert member != null;
        System.out.println("Name: "+member.name+"\nId: "+member.id+"\nphone: "+member.phone+"\nDeposited: "+member.deposited+" tk.\n");
    }
    public void passMember(){
        accounts.setMembers(members);
    }
    public void displayAccounts(){
        passMember();
        costCalculation();
        accounts.setAccounts(totalCost);
        System.out.println("                     ** Current Account Status **                    ");
        System.out.println("----------------------------------------------------------------------");
        double balance = accounts.getTotalBalance();
        System.out.println("Total Collected Amount: "+balance);
        System.out.println("Total Cost till today: "+accounts.totalCost);
        System.out.println("Remaining Balance: "+accounts.remBalance);

        //From account class
//        accounts.displayAccounts();
//        System.out.println("Total cost in Cost: ");
//        cost.displayCosts();
        System.out.println("                                   ^-^               ");
        System.out.println("=======================================================================");
        System.out.println("                     ** Current Meal Status **                    ");
        System.out.println();
    }
//    public void mealRateCalculation(){
//        mealRate = totalMeal/totalCost;
//    }
     public void mealEntry(int id,int todayMeal){
         try {
             Members member = this.findMember(id);
             member.meal.add(todayMeal);
             member.totalMeal += todayMeal;
             //mealRateCalculation();
         }catch (Exception e){
             System.out.println("no member found");
         }

     }
    public void totalMealCounter(){
        for (Members member: members
             ) {
            for (Integer perMeal:member.meal
                 ) {
                totalMeal += perMeal;
            }
        }
    }
     public void displayMeal(){
         totalMealCounter();
         System.out.println("Total Meal: "+this.totalMeal);
         System.out.println("Current Meal rate: ");
     }
     public void costEntry(int cost){
         CostList.add(cost);

     }
     public void costCalculation(){
         for (Integer cost:CostList
              ) {
             totalCost += cost;
         }
     }

     public void getAccountsCalculation(){
         accounts.calculations(totalCost);
         this.remBalance = accounts.remBalance;
     }
}
