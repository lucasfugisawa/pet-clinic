package br.com.fugisawa.petclinic.services.sdjpa;

import br.com.fugisawa.petclinic.model.Owner;
import br.com.fugisawa.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSdJpaServiceTest {

    public static final Long ID = 1L;
    public static final String LAST_NAME = "Last Name";

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSdJpaService ownerSdJpaService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = new Owner();
        returnOwner.setId(ID);
        returnOwner.setLastName(LAST_NAME);
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet =  new HashSet<>();
        Owner owner1 = new Owner();
        owner1.setId(1L);
        returnOwnersSet.add(owner1);
        Owner owner2 = new Owner();
        owner2.setId(2L);
        returnOwnersSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = ownerSdJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
         when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
         Owner owner = ownerSdJpaService.findById(ID);
         assertNotNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = new Owner();
        ownerToSave.setId(ID);
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerSdJpaService.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSdJpaService.delete(returnOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSdJpaService.deleteById(ID);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner owner = ownerSdJpaService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}