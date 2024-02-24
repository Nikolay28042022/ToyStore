import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ToyStore {
    private List<Toy> toyList = new ArrayList<>();
    private List<String> waitingToys = new ArrayList<>();

    public ToyStore() {
        initializeToys();
    }

    private void initializeToys() {
        toyList.add(new Toy(1, "Конструктор", 10, 20));
        toyList.add(new Toy(2, "Робот", 15, 20));
        toyList.add(new Toy(3, "Кукла", 20, 60));
    }

    public void playToyLottery() {
        double totalWeight = 0;

        for (Toy toy : toyList) {
            totalWeight += toy.getWeight();
        }

        double randomNumber = new Random().nextDouble() * totalWeight;
        double currentWeight = 0;

        for (Toy toy : toyList) {
            currentWeight += toy.getWeight();
            if (randomNumber <= currentWeight) {
                if (toy.getQuantity() > 0) {
                    System.out.println("Вы выиграли: " + toy.getName());
                    waitingToys.add(toy.getName());
                    saveToCsvFile(toy);
                    toy.decreaseQuantity();
                } else {
                    System.out.println("Извините, данная игрушка закончилась. Попробуйте еще раз.");
                }
                break;
            }
        }
    }


    private void saveToCsvFile(Toy toy) {
        try (FileWriter writer = new FileWriter("призовые_игрушки.csv", true)) {
            writer.write(toy.getName() + ",");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayWaitingToys() {
        System.out.println("Список ожидающих выдачу игрушек:");
        for (String waitingToy : waitingToys) {
            System.out.println(waitingToy);
        }
    }
}