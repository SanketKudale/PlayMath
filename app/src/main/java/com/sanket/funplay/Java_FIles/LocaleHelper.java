package com.sanket.funplay.Java_FIles;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;

import com.sanket.funplay.R;

import java.util.Locale;

public class LocaleHelper {

    public static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";
    Context context;


    public LocaleHelper(Context context) {
        this.context = context;
    }

    public void functionchange(String lang)
    {
        String list[] = context.getResources().getStringArray(R.array.languages);

        SharedPreferences sharedPreferences1 = PreferenceManager.getDefaultSharedPreferences(context);
        if (lang.equals(list[0]))
        {
            setAppLocale("en");
            SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor1 = preferences1.edit();
            editor1.putString("app_langy", "english");
            editor1.apply();
        }
        else if (lang.equals(list[1]))
        {
            setAppLocale("mr");
            SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor1 = preferences1.edit();
            editor1.putString("app_langy", "marathi");
            editor1.apply();
        }
        else if (lang.equals(list[2]))
        {
            setAppLocale("hi");
            SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor1 = preferences1.edit();
            editor1.putString("app_langy", "hindi");
            editor1.apply();
        }
    }

    public void setAppLocale(String lang) {
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration config = res.getConfiguration();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            config.setLocale(new Locale(lang.toLowerCase()));
        else
            config.locale = new Locale(lang.toLowerCase());
        res.updateConfiguration(config, dm);
    }
}
