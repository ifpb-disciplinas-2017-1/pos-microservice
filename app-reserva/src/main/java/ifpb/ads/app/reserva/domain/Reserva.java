/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.app.reserva.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import ifpb.ads.app.reserva.exceptions.ReservaFinalizadaException;

/**
 *
 * @author kieckegard
 */

@Entity
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Embedded
    private Livro livro;
    private String cliente;
    
    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;
    
    private LocalDateTime dataCriado;
    private LocalDateTime dataEncerramento;
    private LocalDateTime dataEntrega;

    public Reserva(Livro livro, String cliente) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataCriado = LocalDateTime.now();
        this.estado = EstadoReserva.CRIADO;
    }
    
    public Reserva() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(LocalDateTime dataCriado) {
        this.dataCriado = dataCriado;
    }

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDateTime dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }
    
    public void diasEntrega(Integer dias) {
        this.dataEncerramento = this.dataCriado.plusDays(dias);
    }
    
    public void finalizar() {
        if(this.estado.equals(EstadoReserva.FINALIZADO))
            throw new ReservaFinalizadaException("O empréstimo " + this.id + " já foi finalizado!");
        this.estado = EstadoReserva.FINALIZADO;
    }
    
    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", livro=" + livro + ", cliente=" + cliente + ", dataCriado=" + dataCriado + ", dataEncerramento=" + dataEncerramento + ", dataEntrega=" + dataEntrega + '}';
    }
}
