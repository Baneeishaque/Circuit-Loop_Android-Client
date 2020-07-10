package ndk.banee.circuitloop;

import android.content.Context;

import ndk.utils_android1.ExceptionUtils;

public class CircuitLoopExceptionUtils {

    public static void handleExceptionOnGui(Context applicationContext, Exception exception) {

        ExceptionUtils.handleExceptionOnGui(applicationContext, ApplicationSpecification.applicationName, exception);
    }
}
