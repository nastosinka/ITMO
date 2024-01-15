package itmo.location;

public enum Location {
    STAIRS("Лестница"), ROOM("Комната"), BALKON("Балкончик"); // вводим локации
    private String location;
    Location(String location) {
        this.location = location;
    } // конструктор
    @Override // переопределяем вывод локации, чтоб всё по-русски было
    public String toString() {
        return location;
    }
}
