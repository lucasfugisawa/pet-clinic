package br.com.fugisawa.petclinic.bootstrap;

import br.com.fugisawa.petclinic.model.Owner;
import br.com.fugisawa.petclinic.model.Pet;
import br.com.fugisawa.petclinic.model.PetType;
import br.com.fugisawa.petclinic.model.Vet;
import br.com.fugisawa.petclinic.services.OwnerService;
import br.com.fugisawa.petclinic.services.PetTypeService;
import br.com.fugisawa.petclinic.services.VetService;
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

        System.out.println("Loading PetTypes...");

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Loading Owners...");

        Owner ownerLucas = new Owner();
        ownerLucas.setFirstName("Lucas");
        ownerLucas.setLastName("Fugisawa");
        ownerLucas.setAddress("R. Street Name, 12345.");
        ownerLucas.setCity("Batatais");
        ownerLucas.setTelephone("+55 55 55555-5555");

        Pet lucasPet = new Pet();
        lucasPet.setName("Bartô");
        lucasPet.setPetType(savedDogType);
        lucasPet.setOwner(ownerLucas);
        lucasPet.setBirthDate(LocalDate.now());
        ownerLucas.getPets().add(lucasPet);

        ownerService.save(ownerLucas);

        Owner ownerTalis = new Owner();
        ownerTalis.setFirstName("Talisson");
        ownerTalis.setLastName("Vitorino");
        ownerTalis.setAddress("R. Street Name, 12346.");
        ownerTalis.setCity("Batatais");
        ownerTalis.setTelephone("+55 55 66666-6666");

        Pet talisPet = new Pet();
        talisPet.setName("Bloom");
        talisPet.setPetType(savedCatType);
        talisPet.setOwner(ownerTalis);
        talisPet.setBirthDate(LocalDate.now());
        ownerTalis.getPets().add(talisPet);

        ownerService.save(ownerTalis);

        System.out.println("Loading Vets...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Leandro");
        vet1.setLastName("Crivellentti");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sofia");
        vet2.setLastName("Borin");
        vetService.save(vet2);

    }
}
