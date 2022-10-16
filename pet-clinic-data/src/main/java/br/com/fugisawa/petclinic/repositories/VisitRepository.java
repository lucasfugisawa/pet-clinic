package br.com.fugisawa.petclinic.repositories;

import br.com.fugisawa.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
