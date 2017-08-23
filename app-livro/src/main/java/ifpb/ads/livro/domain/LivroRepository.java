package ifpb.ads.livro.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query("SELECT new ifpb.ads.livro.domain.AutorId (a.value) FROM Livro l, IN (l.autores) a WHERE l.id = :id")
    public List<AutorId> getAutoresDoLivro(@Param("id") long id);
}
