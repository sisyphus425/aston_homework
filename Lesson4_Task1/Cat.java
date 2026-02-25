public class Cat extends Animal{

    protected static int catCount = 0; // счетчик для котов
    private boolean satiety; // сытость котов
    private int appetite; // сколько кот ест за один заход

    public Cat (String name, int appetite){
        super(name);
        catCount++;
        this.appetite = appetite;
        this.satiety = false; // при создании кот голоден
    }

    public boolean isSatiety(){
        return satiety;
    }

    // геттер для счетчика
    public static int getCatCount(){
        return catCount;
    }

    public void eat (Bowl bowl){
        // если в миске достаточно еды — кот ест, иначе не трогает
        if (bowl.getFood() >= appetite){
            bowl.decreaseFood(appetite);
            satiety = true;
        }
    }

    @Override
    public void run (int distance){
        if (distance > 200){
            System.out.println("Коты не могут преодолевать дистанции более 200 метров");
        } else {
            System.out.println(name + " пробежал(а) " + distance + " м.");
        }
    }

    @Override
    public void swim (int distance){
        System.out.println("Коты не умеют плавать");
    }
}
