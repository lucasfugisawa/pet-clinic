package br.com.fugisawa.petclinic.repositories;

import br.com.fugisawa.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
