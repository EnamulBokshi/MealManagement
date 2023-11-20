import java.time.chrono.MinguoEra;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Admin{
    ArrayList<Members> members = new ArrayList<>();
    Accounts accounts = new Accounts();
   //StackOverflow with accounts.java: 14
    Cost cost;
    int id = 10000;
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    public void menu(){
        System.out.println("Welcome to Mess Control Panel");
        int inp;
        do{
            System.out.println("Please select your operation (0 for exit): ");
            System.out.println("1.Add member\n2.Remove member\n3.Display members\n4.Find a Member\n5.Deposit");
            inp = sc.nextInt();
            if(inp == 1) addMember();
            else if(inp == 2) removeMember();
            else if(inp == 3) displayMembers();
            else if (inp == 4){
                System.out.println("Enter id: ");
                int id = sc.nextInt();
                profilePrint(id);
            }
            else if(inp == 5){
                System.out.println("Enter ID: ");
                int id = sc.nextInt();
                System.out.println("Enter amount: ");
                double amount = sc.nextDouble();
                deposite(id,amount);
            } else if (inp==6) {
                System.out.println("Enter Daily Cost: ");
                double amount = sc.nextDouble();
                String currentDate = formatter.format(date);
                cost.entryDailyCost(amount,currentDate);

            } else System.out.println("Invalid Choice!. ");

        }while (inp != 0);
    }
    private void addMember() {
        int n;
        System.out.println("How many Member? ");
        n = sc.nextInt();
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
    private Members findMember(int id){
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
}
