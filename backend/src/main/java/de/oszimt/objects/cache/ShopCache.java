package de.oszimt.objects.cache;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.oszimt.objects.logger.LogType;
import de.oszimt.objects.logger.Logger;

import java.sql.ResultSet;
import java.sql.Types;

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
                for(int iterator = 1; iterator < data.getMetaData().getColumnCount(); iterator++) {
                    switch (data.getMetaData().getColumnType(iterator)) {
                        case Types.BOOLEAN : object.addProperty(data.getMetaData().getColumnName(iterator), data.getBoolean(iterator)); break;
                        case Types.TINYINT : object.addProperty(data.getMetaData().getColumnName(iterator), data.getBoolean(iterator)); break;
                        case Types.INTEGER : object.addProperty(data.getMetaData().getColumnName(iterator), data.getInt(iterator)); break;
                        default : object.addProperty(data.getMetaData().getColumnName(iterator), data.getString(iterator)); break;
                    }
                }
                jsonArray.add(object);
            }
            this.logger.log(LogType.INFO, "The cache was filled with shops from the database.");
        } catch (Exception e) {
            e.printStackTrace();
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
