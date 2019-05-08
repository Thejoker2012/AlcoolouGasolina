package br.com.unisys.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SecurityPreferences {

    public static final String NULO = "Nulo";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public SecurityPreferences(Context context) {
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.editor = preferences.edit();
    }

    public void guardaString(String chave, String valor) {
        editor.putString(chave, valor).commit();
    }

    public String recuperaString(String chave) {
        return preferences.getString(chave, NULO);
    }

    public void guardaFloat(String chave, Float valor) {
        editor.putFloat(chave , valor);
    }

    public Double recuperaFloat(String chave){
        return new Double(preferences.getFloat(chave,0));
    }

    public void guardaBoleano(String chave, boolean valor) {
        editor.putBoolean(chave, valor).commit();
    }

    public boolean recuperaBoleano(String chave) {
        return preferences.getBoolean(chave, Boolean.FALSE);
    }
}
