package sk.radicalservice.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {

    private String code;
    private String target;
    private String message;
    private List<Error> details;

    public Error() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Error> getDetails() {
        return details;
    }

    public void setDetails(List<Error> details) {
        this.details = details;
    }
}
