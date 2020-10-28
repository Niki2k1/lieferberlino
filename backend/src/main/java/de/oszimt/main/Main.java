package de.oszimt.main;

import com.google.gson.Gson;
import de.oszimt.objects.LocationIQConnector;
import de.oszimt.objects.SQLConnection;
import de.oszimt.objects.geo.MapAddressRequestHandler;
import de.oszimt.objects.logger.Logger;
import de.oszimt.objects.middleware.Cors;
import de.oszimt.objects.middleware.CorsOptions;
import de.oszimt.objects.routes.GeoRoute;
import de.oszimt.objects.routes.LoginRoute;
import express.Express;
import express.middleware.Middleware;

import java.io.File;
import java.io.IOException;

public class Main {

    public static Logger logger;
    public static SQLConnection sqlConnection;
    public static Express express;

    /**
     * Main method from java project.
     */
    public static void main(String[] args) {
        logger = new Logger();
        sqlConnection = new SQLConnection("jdbc:mysql://0.0.0.0:3306/lieferberlino?autoReconnect=true", logger);
        // Create all tables.
        sqlConnection.execute("CREATE TABLE IF NOT EXISTS T_Shops (name VARCHAR(255), street VARCHAR(100), postalcode INTEGER, offer VARCHAR(255), delivery BOOLEAN, description_delivery TEXT, self_pickup BOOLEAN, description_self_pickup TEXT, fon VARCHAR(50), website VARCHAR(100), mail VARCHAR(50), monday VARCHAR(20), tuesday VARCHAR(20), wednesday VARCHAR(20), thursday VARCHAR(20), friday VARCHAR(20), saturday VARCHAR(20), sunday VARCHAR(20))");
        // Parse json file.

        /*
        DataParser dataParser = new DataParser(new File("./data.json"));
        // Get data from DataParser.
        JsonObject data = dataParser.getData();

        // Get json
        JsonArray jsonArray = data.get("index").getAsJsonArray();
        for(JsonElement jsonElement : jsonArray) {
            JsonObject item = jsonElement.getAsJsonObject();
            if(item.get("art").getAsString().toLowerCase().startsWith("gastronomie")) {
                sqlConnection.execute("INSERT INTO T_Shops (name, street, postalcode, offer, delivery, description_delivery, self_pickup, description_self_pickup, fon, website, mail, monday, tuesday, wednesday, thursday, friday, saturday, sunday) VALUES ('" + item.get("name").getAsString() + "', '" + item.get("strasse_nr").getAsString() + "', '" + item.get("plz").getAsString() + "', '" + item.get("art").getAsString() + "', '" + item.get("angebot").getAsString() + "', '" + item.get("lieferung").getAsString() + "', '" + item.get("beschreibung_lieferangebot").getAsString() + "', '" + item.get("selbstabholung").getAsString() + "', '" + item.get("angebot_selbstabholung").getAsString() + "', '" + item.get("fon").getAsString() + "', '" + item.get("w3").getAsString() + "', '" + item.get("mail").getAsString() + "', '" + item.get("montag").getAsString() + "', '" + item.get("dienstag").getAsString() + "', '" + item.get("mittwoch").getAsString() + "', '" + item.get("donnerstag").getAsString() + "', '" + item.get("freitag").getAsString() + "', '" + item.get("samstag").getAsString() + "', '" + item.get("sonntag").getAsString() + "')");
                logger.log(LogType.INFO, "Eintrag wurde erstellt!");
            }
        }
*/
        express = new Express();
        // Use cookieSession in middleware.
        express.use(Middleware.cookieSession("sessioncookie", 9000));
        CorsOptions corsOptions = new CorsOptions();
        corsOptions.setOrigin("*");
        express.use(new Cors(corsOptions));
        // Init all router.
        LoginRoute loginRoute = new LoginRoute();

        //Init LocationIQ
        LocationIQConnector locationIQConnector = new LocationIQConnector("94aea696b2c0ba", new Gson(), new Logger());
        MapAddressRequestHandler mapAddressRequestHandler = new MapAddressRequestHandler(locationIQConnector);
        GeoRoute geoRoute = new GeoRoute(mapAddressRequestHandler);
        express.use("/geo", geoRoute.getRouter());

        // Register all router.
        express.use("/user", loginRoute.getApp());
        // Listen app.
        express.listen(5000);
    }
}
