package de.oszimt.objects.routes;

import de.oszimt.objects.geo.MapAddressRequestHandler;
import express.ExpressRouter;

public class GeoRoute {

    private ExpressRouter app;
    private MapAddressRequestHandler mapAddressRequestHandler;

    /**
     * Constructor from object.
     */
    public GeoRoute(MapAddressRequestHandler mapAddressRequestHandler) {
        this.mapAddressRequestHandler = mapAddressRequestHandler;
        this.app = new ExpressRouter() {{
           get("/mapAddress", mapAddressRequestHandler);
        }};
    }
    public ExpressRouter getRouter() {
        return this.app;
    }
}
