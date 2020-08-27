package ndk.banee.circuitloop;

import android.content.Context;

import ndk.utils_android1.ExceptionUtils1;

public class CircuitLoopExceptionUtils {

    public static void handleExceptionOnGui(Context applicationContext, Exception exception) {

        ExceptionUtils1.handleExceptionOnGui(applicationContext, ApplicationSpecification.applicationName, exception);
    }
}
