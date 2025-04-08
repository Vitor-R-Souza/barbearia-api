package me.personal.barbearia_api.exception;

/* Este código define uma classe de exceção personalizada que estende RuntimeException. Isso permite que a exceção seja
lançada quando um recurso não é encontrado na aplicação. Ao estender RuntimeException, a exceção não precisa ser declarada
nos métodos que a lançam (unchecked exception). */

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
