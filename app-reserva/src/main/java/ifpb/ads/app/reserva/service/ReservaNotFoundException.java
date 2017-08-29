/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.app.reserva.service;

import javax.ejb.EJBException;

/**
 *
 * @author kieckegard
 */
public class ReservaNotFoundException extends EJBException {

    public ReservaNotFoundException(String message) {
        super(message);
    }

    public ReservaNotFoundException(Exception ex) {
        super(ex);
    }

    public ReservaNotFoundException(String message, Exception ex) {
        super(message, ex);
    }
}
