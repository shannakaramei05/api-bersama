package bakabakayow.restApi.utils;

import bakabakayow.restApi.dto.Response;

public class SetResponse <T>{
    public static <T> Response<T> setStatusMessageSuccess(T object) {
        Response<T> response = new Response<>();
        response.setMessage("success");
        response.setStatusCode("1000");
        response.setResults(object);
        return response;
    }
}
