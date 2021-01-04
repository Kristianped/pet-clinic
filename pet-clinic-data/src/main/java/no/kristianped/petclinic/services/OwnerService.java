package no.kristianped.petclinic.services;

import no.kristianped.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
