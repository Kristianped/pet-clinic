package no.kristianped.petclinic.repositories;

import no.kristianped.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
