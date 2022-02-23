package service.v1;

import java.util.HashMap;

public class UserManager {
    
    private static final HashMap<String, User> users = new HashMap<>();
    
    public static void addUser(User user) {
        if (!users.containsKey(user.getUsername()))
            users.put(user.getUsername(), user);
    }

    private static void addTestUsers() {
        User user = new User("utente1", "password");
        users.put(user.getUsername(), user);
        user = new User("utente2", "1234");
        users.put(user.getUsername(), user);
    }

    public static User existUser(String username) {
        if(users.isEmpty()) addTestUsers();
        try{
            return users.get(username);
        }catch(Exception e){
            return null;
        }
    }
}
