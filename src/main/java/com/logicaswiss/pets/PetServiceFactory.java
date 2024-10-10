package com.logicaswiss.pets;

public class PetServiceFactory {
    public PetService getPetService(String petType) {
        return switch (petType) {
            case "dog" -> {
                yield new DogPetService();
            }
            case "cat" -> {
                yield new CatPetService();
            }
            default -> {
                yield new DogPetService();
            }
        };
    }
}
