package com.aaron_tejero.mascotaspersistencia.restApi.deserializador;

import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;
import com.aaron_tejero.mascotaspersistencia.restApi.model.JsonKeys;
import com.aaron_tejero.mascotaspersistencia.restApi.model.PerfilResponse;
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
 * Created by AaronTejero on 06/07/2016.
 */
public class PerfilDeserializador implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PerfilResponse perfilResponse = gson.fromJson(json, PerfilResponse.class);
        JsonArray jsonArray = json.getAsJsonObject().getAsJsonArray(JsonKeys.TIMELINE_ARRAY);
        perfilResponse.setMascotas(deserealizadorPerfil(jsonArray));
        return perfilResponse;
    }

    private ArrayList<Mascota> deserealizadorPerfil(JsonArray jsonArray) {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        for(int i = 0; i < jsonArray.size(); i++ ){
            JsonObject mascotasDataObject = jsonArray.get(i).getAsJsonObject();
            Mascota item = new Mascota();
            JsonObject imageJson = mascotasDataObject.getAsJsonObject(JsonKeys.TIMELINE_IMAGES);
            JsonObject stdUrlJson = imageJson.getAsJsonObject(JsonKeys.TIMELINE_STANDAR);
            item.setUrlFoto(stdUrlJson.get(JsonKeys.TIMELINE_URLFOTO).getAsString());

            JsonObject likesJson = mascotasDataObject.getAsJsonObject(JsonKeys.TIMELINE_LIKES);
            item.setRaiting(likesJson.get(JsonKeys.TIMELINE_LIKES_COUNT).getAsInt());
            mascotas.add(item);
        }

        return mascotas;
    }
}
