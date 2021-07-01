package atmPackage;

import bankPackage.AccountData;
import bankPackage.Bank;

import java.util.function.Consumer;
import java.util.function.Supplier;


public class CashMachine {

    private final Bank bank;
    private AccountData accountData = null;

    public CashMachine(Bank bank) {
        this.bank = bank;
    }

    private Consumer<AccountData> update = data -> {
        accountData = data;
    };

    public boolean login(int pin) {
        tryCall(
                () -> bank.getAccountById(pin),
                update
                
        );
        if(accountData != null) {
            return true;
        } else {
            return false;
        }
        
    }
    
    

    public void deposit(int amount) {
        if (accountData != null) {
            tryCall(
                    () -> bank.deposit(accountData, amount),
                    update
            );
        }
    }

    public void withdraw(int amount) {
        if (accountData != null) {
            tryCall(
                    () -> bank.withdraw(accountData, amount),
                    update
            );
        }
    }

    public void exit() {
        if (accountData != null) { 
            accountData = null;
        }
    }

    // Get Constructors
    public String getPinString() {
        return accountData != null ? accountData.pinString() : "Account Does Not Exist";
    }
    
    public String getIDString() {
        return accountData != null ? accountData.idString() : "Account Does Not Exist";
    }
    
     public String getNameString() {
        return accountData != null ? accountData.nameString() : "Account Does Not Exist";
    }

      public String getEmailString() {
        return accountData != null ? accountData.emailString() : "Account Does Not Exist";
    }

       public String getBalanceString() {
        return accountData != null ? accountData.balanceString() : "Account Does Not Exist";
    }


    
    
    
    private <T> void tryCall(Supplier<ActionResult<T> > action, Consumer<T> postAction) {
        try {
            ActionResult<T> result = action.get();
            if (result.isSuccess()) {
                T data = result.getData();
                postAction.accept(data);
            } else {
                String errorMessage = result.getErrorMessage();
                throw new RuntimeException(errorMessage);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
