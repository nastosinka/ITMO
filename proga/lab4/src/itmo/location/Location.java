package itmo.location;

public enum Location {
    STAIRS("Лестница", "через дверь"),
    WINDOW("Окно кухни", "через комнату"),
    ROOM("Комната", "через дверь"),
    BALKON("Балкончик", "через лестницу чёрного хода"),
    DOOR("Входная дверь", "через лестницу или комнату"), // вводим локации
    BLACK_EXIT("Черный выход", "через окно"),
    HOUSE_PORCH("Крыльцо дома", "через балкончик");

    private String location;
    private String howToAchieve;
    Location(String location, String howToAchieve) {
        this.location = location;
        this.howToAchieve = howToAchieve;
    } // конструктор
    public String getFullDescription() {
        return location + ". Добраться можно " + howToAchieve + ".";
    }
    @Override // переопределяем вывод локации, чтоб всё по-русски было
    public String toString() {
        return location;
    }
}
