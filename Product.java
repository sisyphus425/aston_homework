//1.1 Создать класс "Товар" с полями: название, дата производства, производитель, страна происхождения, цена, состояние бронирования покупателем.
public class Product {
    private String name; // название
    private String date; // дата производства
    private String manufacturer; // производитель
    private String country; // страна происхождения
    private int price; // цена
    private boolean status; // состояние бронирования покупателем (true - забронирован, false - не забронирован)

    //1.2 Конструктор класса должен заполнять эти поля при создании объекта.
//    public Product(){
//        name  = "Отвертка крестовая";
//        date = "13/01/2026";
//        manufacturer = "ДомРу";
//        country = "Россия";
//        price = 1150;
//        status = true;
//    }

    // Конструктор для пункта 2 (для массива):
    public Product(String name, String date, String manufacturer,
                   String country, int price, boolean status) {
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.status = status;
    }


    //1.3 Внутри класса «Товар» написать метод, который выводит информацию об объекте в консоль.
    public void productInfo(){
        System.out.println("Название: " + name + "; Дата производства: " + date + "; Производитель: " + manufacturer
                + "; Cтрана происхождения: " + country + "; Цена: " + price + "; Cостояние бронирования покупателем: " + status);
    }


    public static void main(String[] args) {
        //Product product1 = new Product(); // объект для вывода в пункте 1
        //product1.productInfo(); // вызов метода для вывода в пункте 1

        //2. Создать массив из 5 товаров.
        Product[] productArray = new Product[5];
        productArray[0] = new Product("Шуруповерт", "10/11/2025", "HomeTech", "Китай", 15000, true);
        productArray[1] = new Product("Заклепочник", "05/10/2025", "Skytools", "Китай", 5000, true);
        productArray[2] = new Product("Гравер", "22/12/2025", "Atlet", "Россия", 3000, true);
        productArray[3] = new Product("Компрессор", "01/02/2026", "Gigant", "Тайвань", 16000, false);
        productArray[4] = new Product("Степлер", "09/09/2025", "Procraft", "Китай", 5000, false);
        // Вывод для массива
        for (int i = 0; i < productArray.length; i++) {
            System.out.print((i+1)+": ");
            productArray[i].productInfo();
        }

    }


}


