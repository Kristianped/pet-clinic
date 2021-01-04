package no.kristianped.petclinic.services;

import no.kristianped.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByd(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
