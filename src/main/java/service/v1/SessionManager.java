package service.v1;

import java.util.HashMap;
import java.util.Random;

public class SessionManager {

    private static SessionManager gestore = null;
    private static final HashMap<String, String> users = new HashMap<>();

    private SessionManager() {
    }
    
    public static synchronized SessionManager getSessionManager() {
        if (gestore == null) {
            gestore = new SessionManager();
        }
        return gestore;
    }

    public User getUser(String cookieValue) {
        return UserManager.existUser(users.get(cookieValue));
    }
    
    public String newSession(User user) {
        Random r = new Random();
        String cookie = "" + r.nextInt()*1000000;
        users.put(cookie, user.getUsername());
        return cookie;
    }

}
