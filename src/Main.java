public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        while (true) {
            System.out.println("1. Розыгрыш игрушек");
            System.out.println("2. Вывести список ожидающих выдачу игрушек");
            System.out.println("3. Выход");

            int choice = new java.util.Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    toyStore.playToyLottery();
                    break;
                case 2:
                    toyStore.displayWaitingToys();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }
    }
}
