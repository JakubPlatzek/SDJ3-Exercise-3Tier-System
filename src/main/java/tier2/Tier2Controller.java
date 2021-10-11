package tier2;

import com.google.gson.Gson;
import common.ITier3;
import model.Account;
import model.Request;
import org.springframework.web.bind.annotation.*;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

import static common.ITier3.T3_SERVICE_NAME;

@RestController
public class Tier2Controller
{
  private ITier3 tier3;

  public Tier2Controller()
  {
    try {
      tier3 = (ITier3) Naming.lookup(T3_SERVICE_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      System.exit(1);
    }
  }

  @PutMapping("/account/{accountNumber}")
  public synchronized boolean createAccount(@PathVariable int accountNumber) throws RemoteException {
    if (tier3.getAccount(accountNumber) == null) {
      Account account = new Account(accountNumber, 0.0);
      return tier3.createAccount(account);
    } else {
      System.out.println("Account with this number already exists.");
      return false;
    }
  }
  @GetMapping("/account/{accountNumber}")
 public synchronized String getBalance(@PathVariable int accountNumber) throws RemoteException {
   if (tier3.getAccount(accountNumber) == null) {
     return ""+0;
   }
   return ""+tier3.getAccount(accountNumber).getBalance();
 }


 @PostMapping("/account/{accountNumber}")
  public synchronized boolean updateBalance(@PathVariable int accountNumber, @RequestBody String request) throws RemoteException {
    Account account = tier3.getAccount(accountNumber);
    Request req = new Gson().fromJson(request, Request.class);
    if (req.getRequestType().equals("deposit")) {
      if (account != null) {
        account.updateBalance(req.getAmount());
        //should check if amount is positive
        tier3.updateAccount(account);
        return true;
      }
    }
    else {
      if (account == null)
        return false;
      else if (req.getAmount() <= 0.0 || req.getAmount() > account.getBalance())
        return false;
      else {
        account.updateBalance(-req.getAmount());
        tier3.updateAccount(account);
        return true;
      }
    }
    return false;
  }

}
