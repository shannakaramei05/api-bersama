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

    public static <T> Response <T> setErrorResponse(String code, String message) {
        Response <T> response = new Response<T>();
        response.setMessage(message);
        response.setStatusCode(code);
        response.setResults(null);
        return response;
    }

    public static <T> Response<T> setResponseEmailNotFound() {
        return setErrorResponse("404", "Email Not Found");
    }

    public static <T> Response <T> setResponseExpired(Exception e) {
        return setErrorResponse("0000", Utils.getCauseMessage(e));
    }

    public static <T> Response <T> setResponseException(Exception e) {
        return setErrorResponse("0000EX" , e.getMessage());
    }

    public static <T> Response<T> setResponseEmailAreadyUsed() {
        return setErrorResponse("204" , "Email Already Used");
    }
}
