/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.app.reserva.service;

import ifpb.ads.app.reserva.domain.Livro;
import ifpb.ads.app.reserva.domain.Reserva;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author kieckegard
 */

@RequestScoped
@Transactional
public class ReservaServiceImpl implements ReservaService {
    
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Reserva add(Integer livroId, String cliente, int diasEncerramento) {
        
        Reserva reserva = new Reserva(
           new Livro(livroId),
           cliente
        );
        
        reserva.diasEntrega(diasEncerramento);
        
        this.manager.persist(reserva);
        
        return reserva;
    }

    @Override
    public void finalizar(Long reservaId) {
        Reserva found = this.manager.find(Reserva.class, reservaId);
        if(found == null)
            throw new ReservaNotFoundException("There's no reserva with " + reservaId + " id!");
        found.finalizar();
        this.manager.merge(found);
    }

    @Override
    public Reserva findById(Long reservaId) {
        Reserva found = this.manager.find(Reserva.class, reservaId);
        if(found == null)
            throw new ReservaNotFoundException("There's no reserva with " + reservaId + " id!");
        return found;
    }

    @Override
    public List<Reserva> listAll() {
        TypedQuery<Reserva> query = this.manager
            .createQuery("SELECT r FROM Reserva r", Reserva.class);
        return query.getResultList();
    }
    
}
