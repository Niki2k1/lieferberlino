package de.oszimt.objects.geo;

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
            Address address = locationIQConnector.getAddressFromGeoLocation(Double.parseDouble(request.getQuery("lat")), Double.parseDouble(request.getQuery("lon")));
            response.send(address.asString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
