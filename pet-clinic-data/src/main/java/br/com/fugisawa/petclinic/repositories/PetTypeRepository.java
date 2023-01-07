package br.com.fugisawa.petclinic.repositories;

import br.com.fugisawa.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
