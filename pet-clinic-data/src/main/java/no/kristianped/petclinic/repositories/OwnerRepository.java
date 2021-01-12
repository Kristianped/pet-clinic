package no.kristianped.petclinic.repositories;

import no.kristianped.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findOwnerByLastName(String lastName);

    List<Owner> findAllByLastNameContainingIgnoreCase (String lastName);
}
