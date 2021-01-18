package com.ds.thapovan.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GenericResponse {

    @Expose
    @SerializedName("success")
    private String success;

    @Expose
    @SerializedName("error")
    private ErrorMessage error;

    @Expose
    @SerializedName("statusCode")
    private String statusCode;

    @Expose
    @SerializedName("showErrPopup")
    private String showErrPopup;

    @Expose
    @SerializedName("responseCode")
    private int responseCode=-1;

    @Expose
    @SerializedName("message")
    private String message;

    public Boolean isUserLoggedOut() {
        return isUserLoggedOut;
    }

    public void setIsUserLoggedOut(Boolean userLoggedOut) {
        isUserLoggedOut = userLoggedOut;
    }

    private Boolean isUserLoggedOut=false;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getShowErrPopup() {
        return showErrPopup;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public void setShowErrPopup(String showErrPopup) {
        this.showErrPopup = showErrPopup;
    }

    public boolean isSuccess() {
        return "1".equals(success) || "true".equals(success);
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String msg){
        message = msg;
    }

    public ErrorMessage getError() {
        return error;
    }

    public void setError(ErrorMessage error) {
        this.error = error;
    }


    public static class ErrorMessage{

        @SerializedName("message")
        private String message;

        public String getMessage(){
            return message;
        }

        public void setMessage(String msg){
            message = msg;
        }
    }

}
