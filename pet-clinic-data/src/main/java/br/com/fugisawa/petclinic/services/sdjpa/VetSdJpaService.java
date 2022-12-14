package br.com.fugisawa.petclinic.services.sdjpa;

import br.com.fugisawa.petclinic.model.Vet;
import br.com.fugisawa.petclinic.repositories.VetRepository;
import br.com.fugisawa.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("persist-sdjpa")
public class VetSdJpaService implements VetService {

    private VetRepository vetRepository;

    public VetSdJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        this.vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return this.vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return this.vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        this.vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        this.deleteById(id);
    }
}
