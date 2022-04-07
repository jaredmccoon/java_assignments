import java.util.ArrayList;

public class CafeUtil {
    // sums together every consecutive integer from 1 to 10 and returns the sum.
    public int getStreakGoal() {
        int sum = 0;
        for (int i = 0; i<10; i++){
            sum+=i;
        }
        System.out.println(sum);
        return sum;
    }
    public double getOrderTotal(double[] prices) {
        int sum = 0;
        for (int i=0; i< prices.length;i++){
            sum+=prices[i];
        }
        return sum;
    }
    public void displayMenu(ArrayList<String> menuItems) {
        for(int i=0; i<menuItems.size(); i++){
            System.out.println(i + " " + menuItems.get(i));
    }}
        public void addCustomer(ArrayList<String> customers){
            System.out.println("Please Enter your name:");
            String userName = System.console().readLine();
            System.out.println("Hello " + userName);
            System.out.println("There are " + customers.size() + " people in front of you.");
            customers.add(userName);
    }
}