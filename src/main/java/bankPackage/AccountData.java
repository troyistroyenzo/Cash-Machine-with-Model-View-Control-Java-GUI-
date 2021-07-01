package bankPackage;


public final class AccountData {

    private final int pin;
    private final String name;
    private final String email;
    private final String id;

    private final int balance;
   // public String idString;

    AccountData(int pin, String id, String name, String email, int balance) {
        this.pin = pin;
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
        
    }

    public int getPin() {
        return pin;
    }
    
    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getBalance() {
        return balance;
    }

    // RETURN 
    public String pinString() {
        return "PIN: " + pin;
    }
    
     public String idString() {
        return "Account id: " + id;
    }
    
    public String nameString() {
        return "Name: " + name;     
    }
    
    public String emailString() {
        return "Email: " + email;
    }
    public String balanceString() {
        return "Balance: " + balance;
    }
    
    
   
    
    
    
    
}
