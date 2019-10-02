package sk.radicalservice.common;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

public class APIResponse {

    private Integer status;
    private Error error;
    private Object data;

    public APIResponse(){
        this.status = HttpStatus.OK.value();
        this.error = new Error();
    }

    public APIResponse(Integer status, Error error, Object data) {
        this.status = status;
        this.error = error;
        this.data = new HashMap<String, Object>();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
