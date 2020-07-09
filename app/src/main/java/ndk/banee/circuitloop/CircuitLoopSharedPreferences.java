package ndk.banee.circuitloop;

import android.content.Context;
import android.content.SharedPreferences;

import ndk.utils_android1.SharedPreferencesUtils1;

public class CircuitLoopSharedPreferences {

    public static SharedPreferences getSharedPreferences(Context applicationContext){

        return SharedPreferencesUtils1.getSharedPreferences(applicationContext, ApplicationSpecification.APPLICATION_NAME);
    }
}
