package xin.gojay.nmid.util;

import xin.gojay.nmid.entity.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gojay
 * @date 2017/11/6.
 */
public class ResponseUtil {
    private int statusCode;
    private String message;
    private Object body = null;

    public ResponseUtil(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseUtil{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", body=" + body +
                '}';
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
