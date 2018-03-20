package yuri.kl.com.ua.reminder;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Yuri on 20.03.2018.
 */

public class PreferenceHelper {
    //CONSTANTA
    public static final String SPLASH_IS_INVISIBLE = "splash_is_invisible";

    //fields
    private static PreferenceHelper instance;

    private Context context;

    private SharedPreferences preferences;

    //create methods
    private PreferenceHelper() {

    }

    public static PreferenceHelper getInstance() {
        if (instance == null) {
            instance = new PreferenceHelper();
        }

        return instance;
    }

    //получаем context и с помощью его получаем SharedPreferences методом getSharedPreferences
    public void init(Context context) {
        this.context = context;

        preferences = context.getSharedPreferences("preferences", Context.MODE_PRIVATE);
    }

    //
    public void putBoolean (String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();

        editor.putBoolean(key, value);
        editor.apply();
    }

    //
    public boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }
}
