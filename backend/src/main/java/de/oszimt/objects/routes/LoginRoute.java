package de.oszimt.objects.routes;

import express.ExpressRouter;
import express.http.SessionCookie;

public class LoginRoute {

    private ExpressRouter app;

    /**
     * Constructor from object.
     */
    public LoginRoute() {
        this.app = new ExpressRouter() {{
           // Login route.
           get("/login", (req, res) -> {
               SessionCookie sessionCookie = (SessionCookie) req.getMiddlewareContent("sessioncookie");
               System.out.println(sessionCookie.getData());
               if(sessionCookie.getData() == null) {
                   sessionCookie.setData("Ehre");
               }
               System.out.println(sessionCookie.getData());
               res.send("Ehre");
           });
        }};
    }
    public ExpressRouter getRouter() {
        return this.app;
    }
}
