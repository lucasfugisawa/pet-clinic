package br.com.fugisawa.petclinic.services;

import br.com.fugisawa.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
