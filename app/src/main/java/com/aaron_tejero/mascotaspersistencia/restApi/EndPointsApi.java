package com.aaron_tejero.mascotaspersistencia.restApi;

import com.aaron_tejero.mascotaspersistencia.restApi.model.BusquedaResponse;
import com.aaron_tejero.mascotaspersistencia.restApi.model.ListaImagenesResponse;
import com.aaron_tejero.mascotaspersistencia.restApi.model.PerfilResponse;
import com.aaron_tejero.mascotaspersistencia.restApi.model.SeguidoresResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by AaronTejero on 04/07/2016.
 */
public interface EndPointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_OTHER)
    Call<ListaImagenesResponse> getRecentMediaUser(@Path("id") String id);

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_OTHER)
    Call<PerfilResponse> getRecentMediaOtherPerfil(@Path("id") String id);

   @GET(ConstantesRestApi.URL_GET_FOLLOWEDBY)
   Call <SeguidoresResponse> getSeguidores();


    @GET(ConstantesRestApi.URL_SEARCH_USER)
    Call<BusquedaResponse> getUsuarioBusqueda(@Query("q") String jack, @Query("access_token") String access_token);
}
