package ma.nacer.custumermicroservice;

import ma.nacer.custumermicroservice.entities.Costumer;
import ma.nacer.custumermicroservice.repositories.CostumerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustumerMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustumerMicroServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CostumerRepository cr, @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") RepositoryRestConfiguration rc){
        return args->{
            rc.exposeIdsFor(Costumer.class);
            cr.saveAll(
                    List.of(
                            Costumer.builder().name("nacer").email("nacer.lachhab@gmail.com").build(),
                            Costumer.builder().name("nacer2").email("nacer2.lachhab@gmail.com").build()
                    )
            );

            cr.findAll().forEach(t->System.out.println(t));
        };
    }
}
