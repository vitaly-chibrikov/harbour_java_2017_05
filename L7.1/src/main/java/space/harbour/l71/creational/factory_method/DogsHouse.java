package space.harbour.l71.creational.factory_method;

/**
 * Created by tully.
 */
public class DogsHouse extends AnimalHouse {
    @Override
    protected Animal getAnimal() {
        return new Dog();
    }
}
