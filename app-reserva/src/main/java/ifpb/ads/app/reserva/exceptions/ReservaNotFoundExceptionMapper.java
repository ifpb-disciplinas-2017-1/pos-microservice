/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.app.reserva.exceptions;

import ifpb.ads.app.reserva.service.ReservaNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author kieckegard
 */

@Provider
public class ReservaNotFoundExceptionMapper 
        implements ExceptionMapper<ReservaNotFoundException> {

    @Override
    public Response toResponse(ReservaNotFoundException exception) {
        
        Status status = Status.NOT_FOUND;
        ResponseMessage msg = new ResponseMessage(status.getStatusCode()
                , exception.getMessage());
        
        return Response.status(status)
                .entity(msg)
                .build();
    }
    
}
