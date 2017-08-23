package ifpb.ads.livro.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 18/07/2017, 14:51:34
 */
@Entity
public class Livro implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String edicao;
    private String titulo;
    private String descricao;
    @ElementCollection(fetch = FetchType.EAGER)
//    @Basic(fetch = FetchType.EAGER)
    private List<AutorId> autores = new ArrayList<>();

    public Livro() {
    }

    public Livro(String edicao, String titulo, String descricao) {
        this.edicao = edicao;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<AutorId> getAutores() {
        return autores;
    }

    public void adicionarAutor(AutorId autor) {
        this.autores.add(autor);
    }

    public void removerAutor(AutorId autor) {
        this.autores.remove(autor);
    }

    public void setAutores(List<AutorId> autores) {
        this.autores = autores;
    }

}
