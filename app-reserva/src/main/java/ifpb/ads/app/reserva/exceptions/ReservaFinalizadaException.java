/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.app.reserva.exceptions;

import javax.ejb.EJBException;

/**
 *
 * @author kieckegard
 */
public class ReservaFinalizadaException extends EJBException {

    public ReservaFinalizadaException(String message) {
        super(message);
    }

    public ReservaFinalizadaException(Exception ex) {
        super(ex);
    }

    public ReservaFinalizadaException(String message, Exception ex) {
        super(message, ex);
    }
}
