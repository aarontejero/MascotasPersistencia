package com.aaron_tejero.mascotaspersistencia.db;

import android.content.ContentValues;
import android.content.Context;

import com.aaron_tejero.mascotaspersistencia.R;
import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by AaronTejero on 30/05/2016.
 */
public class ConstructorMascotas {

    private Context context;
    public ConstructorMascotas(Context context) {
        this.context=context;
    }

    public ArrayList<Mascota> obtenerDatos(){
       /* ArrayList<Mascota> mascotas=new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perro1,"Aquiles",10));
        mascotas.add(new Mascota(R.drawable.perro2,"Hercules",6));
        mascotas.add(new Mascota(R.drawable.perro3, "Atena", 8));
        mascotas.add(new Mascota(R.drawable.perro4, "Alana", 3));
        mascotas.add(new Mascota(R.drawable.perro5, "Kiara", 5));
        mascotas.add(new Mascota(R.drawable.perro6, "Zeus", 7));
        mascotas.add(new Mascota(R.drawable.perro7,"Sanson",9));
        mascotas.add(new Mascota(R.drawable.perro8, "Bruno", 1));*/
        BasedeDatos db = new BasedeDatos(context);
        insertaDatosDB(db);
        return  db.obtenerTodasLasMascotas();
        //CONTINUAR AQUI

    }

        public void insertaDatosDB(BasedeDatos bd){
            ContentValues contentValues= new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_NAME,"Aquiles");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_RATING,"10");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro1);
            bd.agregarMascota(contentValues);

            contentValues= new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_NAME,"Hercules");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_RATING,"6");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro2);
            bd.agregarMascota(contentValues);

            contentValues= new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_NAME,"Atena");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_RATING,"8");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro3);
            bd.agregarMascota(contentValues);

            contentValues= new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_NAME,"Alana");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_RATING,"3");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro4);
            bd.agregarMascota(contentValues);

            contentValues= new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_NAME,"Kiara");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_RATING,"5");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro5);
            bd.agregarMascota(contentValues);

            contentValues= new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_NAME,"Zeus");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_RATING,"7");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro6);
            bd.agregarMascota(contentValues);

            contentValues= new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_NAME,"Sanson");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_RATING,"8");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro7);
            bd.agregarMascota(contentValues);

            contentValues= new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_NAME,"Bruno");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_RATING,"1");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO,R.drawable.perro8);
            bd.agregarMascota(contentValues);
        }

    public void darLikeMascota(Mascota mascota){
        BasedeDatos db=new BasedeDatos(context);
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBD.TABLE_LIKE_ID_MASCOTA,mascota.getId());
        db.insertarLikeMascota(contentValues);
        db.actualizarRaiting(mascota.getId());

    }

    public ArrayList<Mascota> obtenerFavmascotas(){
         /*ArrayList<Mascota> mascotas=new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perro4, "Alana", 10));
        mascotas.add(new Mascota(R.drawable.perro7, "Sanson", 8));
        mascotas.add(new Mascota(R.drawable.perro1, "Aquiles", 7));
        mascotas.add(new Mascota(R.drawable.perro5, "Kiara", 4));
        mascotas.add(new Mascota(R.drawable.perro3, "Atena", 3));
        return mascotas;*/
        BasedeDatos db = new BasedeDatos(context);
        //insertar5favsiniciales(db);
        return  db.obtener5Favoritos();
    }


    public void insertar5favsiniciales(BasedeDatos db){
        ContentValues cv= new ContentValues();
        cv= new ContentValues();
        cv.put(ConstantesBD.TABLE_LIKE_ID_MASCOTA, "1");
        db.insertarLikeMascota(cv);

        cv= new ContentValues();
        cv.put(ConstantesBD.TABLE_LIKE_ID_MASCOTA, "2");
        db.insertarLikeMascota(cv);

        cv= new ContentValues();
        cv.put(ConstantesBD.TABLE_LIKE_ID_MASCOTA, "3");
        db.insertarLikeMascota(cv);

        cv= new ContentValues();
        cv.put(ConstantesBD.TABLE_LIKE_ID_MASCOTA,"4");
        db.insertarLikeMascota(cv);

        cv.put(ConstantesBD.TABLE_LIKE_ID_MASCOTA,"5");
        db.insertarLikeMascota(cv);

    }
}
