import java.util.HashMap;
import java.util.Map;

public class UserAuthentication {
    private Map<String, String> userDatabase;

    public UserAuthentication() {
        userDatabase = new HashMap<>();
        // Hardcoded users for demonstration purposes
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    public boolean verifyCredentials(String username, String password) {
        if (userDatabase.containsKey(username)) {
            return userDatabase.get(username).equals(password);
        }
        return false;
    }
}
