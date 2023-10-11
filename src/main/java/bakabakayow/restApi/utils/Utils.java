package bakabakayow.restApi.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {
    public static void setLogging(String url, String type, String bodyOrParamsOrResponse, String message) {
        if (bodyOrParamsOrResponse == null) {
            log.info(type + " ======> url: " + url);
        }else {
        log.info(type + " =====> url '" + url + "' " + bodyOrParamsOrResponse + " : " + message);
        }
    }
}
