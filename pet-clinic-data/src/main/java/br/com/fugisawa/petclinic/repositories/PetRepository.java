package br.com.fugisawa.petclinic.repositories;

import br.com.fugisawa.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
