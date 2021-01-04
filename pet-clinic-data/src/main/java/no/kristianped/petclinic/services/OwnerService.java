package no.kristianped.petclinic.services;

import no.kristianped.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findByd(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
