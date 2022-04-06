public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double lattePrice = 4.0;
        double cappuccinoPrice = 4.5;
        double americanoPrice = 3.7;
    
        // Customer name variables (add yours below)
        String customer0 = "Cindhuri";
        String customer1 = "Noah";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
    
        // Order completions (add yours below)
        boolean isReadyOrder0 = false;
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        System.out.println(customer0 + pendingMessage); // Displays "Welcome to Cafe Java, Cindhuri"
        System.out.println(customer0 + readyMessage); // Displays "Welcome to Cafe Java, Cindhuri"
        System.out.println(displayTotalMessage + mochaPrice); 

        if (isReadyOrder1) {
            System.out.println(customer1 + readyMessage);
        } else {
            System.out.println(customer1 + pendingMessage);
        }
    }
}
