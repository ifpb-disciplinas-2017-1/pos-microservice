/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.app.reserva.resource;

import java.io.Serializable;

/**
 *
 * @author kieckegard
 */
public class ReservaDTO implements Serializable {
    
    private Integer livroId;
    private String cliente;
    private Integer diasEntrega;

    public ReservaDTO(Integer livroId, String client, Integer diasEntrega) {
        this.livroId = livroId;
        this.cliente = client;
        this.diasEntrega = diasEntrega;
    }

    public ReservaDTO() {
    }

    public Integer getLivroId() {
        return livroId;
    }

    public void setLivroId(Integer livroId) {
        this.livroId = livroId;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getDiasEntrega() {
        return diasEntrega;
    }

    public void setDiasEntrega(Integer diasEntrega) {
        this.diasEntrega = diasEntrega;
    }

    @Override
    public String toString() {
        return "ReservaDTO{" + "livroId=" + livroId + ", cliente=" + cliente + ", diasEntrega=" + diasEntrega + '}';
    }
}
