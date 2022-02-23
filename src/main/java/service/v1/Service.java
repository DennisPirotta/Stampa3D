package service.v1;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;

@ApplicationPath("")
@Path("/")
public class Service extends Application {

    private static SessionManager sm = SessionManager.getSessionManager();

    @Context
    ServletContext servletContext;

    @GET
    @Path("home")
    public Response index(@Context HttpHeaders headers) {
        try {
            File index = new File(servletContext.getRealPath("/WEB-INF/classes/index.html"));
            return Response
                    .ok(new FileInputStream(index))
                    .build();
        }catch (FileNotFoundException e){
            return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
        }
    }


    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response controllaLogin(@FormParam("username") String username, @FormParam("password") String password) {
        User user = UserManager.existUser(username);
        if (user != null && passwordCorretta(username, password)) {
            return Response
                    .seeOther(URI.create("home"))
                    .cookie(new NewCookie("sessionId", sm.newSession(user)))
                    .build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private boolean passwordCorretta(String username, String password) {
        return "utente1".equals(username) && "password".equals(password) || "utente2".equals(username) && "1234".equals(password);
    }


}