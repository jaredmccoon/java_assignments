public class BankAccount {
    
    private double checking;
    private double savings;

    private static int totalbankacc = 0;
    private static int totalaccbalance = 0;


    
    public BankAccount() {
        this.checking = 0;
        this.savings = 0;
        totalbankacc++;
    }


    public boolean depositChecking(double deposit) {
        if (deposit < 0) {
            return false;
        } 
        this.checking += deposit;
        BankAccount.totalaccbalance += deposit;
        return true;
    }

    public boolean depositSavings(double deposit) {
        if (deposit < 0) {
            return false;
        } 
        this.savings += deposit;
        BankAccount.totalaccbalance += deposit;
        return true;
    }


    public boolean withdrawChecking(double withdrawal) {
        if (withdrawal < 0) {
            return false;
        } else if (withdrawal > this.checking) {
            return false;
        }
        this.checking -= withdrawal;
        BankAccount.totalaccbalance -= withdrawal;
        return true;
    }
    
    public boolean withdrawSavings(double withdrawal) {
        if (withdrawal < 0) {
            return false;
        } else if (withdrawal > this.savings) {
            return false;
        }
        this.savings -= withdrawal;
        BankAccount.totalaccbalance -= withdrawal;
        return true;
    }


    public double getchecking() {
        return this.checking;
    }
    public double getsavings() {
        return this.savings;
    }
    public double getTotalBalance() {
        return BankAccount.totalaccbalance;
    }
    public static int gettotalbankacc() {
        return totalbankacc;
    }
}