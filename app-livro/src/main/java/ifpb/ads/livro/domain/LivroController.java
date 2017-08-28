package ifpb.ads.livro.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
@Component
@RequestMapping(value = "/livro", produces = {"application/json; charset=UTF-8"})
public class LivroController {

    @Autowired
    private LivroRepository livros;

    public static final String REST_SERVICE_URI = "http://app-autor:8080/autor";

    @RequestMapping(method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    public Livro[] todosOsLivros() {
        return livros.findAll().toArray(new Livro[0]);
    }

    @RequestMapping(method = RequestMethod.GET, value = "autores", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity getLivros() {

        RestTemplate restTemplate = new RestTemplate();
        String autor = restTemplate.getForObject(REST_SERVICE_URI, String.class);
        System.out.println(autor);
        if (autor != null) {
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity get(@PathVariable long id) {
        Livro livro = livros.findOne(id);
        if (livro != null) {
            return new ResponseEntity<>(livro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody Livro livro) {
        if (livros.save(livro) != null) {
            return new ResponseEntity<>(livro, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}/autores", produces = {"application/json; charset=UTF-8"})
    public AutorId[] getByLastName(@PathVariable long id) {
        return livros.getAutoresDoLivro(id).toArray(new AutorId[0]);
    }

    @RequestMapping(method = RequestMethod.POST, value = "{id}/autores")
    public ResponseEntity addAutores(@PathVariable long id, @RequestBody String autor) {
        Livro livro = livros.findOne(id);
        if (livro != null) {
            livro.adicionarAutor(AutorId.of(autor));
            Livro save = livros.save(livro);
            return new ResponseEntity<>(save, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
