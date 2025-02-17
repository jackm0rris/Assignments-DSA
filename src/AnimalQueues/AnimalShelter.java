package AnimalQueues;

import java.util.LinkedList;
import java.util.Queue;

enum AnimalType { Dog, Cat }

class Animal {
    private String name;
    private AnimalType type;

    public Animal(String name, AnimalType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public AnimalType getType() {
        return type;
    }
}

public class AnimalShelter {
    private Queue<Animal> animals = new LinkedList<>();

    public void enQueue(Animal animal) {
        animals.add(animal);
    }

    public Animal deQueueAny() {
        return animals.isEmpty() ? null : animals.poll();
    }

    private Animal deQueueByType(AnimalType type) {
        for (Animal animal : new LinkedList<>(animals)) {
            if (animal.getType() == type) {
                animals.remove(animal);
                return animal;
            }
        }
        return null;
    }

    public Animal deQueueDog() {
        return deQueueByType(AnimalType.Dog);
    }

    public Animal deQueueCat() {
        return deQueueByType(AnimalType.Cat);
    }

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.enQueue(new Animal("Lacey", AnimalType.Dog));
        shelter.enQueue(new Animal("Bella", AnimalType.Cat));
        shelter.enQueue(new Animal("Bandit", AnimalType.Dog));
        shelter.enQueue(new Animal("Marble", AnimalType.Cat));

        System.out.println("Adopt any animal (oldest): " + shelter.deQueueAny().getName());

        Animal dog = shelter.deQueueDog();
        System.out.println("Adopt dog (oldest): " + (dog != null ? dog.getName() : "No dogs available"));

        Animal cat = shelter.deQueueCat();
        System.out.println("Adopt cat (oldest): " + (cat != null ? cat.getName() : "No cats available"));
    }
}

