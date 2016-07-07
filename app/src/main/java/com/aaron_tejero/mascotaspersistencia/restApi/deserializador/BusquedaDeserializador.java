package com.aaron_tejero.mascotaspersistencia.restApi.deserializador;

import com.aaron_tejero.mascotaspersistencia.pojo.Seguidores;
import com.aaron_tejero.mascotaspersistencia.restApi.model.BusquedaResponse;
import com.aaron_tejero.mascotaspersistencia.restApi.model.JsonKeys;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by AaronTejero on 06/07/2016.
 */
public class BusquedaDeserializador implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        BusquedaResponse busquedaResponse = gson.fromJson(json, BusquedaResponse.class);
        JsonArray jsonArray = json.getAsJsonObject().getAsJsonArray(JsonKeys.SEARCH_ARRAY);
        busquedaResponse.setCuenta(deserealizadorBusqueda(jsonArray));
        return busquedaResponse;
    }

    private Seguidores deserealizadorBusqueda(JsonArray jsonArray) {
        Seguidores item = new Seguidores();
        if( jsonArray.size() > 0 ){
            JsonObject searchDataObject = jsonArray.get(0).getAsJsonObject();
            item.setNombre(searchDataObject.get(JsonKeys.SEARCH_FULLNAME).getAsString());
            item.setUsuario(searchDataObject.get(JsonKeys.SEARCH_USERNAME).getAsString());
            item.setFotoPerfil(searchDataObject.get(JsonKeys.SEARCH_PROFILEPICTURE).getAsString());
            item.setId(searchDataObject.get(JsonKeys.SEARCH_ID).getAsString());
        }
        else
            item.setUsuario("NoEncontrado");
        return item;

    }

}
