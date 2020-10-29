package de.oszimt.objects.cache;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.oszimt.objects.logger.LogType;
import de.oszimt.objects.logger.Logger;

import java.sql.ResultSet;

public class ShopCache {

    private JsonArray jsonArray;
    private Logger logger;

    /**
     * Constructor from object.
     */
    public ShopCache(ResultSet data, Logger logger) {
        this.jsonArray = new JsonArray();
        this.logger = logger;
        try {
            JsonObject object;
            while(data.next()) {
                object = new JsonObject();
                object.addProperty("name", data.getString("name"));
                object.addProperty("street", data.getString("street"));
                object.addProperty("postalcode", data.getString("postalcode"));
                object.addProperty("offer", data.getString("offer"));
                object.addProperty("delivery", data.getString("delivery"));
                object.addProperty("description_delivery", data.getString("description_delivery"));
                object.addProperty("self_pickup", data.getBoolean("self_pickup"));
                object.addProperty("description_self_pickup", data.getString("description_self_pickup"));
                object.addProperty("fon", data.getString("fon"));
                object.addProperty("website", data.getString("website"));
                object.addProperty("mail", data.getString("mail"));
                object.addProperty("monday", data.getString("monday"));
                object.addProperty("tuesday", data.getString("tuesday"));
                object.addProperty("wednesday", data.getString("wednesday"));
                object.addProperty("thursday", data.getString("thursday"));
                object.addProperty("friday", data.getString("friday"));
                object.addProperty("saturday", data.getString("saturday"));
                object.addProperty("sunday", data.getString("sunday"));
                jsonArray.add(object);
            }
            this.logger.log(LogType.INFO, "The cache was filled with shops from the database.");
        } catch (Exception e) {
            this.logger.log(LogType.ERROR, "Can't parse shops from database.");
        }
    }
    /**
     * Get cached shops as JsonArray.
     */
    public JsonArray getCachedShops() {
        return this.jsonArray;
    }
}
