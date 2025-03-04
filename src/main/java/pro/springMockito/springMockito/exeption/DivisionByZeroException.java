package pro.springMockito.springMockito.exeption;


public class DivisionByZeroException extends RuntimeException {
    public DivisionByZeroException() {
        super("Ошибка: деление на 0 запрещено!");
    }
}
