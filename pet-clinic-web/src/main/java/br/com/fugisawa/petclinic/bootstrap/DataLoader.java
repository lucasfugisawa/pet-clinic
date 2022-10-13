package br.com.fugisawa.petclinic.bootstrap;

import br.com.fugisawa.petclinic.model.Owner;
import br.com.fugisawa.petclinic.model.Vet;
import br.com.fugisawa.petclinic.services.OwnerService;
import br.com.fugisawa.petclinic.services.VetService;
import br.com.fugisawa.petclinic.services.map.OwnerServiceMap;
import br.com.fugisawa.petclinic.services.map.VetServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Owners...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Lucas");
        owner1.setLastName("Fugisawa");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Talisson");
        owner2.setLastName("Vitorino");
        ownerService.save(owner2);

        System.out.println("ownerService.findAll() = " + ownerService.findAll());

        System.out.println("Loading Vets...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Leandro");
        vet1.setLastName("Crivellentti");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sofia");
        vet2.setLastName("Borin");
        vetService.save(vet2);

        System.out.println("vetService.findAll() = " + vetService.findAll());

    }
}
