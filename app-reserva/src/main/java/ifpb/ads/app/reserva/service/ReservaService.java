/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.app.reserva.service;

import ifpb.ads.app.reserva.domain.Reserva;
import java.util.List;

/**
 *
 * @author kieckegard
 */
public interface ReservaService {
    
    Reserva findById(Long reservaId);
    Reserva add(Integer livroId, String cliente, int diasEncerramento);
    void finalizar(Long reservaId);
    List<Reserva> listAll();
}
