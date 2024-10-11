package AndrewWebServices;
import java.util.HashMap;
import java.util.Map;

/*
 * InMemoryDatabase is a fake for the AndrewWS database which is used to improve test efficiency.
 * Remember, fakes are fully functional classes with simplified implementation.
 * What is the simplest core functionality that we need for a functional database?
 * 
 * Hint: there are two methods you need to implement
 */
public class InMemoryDatabase extends Database/* should there be something here? */ {
    // Implement your fake database here
    private Map<String, Integer> accounts;
    public InMemoryDatabase() {
        accounts = new HashMap<>();
        accounts.put("Scotty", 17214);
    }

    @Override
    public int getPassword(String accountName) {
        return accounts.getOrDefault(accountName, -1);
    }

    public void addAccount(String accountName, int password) {
        accounts.put(accountName, password);
    }

}