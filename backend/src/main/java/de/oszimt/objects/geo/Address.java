package de.oszimt.objects.geo;

import com.google.gson.JsonElement;

public class Address {

    private String road;
    private String houseNumber;
    private String postCode;
    private String state;

    public Address(String road, String houseNumber, String postCode, String state) {
        this.road = road;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
        this.state = state;
    }

    public String getRoad() {
        return road;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getState() {
        return state;
    }

    public String asString() {
        return road + " " + houseNumber + ", " + postCode + " " + state;
    }

    public static Address fromJson(JsonElement address) {
        return new Address(
            address.getAsJsonObject().get("path") == null ? address.getAsJsonObject().get("road").getAsString() : address.getAsJsonObject().get("path").getAsString(),
            address.getAsJsonObject().get("house_number") == null ? "unbekannt" : address.getAsJsonObject().get("house_number").getAsString(),
            address.getAsJsonObject().get("postcode").getAsString(),
            address.getAsJsonObject().get("state").getAsString()
        );
    }
}
