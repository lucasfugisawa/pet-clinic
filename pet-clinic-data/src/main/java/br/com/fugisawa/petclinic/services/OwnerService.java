package br.com.fugisawa.petclinic.services;

import br.com.fugisawa.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
