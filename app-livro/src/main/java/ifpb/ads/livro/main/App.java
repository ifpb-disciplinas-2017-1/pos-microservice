package ifpb.ads.livro.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import java.util.Optional;
import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

//@SpringBootApplication
@ComponentScan(basePackages = "ifpb.ads.livro.domain")
@EntityScan(basePackages = "ifpb.ads.livro.domain")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "ifpb.ads.livro.domain")

public class App {

    public static final Optional<String> host;
    public static final Optional<String> port;
    public static final Properties myProps = new Properties();

    static {
        host = Optional.ofNullable(System.getenv("HOSTNAME"));
        port = Optional.ofNullable(System.getenv("PORT"));
    }

    public static void main(String[] args) {

        myProps.setProperty("server.address", host.orElse("localhost"));
        myProps.setProperty("server.port", port.orElse("8080"));

        SpringApplication app = new SpringApplication(App.class);
        app.setDefaultProperties(myProps);
        app.run(args);

    }

    @Bean
    public ObjectMapper a() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Hibernate5Module());
        return mapper;
    }

//    @Bean
//    public CommandLineRunner demo(LivroRepository repository) {
//        return (args) -> {
//            repository.save(new Livro("12", "ttt", "dddss"));
//        };
//    }
}
