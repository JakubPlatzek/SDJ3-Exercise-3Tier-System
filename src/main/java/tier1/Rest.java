package tier1;

import com.google.gson.Gson;
import model.Request;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Objects;

public class Rest {
    private static final String ROOT = "http://localhost:8080/";

    private RestTemplate rest = new RestTemplate();

    public boolean createAccount(int accountNumber){
        rest.put(ROOT + "account/" + accountNumber, null);
        return true;
    }
    //Check response
    public boolean deposit(int number, double amount){
        URI response = rest.postForLocation(ROOT + "account/" + number, new Gson().toJson(new Request("deposit",amount)));
        return true;
    }
    //Check for response
    public boolean withdraw(int accountNumber, double amount){
      URI response = rest.postForLocation(ROOT + "account/" + accountNumber, new Gson().toJson(new Request("withdraw",amount)));
      return true;
   }

    public double getBalance(int accountNumber){
        String response = rest.getForObject(ROOT + "account/" + accountNumber, String.class);
        if (response != null){
            return Double.parseDouble(response);
        }
        return -1.0;
   }

}
