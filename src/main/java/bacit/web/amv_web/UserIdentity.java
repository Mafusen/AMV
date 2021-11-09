package bacit.web.amv_web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@WebServlet
public class UserIdentity extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Principal p = request.getUserPrincipal();
        if (p == null)
            log("No user logged in.");
        else {
            log("Principal: " + p.getName());
            log("User name: " + request.getRemoteUser());
        }

        // ...
    }


}


