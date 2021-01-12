package no.kristianped.petclinic.services;

import no.kristianped.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameContainingIgnoreCase(String lastName);
}
