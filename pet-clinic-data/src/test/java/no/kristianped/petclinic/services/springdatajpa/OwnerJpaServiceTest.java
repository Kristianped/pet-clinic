package no.kristianped.petclinic.services.springdatajpa;

import no.kristianped.petclinic.model.Owner;
import no.kristianped.petclinic.repositories.OwnerRepository;
import no.kristianped.petclinic.repositories.PetRepository;
import no.kristianped.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJpaService service;

    final Long ownerId = 1L;
    final String lastName = "Smith";
    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(ownerId).lastName(lastName).build();
    }

    @Test
    void findAll() {
        Set<Owner> returnSet = new HashSet<>();
        returnSet.add(Owner.builder().id(1L).build());
        returnSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(ownerId);

        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(ownerId).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        assertEquals(0, service.findAll().size());
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(ownerId);

        assertEquals(0, service.findAll().size());
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findOwnerByLastName(any())).thenReturn(returnOwner);

        Owner smith = service.findByLastName(lastName);

        assertEquals(lastName, smith.getLastName());
        verify(ownerRepository).findOwnerByLastName(any());
    }
}