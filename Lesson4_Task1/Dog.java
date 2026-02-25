public class Dog extends Animal{

    protected static int dogCount = 0; // счетчик для собак

    public Dog (String name){
        super(name);
        dogCount++;
    }

    // геттер для счетчика
    public static int getDogCount(){
        return dogCount;
    }

    @Override
    public void run (int distance){
        if (distance > 500){
            System.out.println("Собаки не могут преодолевать дистанции более 500 метров");
        } else {
            System.out.println(name + " пробежал(а) " + distance + " м.");
        }
    }

    @Override
    public void swim (int distance){
        if (distance > 10){
            System.out.println("Собаки не могут проплывать дистанции более 10 метров");
        } else {
            System.out.println(name + " проплыл(а) " + distance + " м.");
        }
    }

}
