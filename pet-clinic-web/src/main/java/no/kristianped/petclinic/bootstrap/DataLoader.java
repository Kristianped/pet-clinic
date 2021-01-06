package no.kristianped.petclinic.bootstrap;

import no.kristianped.petclinic.model.Owner;
import no.kristianped.petclinic.model.Pet;
import no.kristianped.petclinic.model.PetType;
import no.kristianped.petclinic.model.Vet;
import no.kristianped.petclinic.services.OwnerService;
import no.kristianped.petclinic.services.PetTypeService;
import no.kristianped.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("12311234443");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setName("Rosco");
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setOwner(owner1);
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("12311234443");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(cat);
        fionasCat.setName("Just cat");
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setOwner(owner2);
        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);

        System.out.println("Loaded some owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

        System.out.println("Loaded some vets");

    }
}
