package fr.nilowk.plugin.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ProfileSerializationManager {

    private Gson gson;

    public ProfileSerializationManager() {

        this.gson = createGsonInstance();

    }

    private Gson createGsonInstance() {

        return new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

    }

    public String serialize(Profile profile) {

        return this.gson.toJson(profile);

    }

    public Profile deserialize(String json) {

        return this.gson.fromJson(json, Profile.class);

    }

}
