public class Bowl {
    // Класс для изменения кол-ва еды в миске

    private int food; // количество еды в миске

    public Bowl(int food) {
        this.food = food;
    }

    public int getFood(){
        return food;
    }

    // уменьшение еды в миске
    public void decreaseFood(int amount) {
        if (amount <= 0) return;
        if (food >= amount) {
            food -= amount;
        }
    }

    // добавление еды в миску
    public void addFood (int amount){
        if (amount > 0){
            food += amount;
        }
    }

}
