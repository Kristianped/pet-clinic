package no.kristianped.petclinic.services.springdatajpa;

import no.kristianped.petclinic.model.Owner;
import no.kristianped.petclinic.repositories.OwnerRepository;
import no.kristianped.petclinic.repositories.PetRepository;
import no.kristianped.petclinic.repositories.PetTypeRepository;
import no.kristianped.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> set = new HashSet<>();
        ownerRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findOwnerByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameContainingIgnoreCase(String lastName) {
        return ownerRepository.findAllByLastNameContainingIgnoreCase (lastName);
    }
}
