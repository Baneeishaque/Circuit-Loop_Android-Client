package ndk.banee.circuitloop;

import ndk.utils_android1.LogUtils;

public class CircuitLoopLogUtils {

    public static void debug(String message){

        LogUtils.debug(ApplicationSpecification.applicationName, message);
    }
}
