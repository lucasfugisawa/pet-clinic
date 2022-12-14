package br.com.fugisawa.petclinic.services.sdjpa;

import br.com.fugisawa.petclinic.model.Speciality;
import br.com.fugisawa.petclinic.repositories.SpecialityRepository;
import br.com.fugisawa.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("persist-sdjpa")
public class SpecialitySdJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySdJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        this.specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return this.specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return this.specialityRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        this.specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        this.specialityRepository.deleteById(id);
    }
}
