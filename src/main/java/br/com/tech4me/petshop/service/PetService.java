package br.com.tech4me.petshop.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.petshop.model.Pet;

public interface PetService {
    Pet cadastrarPet(Pet pet);
    List<Pet> obterTodosOsPets();
    Optional<Pet> obterPetPorId(String id);
    void excluirPetPorId(String id);
    Optional<Pet> atualizarPetPorId(String id, Pet pet);
}
