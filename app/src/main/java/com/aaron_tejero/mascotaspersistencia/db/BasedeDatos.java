package com.aaron_tejero.mascotaspersistencia.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aaron_tejero.mascotaspersistencia.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by AaronTejero on 30/05/2016.
 */
public class BasedeDatos extends SQLiteOpenHelper {
    private Context context;
    public BasedeDatos(Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas="CREATE TABLE "+ ConstantesBD.TABLE_MASCOTAS+
                " ("+ConstantesBD.TABLE_MASCOTAS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBD.TABLE_MASCOTAS_NAME+" TEXT, "+
                ConstantesBD.TABLE_MASCOTAS_RATING+" TEXT, "+
                ConstantesBD.TABLE_MASCOTAS_FOTO+" INTEGER"+")";
        String queryCrearTablaLikes= "CREATE TABLE " + ConstantesBD.TABLE_LIKE + "(" +
                ConstantesBD.TABLE_LIKE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_LIKE_ID_MASCOTA+ " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBD.TABLE_LIKE_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBD.TABLE_MASCOTAS + "(" + ConstantesBD.TABLE_MASCOTAS_ID + ")" +
                ")";
        db.execSQL(queryCrearTablaMascotas);

        db.execSQL(queryCrearTablaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBD.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBD.TABLE_LIKE);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas =new ArrayList<>();
        String query="SELECT * FROM "+ConstantesBD.TABLE_MASCOTAS;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros=db.rawQuery(query,null);
        while(registros.moveToNext()){
         /*   Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setRaiting(registros.getInt(2));
            mascotaActual.setFoto(registros.getInt(3));
            mascotas.add(mascotaActual);*/
        }
        db.close();
        return mascotas;
    }

    public void agregarMascota(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_MASCOTAS,null,contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_LIKE,null,contentValues);
        db.close();
    }


    public void actualizarRaiting(int id){
        int like=0;
        String queryraiting="SELECT * FROM "+ConstantesBD.TABLE_MASCOTAS+ " Where "+ConstantesBD.TABLE_MASCOTAS_ID+"="+id;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registrosraiting=db.rawQuery(queryraiting, null);
        if (registrosraiting.moveToNext()){
           like=registrosraiting.getInt(2)+1;
        }
        ContentValues cv=new ContentValues();
        cv.put(ConstantesBD.TABLE_MASCOTAS_RATING,like);
        db.update(ConstantesBD.TABLE_MASCOTAS, cv, "id=" + id, null);
        db.close();
    }

    public ArrayList<Mascota> obtener5Favoritos() {
        int[] ids=new int[5];
        ArrayList<Mascota> mascotasfavs= new ArrayList<>();
        String query="SELECT * FROM "+ConstantesBD.TABLE_LIKE;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor registros=db.rawQuery(query,null);
        if (registros.moveToNext()){
            registros.moveToLast();
            ids[0]=registros.getInt(1);
        }

        int i=1;
        while(registros.moveToPrevious()&&i<5){
           int idaux=registros.getInt(1);
            ids[i]=idaux;
            i++;
        }

        for (int a=0;a<5;a++) {
          /*  String query2="SELECT * FROM "+ConstantesBD.TABLE_MASCOTAS+ " WHERE "+ConstantesBD.TABLE_MASCOTAS_ID+"="+Integer.toString(ids[a]);
            // db=this.getWritableDatabase();
            Cursor registros2=db.rawQuery(query2,null);

            Mascota mascotaActual=new Mascota();
            if (registros2.moveToNext()) {
                mascotaActual.setId(registros2.getInt(0));
                mascotaActual.setNombre(registros2.getString(1));
                mascotaActual.setRaiting(registros2.getInt(2));

                mascotaActual.setFoto(registros2.getInt(3));
                mascotasfavs.add(mascotaActual);
            }*/
        }
        db.close();

        return mascotasfavs;
    }
}
