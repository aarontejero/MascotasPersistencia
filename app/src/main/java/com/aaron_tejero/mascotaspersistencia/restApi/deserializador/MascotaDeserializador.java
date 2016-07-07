package com.aaron_tejero.mascotaspersistencia.restApi.deserializador;

import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;
import com.aaron_tejero.mascotaspersistencia.restApi.model.JsonKeys;
import com.aaron_tejero.mascotaspersistencia.restApi.model.ListaImagenesResponse;
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
 * Created by AaronTejero on 04/07/2016.
 */
public class MascotaDeserializador implements JsonDeserializer<ListaImagenesResponse> {


        @Override
    public ListaImagenesResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Gson gson=new Gson();
            ListaImagenesResponse listaImagenesResponse=gson.fromJson(json,ListaImagenesResponse.class);
            JsonArray listaImagenesReponseData=json.getAsJsonObject().getAsJsonArray(JsonKeys.TIMELINE_ARRAY);

            listaImagenesResponse.setMascotas(deserealizadorImages(listaImagenesReponseData));
            return listaImagenesResponse;
    }

    private ArrayList<Mascota> deserealizadorImages(JsonArray listaImagenesResponseData){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        for (int i=0; i < listaImagenesResponseData.size();i++){
            JsonObject mascotasDataObject = listaImagenesResponseData.get(i).getAsJsonObject();

            Mascota item = new Mascota();

            JsonObject userJson = mascotasDataObject.getAsJsonObject(JsonKeys.TIMELINE_USER);
            item.setId(userJson.get(JsonKeys.TIMELINE_IDUSER).getAsString());
            item.setNombreCompleto(userJson.get(JsonKeys.TIMELINE_FULLNAME).getAsString());

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
