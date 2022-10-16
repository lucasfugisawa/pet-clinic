package br.com.fugisawa.petclinic.services.sdjpa;

import br.com.fugisawa.petclinic.model.PetType;
import br.com.fugisawa.petclinic.repositories.PetTypeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("persist-sdjpa")
public class PetTypeService implements br.com.fugisawa.petclinic.services.PetTypeService {

    private PetTypeRepository petTypeRepository;

    public PetTypeService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        this.petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        return this.petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return this.petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        this.petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        this.petTypeRepository.deleteById(id);
    }
}
