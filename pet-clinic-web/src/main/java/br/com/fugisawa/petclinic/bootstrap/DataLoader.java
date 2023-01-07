package br.com.fugisawa.petclinic.bootstrap;

import br.com.fugisawa.petclinic.model.*;
import br.com.fugisawa.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (petTypeService.findAll().size() == 0 ) {
            System.out.println("(DataLoader.run) Preparing to load bootstrap data...");
            loadBoostrapData();
        } else {
            System.out.println("(DataLoader.run) Bootstrap data already loaded. Skipping.");
        }

    }

    private void loadBoostrapData() {

        System.out.println("(DataLoader.loadBoostrapData) Loading bootstrap data...");

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

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

        Visit bloomVisit = new Visit();
        bloomVisit.setPet(talisPet);
        bloomVisit.setDate(LocalDate.now());
        bloomVisit.setDescription("Vacinação anual.");
        visitService.save(bloomVisit);


        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedRadiology = specialityService.save(radiology);
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality savedDentistry = specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Leandro");
        vet1.setLastName("Crivellentti");
        vet1.getSpecialities().add(radiology);
        vet1.getSpecialities().add(surgery);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sofia");
        vet2.setLastName("Borin");
        vet2.getSpecialities().add(surgery);
        vet2.getSpecialities().add(dentistry);
        vetService.save(vet2);

        System.out.println("(DataLoader.loadBoostrapData) Bootstrap data loaded.");
    }
}

