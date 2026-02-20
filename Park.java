// 3. Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах, времени их работы и стоимости.
public class Park {

    // Внутренний класс
    class Attractions {
        String name;         // название аттракциона
        String workingHours; // время работы
        int price;           // стоимость

        // Дополнительно: конструктор внутреннего класса
        Attractions(String name, String workingHours, int price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        // Дополнительно: вывод для внутреннего класса
        void printInfo() {
            System.out.println("Аттракцион: " + name + "; время работы: " + workingHours + "; стоимость: " + price);
        }
    }

    public static void main(String[] args) {
        Park park = new Park();
        // Объект внутреннего класса
        Park.Attractions attraction1 =
                park.new Attractions("Колесо обозрения", "10:00–22:00", 1500);
        attraction1.printInfo();
    }
}


