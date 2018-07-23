package com.example.user.bangundesaku.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by user on 22/07/2018.
 */

public class SessionLogin {
    private SharedPreferences sharedPreferences;
    private Context context;
    private SharedPreferences.Editor editor;
    public static String KEY_LOGIN = "LOGIN";
    public static String KEY_JENISUSER = "JENIS_USER";
    public static String KEY_NAMAUSER = "NAMA_USER";
    public static String KEY_EMAILSUSER = "EMAIL_USER";
    public static String KEY_KELAMINSUSER = "KELAMIN_USER";

    public SessionLogin(Context context) {
        this.sharedPreferences = context.getSharedPreferences(KEY_LOGIN,Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public void noteIntro(String user, String nama, String email,String kelamin){
        editor.putString(KEY_JENISUSER,user);
        editor.putString(KEY_EMAILSUSER,email);
        editor.putString(KEY_NAMAUSER,nama);
        editor.putString(KEY_KELAMINSUSER,kelamin);
        Log.e("akunjenis",user);
        editor.commit();
    }

    public void deleteSession(){
        editor.clear();
        editor.commit();
    }

    public String getDataString(String key){
        return sharedPreferences.getString(key,"");
    }

}
