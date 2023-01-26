package ma.nacer.custumermicroservice.repositories;

import ma.nacer.custumermicroservice.entities.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource //mettre en place restful webService
public interface CostumerRepository extends JpaRepository<Costumer,Long> {
}
