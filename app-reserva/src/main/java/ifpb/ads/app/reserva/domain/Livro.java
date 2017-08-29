/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.app.reserva.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author kieckegard
 */

@Embeddable
public class Livro implements Serializable {
    
    @Column(name = "livro_id", nullable = false)
    private Integer livroId;
    
    public Livro(Integer id) {
        this.livroId = id;
    }
    
    public Livro() {
        
    }
    
    public static Livro of(Integer id) {
        return new Livro(id);
    }
    
    public Integer getId() {
        return this.livroId;
    }
    
    public void setId(Integer id) {
        this.livroId = id;
    }

    @Override
    public String toString() {
        return "LivroId{" + "id=" + livroId + '}';
    }
}
