package de.oszimt.objects.routes;

import de.oszimt.objects.TimeParser;
import de.oszimt.objects.cache.ShopCache;
import express.ExpressRouter;

import java.util.Calendar;
import java.util.Date;

public class ShopRoute {

    private ExpressRouter router;

    /**
     * Constructor from object.
     */
    public ShopRoute(ShopCache shopCache) {
        this.router = new ExpressRouter() {{
            // Route to get all shops out cache.
            get("/getShops", (req, res) -> {
                Calendar c = Calendar.getInstance();
                c.setTime(new Date());
                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                System.out.println(dayOfWeek);
                for(Integer i = 0; i < shopCache.getCachedShops().size(); i++) {
                    System.out.println(shopCache.getCachedShops().get(i).getAsJsonObject().get("monday").getAsString());
                    switch (dayOfWeek) {
                        case 2 :
                            if(!shopCache.getCachedShops().get(i).getAsJsonObject().get("monday").getAsString().isEmpty()) {
                                TimeParser timeParser = new TimeParser(shopCache.getCachedShops().get(i).getAsJsonObject().get("monday").getAsString());
                                shopCache.getCachedShops().get(i).getAsJsonObject().addProperty("isOpen", timeParser.isOpen());
                                break;
                            } else {
                                shopCache.getCachedShops().get(i).getAsJsonObject().addProperty("isOpen", false);
                                break;
                            }
                        case 3 :
                            if(!shopCache.getCachedShops().get(i).getAsJsonObject().get("tuesday").getAsString().isEmpty()) {
                                TimeParser timeParser = new TimeParser(shopCache.getCachedShops().get(i).getAsJsonObject().get("tuesday").getAsString());
                                shopCache.getCachedShops().get(i).getAsJsonObject().addProperty("isOpen", timeParser.isOpen());
                                break;
                            } else {
                                shopCache.getCachedShops().get(i).getAsJsonObject().addProperty("isOpen", false);
                                break;
                            }
                        case 4 :
                            if(!shopCache.getCachedShops().get(i).getAsJsonObject().get("wednesday").getAsString().isEmpty()) {
                                TimeParser timeParser = new TimeParser(shopCache.getCachedShops().get(i).getAsJsonObject().get("wednesday").getAsString());
                                shopCache.getCachedShops().get(i).getAsJsonObject().addProperty("isOpen", timeParser.isOpen());
                                break;
                            } else {
                                shopCache.getCachedShops().get(i).getAsJsonObject().addProperty("isOpen", false);
                                break;
                            }
                        case 5 :
                            if(!shopCache.getCachedShops().get(i).getAsJsonObject().get("thursday").getAsString().isEmpty()) {
                                TimeParser timeParser = new TimeParser(shopCache.getCachedShops().get(i).getAsJsonObject().get("thursday").getAsString());
                                shopCache.getCachedShops().get(i).getAsJsonObject().addProperty("isOpen", timeParser.isOpen());
                                break;
                            } else {
                                shopCache.getCachedShops().get(i).getAsJsonObject().addProperty("isOpen", false);
                                break;
                            }
                        case 6 :
                            if(!shopCache.getCachedShops().get(i).getAsJsonObject().get("friday").getAsString().isEmpty()) {
                                TimeParser timeParser = new TimeParser(shopCache.getCachedShops().get(i).getAsJsonObject().get("friday").getAsString());
                                shopCache.getCachedShops().get(i).getAsJsonObject().addProperty("isOpen", timeParser.isOpen());
                                break;
                            } else {
                                shopCache.getCachedShops().get(i).getAsJsonObject().addProperty("isOpen", false);
                                break;
                            }
                        case 7 :
                            if(!shopCache.getCachedShops().get(i).getAsJsonObject().get("saturday").getAsString().isEmpty()) {
                                TimeParser timeParser = new TimeParser(shopCache.getCachedShops().get(i).getAsJsonObject().get("saturday").getAsString());
                                shopCache.getCachedShops().get(i).getAsJsonObject().addProperty("isOpen", timeParser.isOpen());
                                break;
                            } else {
                                shopCache.getCachedShops().get(i).getAsJsonObject().addProperty("isOpen", false);
                                break;
                            }
                        case 1 :
                            if(!shopCache.getCachedShops().get(i).getAsJsonObject().get("sunday").getAsString().isEmpty()) {
                                TimeParser timeParser = new TimeParser(shopCache.getCachedShops().get(i).getAsJsonObject().get("sunday").getAsString());
                                shopCache.getCachedShops().get(i).getAsJsonObject().addProperty("isOpen", timeParser.isOpen());
                                break;
                            } else {
                                shopCache.getCachedShops().get(i).getAsJsonObject().addProperty("isOpen", false);
                                break;
                            }
                    }
                }
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
