public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount firstBank = new BankAccount();
        BankAccount secondBank = new BankAccount();
        firstBank.depositChecking(55.5);
        firstBank.withdrawChecking(30.1);
        double balance = firstBank.getchecking();
        System.out.println("your balance checking is " + balance);
        firstBank.depositSavings(50.5);
        firstBank.withdrawSavings(30.1);
        System.out.println("your balance savings is " + firstBank.getsavings());
        System.out.println(BankAccount.gettotalbankacc());
    }
}
