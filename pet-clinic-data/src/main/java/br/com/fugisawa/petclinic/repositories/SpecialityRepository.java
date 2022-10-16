package br.com.fugisawa.petclinic.repositories;

import br.com.fugisawa.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
