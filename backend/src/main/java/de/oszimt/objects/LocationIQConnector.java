package de.oszimt.objects;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.oszimt.objects.geo.Address;
import de.oszimt.objects.logger.LogType;
import de.oszimt.objects.logger.Logger;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class LocationIQConnector {

    private final String apikey;
    private final Gson gson;
    private final Logger logger;

    public LocationIQConnector(String apikey, Gson gson, Logger logger) {
        this.apikey = apikey;
        this.gson = gson;
        this.logger = logger;
    }

    public Address getAddressFromGeoLocation(double lat, double lon) throws IOException {
        URL url = new URL("https://eu1.locationiq.com/v1/reverse.php?key=" + this.apikey + "&lat=" + lat + "&lon=" + lon + "&format=json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        String responseString = IOUtils.toString(con.getInputStream(), StandardCharsets.UTF_8);
        con.disconnect();

        JsonObject response = gson.fromJson(responseString, JsonObject.class);

        Address address = Address.fromJson(response.get("address"));

        this.logger.log(LogType.INFO, address.asString());

        return address;
    }
    public Address getAddressFromAddressString(String addressString) throws IOException {
        URL url = new URL("https://eu1.locationiq.com/v1/search.php?key=" + this.apikey + "&q=" + addressString + "&format=json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        String responseString = IOUtils.toString(con.getInputStream(), StandardCharsets.UTF_8);
        con.disconnect();
        JsonArray array = gson.fromJson(responseString, JsonArray.class);
        JsonObject response = array.get(0).getAsJsonObject();
        return getAddressFromGeoLocation(Double.parseDouble(response.get("lat").getAsString()), Double.parseDouble(response.get("lon").getAsString()));
    }
}
