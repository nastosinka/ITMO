package itmo.exceptions;

public class TwoWorlds extends RuntimeException {
    public TwoWorlds() {
        super("У вас не может быть двух таких объектов:(");
    }
}