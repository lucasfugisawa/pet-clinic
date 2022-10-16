package br.com.fugisawa.petclinic.services.sdjpa;

import br.com.fugisawa.petclinic.model.Vet;
import br.com.fugisawa.petclinic.model.Visit;
import br.com.fugisawa.petclinic.repositories.VisitRepository;
import br.com.fugisawa.petclinic.services.VetService;
import br.com.fugisawa.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("persist-sdjpa")
public class VisitSdjpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSdjpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        this.visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return this.visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return this.visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        this.visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        this.visitRepository.deleteById(id);
    }
}
