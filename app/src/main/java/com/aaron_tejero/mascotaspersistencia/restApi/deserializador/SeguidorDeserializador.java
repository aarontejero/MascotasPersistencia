package com.aaron_tejero.mascotaspersistencia.restApi.deserializador;

import com.aaron_tejero.mascotaspersistencia.pojo.Seguidores;
import com.aaron_tejero.mascotaspersistencia.restApi.model.JsonKeys;
import com.aaron_tejero.mascotaspersistencia.restApi.model.SeguidoresResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by AaronTejero on 05/07/2016.
 */
public class SeguidorDeserializador implements JsonDeserializer {

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        SeguidoresResponse seguidoresResponse = gson.fromJson(json, SeguidoresResponse.class);
        JsonArray jsonArray = json.getAsJsonObject().getAsJsonArray(JsonKeys.FOLLOWED_ARRAY);
        seguidoresResponse.setSeguidores(deserealizadorSeguidores(jsonArray));
        return seguidoresResponse;
    }

    private ArrayList<Seguidores> deserealizadorSeguidores(JsonArray jsonArray) {
        ArrayList<Seguidores> seguidores = new ArrayList<>();
        for(int i = 0; i < jsonArray.size(); i++){
            JsonObject followedDataObject = jsonArray.get(i).getAsJsonObject();
            Seguidores item = new Seguidores();
            item.setId(followedDataObject.get(JsonKeys.FOLLOWED_ID).getAsString());
            item.setNombre(followedDataObject.get(JsonKeys.FOLLOWED_FULLNAME).getAsString());
            item.setUsuario(followedDataObject.get(JsonKeys.FOLLOWED_USERNAME).getAsString());
            item.setFotoPerfil(followedDataObject.get(JsonKeys.FOLLOWED_PROFILE_PICTURE).getAsString());

            seguidores.add(item);
        }

        return seguidores;
    }


}
