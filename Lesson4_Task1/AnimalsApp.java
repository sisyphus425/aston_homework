public class AnimalsApp {
    public static void main(String[] args) {

        // проверка вывода информации о беге/плавании животных
        Animal catMurzik = new Cat("Мурзик", 5);
        Animal dogSharik = new Dog("Шарик");

        catMurzik.run(201);
        catMurzik.run(150);
        catMurzik.swim(5);
        dogSharik.run(501);
        dogSharik.run(300);
        dogSharik.swim(11);
        dogSharik.swim(9);
        System.out.println("-----------------------");

        // проверка подсчета животных (с учетом старых объектов)
        Animal a1 = new Cat ("Снежок", 10);
        Animal a2 = new Dog ("Цезарь");
        Animal a3 = new Dog ("Бобик");

        System.out.println("Кол-во животных:" + Animal.getAnimalsCount());
        System.out.println("Кол-во котов:" + Cat.getCatCount());
        System.out.println("Кол-во собак:" + Dog.getDogCount());
        System.out.println("-----------------------");

        // Кормление котов из миски
        Bowl bowl = new Bowl(25);
        System.out.println("Еды в миске: " + bowl.getFood());

	// массив из объектов
        Cat[] cats = {
                new Cat("Оникс", 9),
                new Cat("Дымок", 5),
                new Cat("Рокки", 6),
        };

	// обход циклом по всему массиву
        for (Cat cat : cats){
            cat.eat(bowl);
        }

        for (Cat cat : cats){
            System.out.println(cat.name + " сыт: " + cat.isSatiety());
        }

        System.out.println("Еды в миске осталось: " + bowl.getFood());
    }
}
