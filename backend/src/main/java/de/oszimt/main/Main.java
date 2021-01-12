package de.oszimt.main;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.oszimt.objects.DataParser;
import de.oszimt.objects.LocationIQConnector;
import de.oszimt.objects.SQLConnection;
import de.oszimt.objects.cache.ShopCache;
import de.oszimt.objects.geo.MapAddressRequestHandler;
import de.oszimt.objects.logger.LogType;
import de.oszimt.objects.logger.Logger;
import de.oszimt.objects.middleware.Cors;
import de.oszimt.objects.middleware.CorsOptions;
import de.oszimt.objects.routes.GeoRoute;
import de.oszimt.objects.routes.LoginRoute;
import de.oszimt.objects.routes.ShopRoute;
import express.Express;
import express.middleware.Middleware;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static Logger logger;
    public static SQLConnection sqlConnection;
    public static Express express;
    public static ShopCache shopCache;

    /**
     * Main method from java project.
     */
    public static void main(String[] args) throws IOException, InterruptedException, SQLException {
        logger = new Logger();
        sqlConnection = new SQLConnection("jdbc:mysql://db.niki2k1.de:3306/lieferberlino?autoReconnect=true", logger);
        // Create all tables.
        sqlConnection.execute("CREATE TABLE IF NOT EXISTS T_Shops (id INTEGER NOT NULL AUTO_INCREMENT, name VARCHAR(255), street VARCHAR(100), postalcode INTEGER, type VARCHAR(150), offer TEXT, delivery BOOLEAN, description_delivery TEXT, self_pickup BOOLEAN, description_self_pickup TEXT, fon VARCHAR(50), website VARCHAR(100), mail VARCHAR(50), monday VARCHAR(100), tuesday VARCHAR(100), wednesday VARCHAR(100), thursday VARCHAR(100), friday VARCHAR(100), saturday VARCHAR(100), sunday VARCHAR(100), location VARCHAR(100), PRIMARY KEY (id), image VARCHAR(255))");
        shopCache = new ShopCache(sqlConnection.select("SELECT * FROM T_Shops"), logger);
        // Parse json file.
        express = new Express();
        // Use cookieSession in middleware.
        express.use(Middleware.cookieSession("sessioncookie", 9000));
        CorsOptions corsOptions = new CorsOptions();
        corsOptions.setOrigin("*");
        express.use(new Cors(corsOptions));
        // Init all router.
        LoginRoute loginRoute = new LoginRoute();
        ShopRoute shopRoute = new ShopRoute(shopCache);

        //Init LocationIQ
        LocationIQConnector locationIQConnector = new LocationIQConnector("94aea696b2c0ba", new Gson(), new Logger());
        MapAddressRequestHandler mapAddressRequestHandler = new MapAddressRequestHandler(locationIQConnector);
        GeoRoute geoRoute = new GeoRoute(mapAddressRequestHandler);

        /*DataParser dataParser = new DataParser(new File("./data.json"));
        // Get data from DataParser.
        JsonObject data = dataParser.getData();

        // Get json
        JsonArray jsonArray = data.get("index").getAsJsonArray();
        JsonObject address;
        String latAndLon;
        Integer pos = 0;
        Integer max = 0;*/
        /*ResultSet number = sqlConnection.select("SELECT id FROM T_Shops");
        if(number.next()) {
            max = number.getFetchSize();
        }
        System.out.println(pos);
        for(JsonElement jsonElement : jsonArray) {
            JsonObject item = jsonElement.getAsJsonObject();
            if(item.get("art").getAsString().toLowerCase().startsWith("gastronomie")) {
                pos++;
                if(pos > max) {
                    address = locationIQConnector.getAddressFromAddressString((item.get("strasse_nr").getAsString() + " " + item.get("plz").getAsString()));
                    latAndLon = address.get("lat").getAsString() + ";" + address.get("lon").getAsString();
                    sqlConnection.execute("INSERT INTO T_Shops (name, street, postalcode, type, offer, delivery, description_delivery, self_pickup, description_self_pickup, fon, website, mail, monday, tuesday, wednesday, thursday, friday, saturday, sunday, location) VALUES ('" + item.get("name").getAsString() + "', '" + item.get("strasse_nr").getAsString() + "', '" + item.get("plz").getAsString() + "', '" + item.get("art").getAsString() + "', '" + item.get("angebot").getAsString() + "', " + item.get("lieferung").getAsBoolean() + ", '" + item.get("beschreibung_lieferangebot").getAsString() + "', " + item.get("selbstabholung").getAsBoolean() + ", '" + item.get("angebot_selbstabholung").getAsString() + "', '" + item.get("fon").getAsString() + "', '" + item.get("w3").getAsString() + "', '" + item.get("mail").getAsString() + "', '" + item.get("montag").getAsString() + "', '" + item.get("dienstag").getAsString() + "', '" + item.get("mittwoch").getAsString() + "', '" + item.get("donnerstag").getAsString() + "', '" + item.get("freitag").getAsString() + "', '" + item.get("samstag").getAsString() + "', '" + item.get("sonntag").getAsString() + "', '" + latAndLon + "')");
                    logger.log(LogType.INFO, "Eintrag wurde erstellt!");
                    Thread.sleep(1000);
                }
            }
        }*/
        // Register all router.
        express.use("/user", loginRoute.getRouter());
        express.use("/geo", geoRoute.getRouter());
        express.use("/shops", shopRoute.getRouter());
        // Listen app.
        express.listen(5000);
    }
}
