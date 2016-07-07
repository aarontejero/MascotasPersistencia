package com.aaron_tejero.mascotaspersistencia.restApi;

/**
 * Created by AaronTejero on 04/07/2016.
 */
public final class ConstantesRestApi {

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCES_TOKEN = "3440249498.ddd48db.e0d6b826b21d4fb5915d8c44e00238b4";
    public static final String KEY_ACCES_TOKEN = "?access_token=";

    public static final String KEY_GET_FOLLOWEDBY = "users/self/follows";
    public static final String URL_GET_FOLLOWEDBY = KEY_GET_FOLLOWEDBY + KEY_ACCES_TOKEN + ACCES_TOKEN;

    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCES_TOKEN + ACCES_TOKEN;

    public static final String KEY_SEARCH_USER = "users/search";
    public static final String URL_SEARCH_USER = KEY_SEARCH_USER;

    public static final String KEY_GET_RECENT_MEDIA_OTHER = "users/{id}/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_OTHER = KEY_GET_RECENT_MEDIA_OTHER + KEY_ACCES_TOKEN + ACCES_TOKEN;


}
