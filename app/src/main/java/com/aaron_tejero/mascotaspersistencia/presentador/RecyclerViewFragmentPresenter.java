package com.aaron_tejero.mascotaspersistencia.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.aaron_tejero.mascotaspersistencia.Fragments.IRecyclerviewFragment;
import com.aaron_tejero.mascotaspersistencia.db.ConstructorMascotas;
import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;
import com.aaron_tejero.mascotaspersistencia.pojo.Seguidores;
import com.aaron_tejero.mascotaspersistencia.restApi.EndPointsApi;
import com.aaron_tejero.mascotaspersistencia.restApi.adapter.RestApiAdapter;
import com.aaron_tejero.mascotaspersistencia.restApi.model.ListaImagenesResponse;
import com.aaron_tejero.mascotaspersistencia.restApi.model.SeguidoresResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AaronTejero on 30/05/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    IRecyclerviewFragment iRecyclerviewFragment;
    Context context;
    private ConstructorMascotas constructorMascotas;
    ArrayList<Mascota> mascotas=new ArrayList<>();
    ArrayList<Seguidores> seguidores=new ArrayList<>();

    public RecyclerViewFragmentPresenter(IRecyclerviewFragment iRecyclerviewFragment,Context context) {
        this.iRecyclerviewFragment=iRecyclerviewFragment;
        this.context=context;
        //obtenerMascotasBD();
        obtenerSeguidores();
       //obtenerImagenesMascotas();
        mostrarMascotasRV();
    }

    @Override
    public void obtenerMascotasBD() {

        constructorMascotas=new ConstructorMascotas(context);
        mascotas=constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerviewFragment.inicializarAdaptadorRV(iRecyclerviewFragment.crearAdaptador(mascotas));
        iRecyclerviewFragment.generarLinearLayoutVertical();
    }

    @Override
    public void obtenerImagenesMascotas() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson = restApiAdapter.construyendoDeserealizadorMascotas();
        EndPointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gson);

        for (int i=0;i<seguidores.size();i++){
            String id = seguidores.get(i).getId();
            Call<ListaImagenesResponse> listaImagenesResponseCall = endpointsApi.getRecentMediaUser(id);
            listaImagenesResponseCall.enqueue(new Callback<ListaImagenesResponse>() {
                @Override
                public void onResponse(Call<ListaImagenesResponse> call, Response<ListaImagenesResponse> response) {

                    ListaImagenesResponse listaImagenesResponse=response.body();
                    ArrayList<Mascota> mascotasaux=new ArrayList<>();
                    mascotasaux=listaImagenesResponse.getMascotas();
                   // mostrarMascotasRV();
                    mascotas.addAll(mascotasaux);
                }

                @Override
                public void onFailure(Call<ListaImagenesResponse> call, Throwable t) {
                    Toast.makeText(context, "Fallo Mascotas: " + t.toString(), Toast.LENGTH_LONG).show();
                    Log.e("FALLO LA CONEXION", t.toString());
                }
            });
        }


    }

    @Override
    public void obtenerSeguidores() {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson = restApiAdapter.construyeDeserealizadorSeguidores();
        EndPointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gson);
        Call<SeguidoresResponse> seguidoresResponseCall=endpointsApi.getSeguidores();
        seguidoresResponseCall.enqueue(new Callback<SeguidoresResponse>() {
            @Override
            public void onResponse(Call<SeguidoresResponse> call, Response<SeguidoresResponse> response) {
                SeguidoresResponse seguidoresResponse=response.body();

                seguidores=seguidoresResponse.getSeguidores();
                /*Seguidores yo = new Seguidores();
                yo.setId("3436368772");
                yo.setNombre("Aaron Tejero");
                yo.setUsuario("atena_alana");
                seguidores.add(yo);*/
                obtenerImagenesMascotas();
                mostrarMascotasRV();

            }

            @Override
            public void onFailure(Call<SeguidoresResponse> call, Throwable t) {
                Toast.makeText(context, "Fallo Seguidores TODAS FOTOS: " + t.toString(), Toast.LENGTH_LONG).show();
                //Log.e("FALLO LA CONEXION SEGUIDORES", t.toString());

            }
        });
    }

}
