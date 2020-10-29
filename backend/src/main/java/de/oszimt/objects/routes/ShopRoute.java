package de.oszimt.objects.routes;

import de.oszimt.objects.cache.ShopCache;
import express.ExpressRouter;

public class ShopRoute {

    private ExpressRouter router;

    /**
     * Constructor from object.
     */
    public ShopRoute(ShopCache shopCache) {
        this.router = new ExpressRouter() {{
            // Route to get all shops out cache.
            get("/getShops", (req, res) -> {
                res.setContentType("application/json");
                res.send(shopCache.getCachedShops().toString());
            });
        }};
    }
    /**
     * Get router.
     */
    public ExpressRouter getRouter() {
        return this.router;
    }
}
