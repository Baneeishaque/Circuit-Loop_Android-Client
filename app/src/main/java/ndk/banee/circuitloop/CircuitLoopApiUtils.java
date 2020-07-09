package ndk.banee.circuitloop;

import ndk.utils_android16.ApiUtils;

public class CircuitLoopApiUtils {

    public static String getHttApi(String methodName){

        return ApiUtils.getHttpApi(methodName, CircuitLoopApiConstants.apiServerAddress, CircuitLoopApiConstants.httpApiFolder, CircuitLoopApiConstants.fileExtension);
    }
}
