//package service.v1;
//
//import java.net.URI;
//import javax.ws.rs.*;
//import javax.ws.rs.core.*;
//
//@Path("login")
//public class Login {
//
//    private final SessionManager sm = SessionManager.getSessionManager();
//
//    @POST
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public Response controllaLogin(@FormParam("username") String username, @FormParam("password") String password) {
//        User user = UserManager.existUser(username);
//        if (user != null && passwordCorretta(username, password)) {
//            return Response
//                    .seeOther(URI.create("../home.html"))
//                    .cookie(new NewCookie("sessionId", sm.newSession(user)))
//                    .build();
//        } else {
//            return Response.status(Response.Status.UNAUTHORIZED).build();
//        }
//    }
//
//    private boolean passwordCorretta(String username, String password) {
//        return "utente1".equals(username) && "password".equals(password) || "utente2".equals(username) && "1234".equals(password);
//    }
//
//}

