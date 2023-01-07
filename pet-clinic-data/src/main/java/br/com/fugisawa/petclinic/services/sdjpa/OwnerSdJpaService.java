package br.com.fugisawa.petclinic.services.sdjpa;

import br.com.fugisawa.petclinic.model.Owner;
import br.com.fugisawa.petclinic.repositories.OwnerRepository;
import br.com.fugisawa.petclinic.repositories.PetRepository;
import br.com.fugisawa.petclinic.repositories.PetTypeRepository;
import br.com.fugisawa.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("persist-sdjpa")
public class OwnerSdJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSdJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        this.ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return this.ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return this.ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        this.ownerRepository.delete(owner);

    }

    @Override
    public void deleteById(Long id) {
        this.ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.ownerRepository.findByLastName(lastName);
    }
}
