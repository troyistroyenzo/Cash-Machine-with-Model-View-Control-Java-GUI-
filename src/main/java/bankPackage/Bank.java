package bankPackage;

import atmPackage.ActionResult;

import java.util.HashMap;
import java.util.Map;


public class Bank {

    private Map<Integer, Account> accounts = new HashMap<>();
   

    public Bank() {
        
        accounts.put(1234, new PremiumAccount(new AccountData(
                1234, "#UAGSDUYASD", "Sal John", "saljohn@gmail.com", 1200
        )));
        
        
        accounts.put(4567, new PremiumAccount(new AccountData(
                4567, "#45KV98JNS", "Henry K.", "sullyherny2@gmail.com", 2000
        )));
        
        accounts.put(20200, new PremiumAccount(new AccountData(
                20200, "#323FYSD4", "Maverick J.", "mjv@gmail.com", 600
        )));
        
        
    }
    
    
    

    public ActionResult<AccountData> getAccountById(int pin) {
        Account account = accounts.get(pin);

        if (account != null) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("No account with id: " + pin);
        }
    }

    public ActionResult<AccountData> deposit(AccountData accountData, int amount) {
        Account account = accounts.get(accountData.getPin());
        account.deposit(amount);

        return ActionResult.success(account.getAccountData());
    }

    public ActionResult<AccountData> withdraw(AccountData accountData, int amount) {
        Account account = accounts.get(accountData.getPin());
        boolean ok = account.withdraw(amount);

        if (ok) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail("Withdraw failed: " + amount + ". Account has: " + account.getBalance());
        }
    }
}
