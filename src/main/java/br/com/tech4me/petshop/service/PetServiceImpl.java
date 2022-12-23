package br.com.tech4me.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.petshop.model.Pet;
import br.com.tech4me.petshop.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService{
    @Autowired
    private PetRepository repositorioDePets;
    
    @Override
    public Pet cadastrarPet(Pet pet) {
        return repositorioDePets.save(pet);
    }

    @Override
    public List<Pet> obterTodosOsPets() {
        return repositorioDePets.findAll();
    }

    @Override
    public Optional<Pet> obterPetPorId(String id) {
        return repositorioDePets.findById(id);
    }

    @Override
    public void excluirPetPorId(String id) {
        repositorioDePets.deleteById(id);
    }

    @Override
    public Optional<Pet> atualizarPetPorId(String id, Pet pet) {
      Optional<Pet> retorno = repositorioDePets.findById(id);
  
      if (retorno.isPresent()) {
        pet.setId(id);
        return Optional.of(repositorioDePets.save(pet));
      } else {
        return Optional.empty();
      }
    
    }

}
