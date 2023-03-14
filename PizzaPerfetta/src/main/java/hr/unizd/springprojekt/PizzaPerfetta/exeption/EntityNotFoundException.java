package hr.unizd.springprojekt.PizzaPerfetta.exeption;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message) {
        super(message);
    }
}
