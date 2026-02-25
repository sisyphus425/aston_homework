public abstract class Animal {

    protected String name; // имя животного
    protected static int animalsCount = 0; // счетчик для всех животных

    public Animal (String name){
        this.name = name;
        animalsCount++;
    }

    // геттер для счетчика
    public static int getAnimalsCount(){
        return animalsCount;
    }

    public abstract void run (int distance);
    public abstract void swim (int distance);
}
