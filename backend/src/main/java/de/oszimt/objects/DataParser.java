package de.oszimt.objects;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataParser {

    private JsonObject data;

    /**
     * Constructor from Object.
     */
    public DataParser(File file) {
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = null;
        try {
            jsonElement = parser.parse(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.data = jsonElement.getAsJsonObject();
    }
    /**
     * Get data.
     */
    public JsonObject getData() {
        return data;
    }
}
