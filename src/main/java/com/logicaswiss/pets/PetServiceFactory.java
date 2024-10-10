package com.logicaswiss.pets;

public class PetServiceFactory {
    public PetService getPetService(String petType) {
        return switch (petType) {
            case "cat" -> {
                yield new CatPetService();
            }
            default -> {
                yield new DogPetService();
            }
        };
    }
}
