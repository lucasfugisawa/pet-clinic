package br.com.fugisawa.petclinic.services;

import br.com.fugisawa.petclinic.model.Owner;
import br.com.fugisawa.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();
}
