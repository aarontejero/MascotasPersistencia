package com.aaron_tejero.mascotaspersistencia.presentador;

import android.content.Context;
import android.widget.Toast;

import com.aaron_tejero.mascotaspersistencia.Fragments.IperfilFragment;
import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;
import com.aaron_tejero.mascotaspersistencia.pojo.Seguidores;
import com.aaron_tejero.mascotaspersistencia.restApi.ConstantesRestApi;
import com.aaron_tejero.mascotaspersistencia.restApi.EndPointsApi;
import com.aaron_tejero.mascotaspersistencia.restApi.adapter.RestApiAdapter;
import com.aaron_tejero.mascotaspersistencia.restApi.model.BusquedaResponse;
import com.aaron_tejero.mascotaspersistencia.restApi.model.PerfilResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AaronTejero on 06/07/2016.
 */
public class PerfilFragmentPresenter implements IPerfilFragmentPresenter {


    IperfilFragment iPerfilfragment;
    private Context context;
    private ArrayList<Mascota> mascotas;
    private Seguidores usuario=new Seguidores();
    private String cuentaInstagram;

    public PerfilFragmentPresenter(IperfilFragment iPerfilFragment, Context context, String cuentaUser) {
        this.iPerfilfragment = iPerfilFragment;
        this.context = context;
        this.cuentaInstagram = cuentaUser;
        obtenerFotoPerfilInstagram();
    }

    @Override
    public void obtenerPerfil() {

    }

    @Override
    public void mostrarPerfilRV() {
        iPerfilfragment.creaImagenPerfil(usuario);
        iPerfilfragment.inicializaAdaptadorPerfil(iPerfilfragment.crearAdaptadorPerfil(mascotas));
        iPerfilfragment.generarGridLayout();
    }

    @Override
    public void obtenerPerfilInsagram() {
        if(!usuario.getUsuario().equals("No encontrado")){
            RestApiAdapter  restApiAdapter = new RestApiAdapter();
            Gson gson = restApiAdapter.construyendoDeserealizadorMascotaPerfil();
            EndPointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gson);
            mascotas = new ArrayList<>();
            Call<PerfilResponse> perfilResponseCall = endpointsApi.getRecentMediaOtherPerfil(usuario.getId());
            perfilResponseCall.enqueue(new Callback<PerfilResponse>() {
                @Override
                public void onResponse(Call<PerfilResponse> call, Response<PerfilResponse> response) {
                    PerfilResponse perfilResponse = response.body();
                    mascotas = perfilResponse.getMascotas();
                    mostrarPerfilRV();
                }

                @Override
                public void onFailure(Call<PerfilResponse> call, Throwable t) {
                    Toast.makeText(context, "Perfil:" + t.toString() , Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            mascotas =  new ArrayList<>();
            mostrarPerfilRV();
        }
    }

    @Override
    public void obtenerFotoPerfilInstagram() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson = restApiAdapter.construyendoDeserealizadorBusqueda();
        EndPointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gson);

        Call<BusquedaResponse> busquedaResponseCall = endpointsApi.getUsuarioBusqueda(cuentaInstagram, ConstantesRestApi.ACCES_TOKEN);
        busquedaResponseCall.enqueue(new Callback<BusquedaResponse>() {
            @Override
            public void onResponse(Call<BusquedaResponse> call, Response<BusquedaResponse> response) {
                BusquedaResponse busquedaResponse =  response.body();
                usuario = busquedaResponse.getCuenta();
                if(!usuario.getUsuario().equals("NoEncontrado"))
                    obtenerPerfilInsagram();
                else{
                    usuario.setUsuario("No encontrado");
                    obtenerPerfilInsagram();
                }
            }

            @Override
            public void onFailure(Call<BusquedaResponse> call, Throwable t) {
                Toast.makeText(context, " Error Perfil: " + t.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
