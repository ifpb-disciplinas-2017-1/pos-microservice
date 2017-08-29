/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.app.reserva.exceptions;

import java.io.Serializable;

/**
 *
 * @author kieckegard
 */
public class ResponseMessage implements Serializable {
    
    private int statusCode;
    private String message;

    public ResponseMessage(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
    
    public ResponseMessage() {
        
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

    @Override
    public String toString() {
        return "ResponseMessage{" + "statusCode=" + statusCode + ", message=" + message + '}';
    }
}
