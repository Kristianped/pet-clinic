package no.kristianped.petclinic.services;

import no.kristianped.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findByd(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
