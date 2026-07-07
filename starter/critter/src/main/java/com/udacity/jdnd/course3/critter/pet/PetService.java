package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import com.udacity.jdnd.course3.critter.user.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Pet savePet(Pet pet) {
        Pet savedPet = petRepository.save(pet);
        Customer owner = savedPet.getOwner();
        if (owner != null) {
            List<Pet> pets = owner.getPets();
            if (pets == null) {
                pets = new ArrayList<>();
            }
            if (!pets.contains(savedPet)) {
                pets.add(savedPet);
                owner.setPets(pets);
                customerRepository.save(owner);
            }
        }
        return savedPet;
    }

    public Pet getPet(Long petId) {
        return petRepository.findById(petId)
                .orElseThrow(() -> new IllegalArgumentException("Pet with id " + petId + " not found"));
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public List<Pet> getPetsByOwner(Long ownerId) {
        return petRepository.findByOwnerId(ownerId);
    }
}
