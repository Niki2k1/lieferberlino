package de.oszimt.objects.geo;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import de.oszimt.objects.LocationIQConnector;
import express.http.HttpRequestHandler;
import express.http.request.Request;
import express.http.response.Response;

import java.io.IOException;

public class MapAddressRequestHandler implements HttpRequestHandler {

    private LocationIQConnector locationIQConnector;

    public MapAddressRequestHandler(LocationIQConnector locationIQConnector) {
        this.locationIQConnector = locationIQConnector;
    }

    @Override
    public void handle(Request request, Response response) {
        try {
            Address address = locationIQConnector.getAddressFromAddressString(request.getQuery("address"));
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("address", address.asString());
            response.send(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
