package com.aaron_tejero.mascotaspersistencia.restApi.adapter;

import com.aaron_tejero.mascotaspersistencia.restApi.ConstantesRestApi;
import com.aaron_tejero.mascotaspersistencia.restApi.EndPointsApi;
import com.aaron_tejero.mascotaspersistencia.restApi.deserializador.BusquedaDeserializador;
import com.aaron_tejero.mascotaspersistencia.restApi.deserializador.MascotaDeserializador;
import com.aaron_tejero.mascotaspersistencia.restApi.deserializador.PerfilDeserializador;
import com.aaron_tejero.mascotaspersistencia.restApi.deserializador.SeguidorDeserializador;
import com.aaron_tejero.mascotaspersistencia.restApi.model.BusquedaResponse;
import com.aaron_tejero.mascotaspersistencia.restApi.model.ListaImagenesResponse;
import com.aaron_tejero.mascotaspersistencia.restApi.model.PerfilResponse;
import com.aaron_tejero.mascotaspersistencia.restApi.model.SeguidoresResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AaronTejero on 04/07/2016.
 */
public class RestApiAdapter {

    public EndPointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndPointsApi.class);
    }

    public Gson construyendoDeserealizadorMascotas(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ListaImagenesResponse.class, new MascotaDeserializador());
        return gsonBuilder.create();
    }

    public Gson construyeDeserealizadorSeguidores(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SeguidoresResponse.class, new SeguidorDeserializador());
        return gsonBuilder.create();
    }

    public Gson construyendoDeserealizadorBusqueda() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BusquedaResponse.class, new BusquedaDeserializador());
        return gsonBuilder.create();
    }

    public Gson construyendoDeserealizadorMascotaPerfil(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PerfilResponse.class, new PerfilDeserializador());
        return gsonBuilder.create();
    }
}
