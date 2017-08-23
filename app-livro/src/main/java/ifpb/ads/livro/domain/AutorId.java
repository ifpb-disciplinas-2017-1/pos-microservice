package ifpb.ads.livro.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class AutorId implements Serializable {

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void serValue(Integer value) {
        this.value = value;
    }

    public AutorId() {
        this.value = null;
    }

    public AutorId(Integer value) {
        this.value = value;
    }

    public static AutorId of(Integer value) {
        return new AutorId(value);
    }

    public static AutorId of(String autor) {
        Integer valor = Integer.parseInt(autor);
        return new AutorId(valor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AutorId) {
            AutorId other = (AutorId) obj;
            return Objects.equals(this.value, other.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public String toString() {
        return String.format("Id do autor:%d", value);
    }

    public Integer toInteger() {
        return value;
    }

}
