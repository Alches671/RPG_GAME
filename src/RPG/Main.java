package RPG;

import RPG.entities.Player;
import RPG.game.Lobby;
import RPG.services.SaveManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = null;

        while (true) {
            System.out.println("\n=== Главное меню ===");
            System.out.println("1. Новая игра");
            System.out.println("2. Загрузить игру");
            System.out.println("3. Выйти");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Введите имя персонажа:");
                    String name = scanner.nextLine();
                    while (name.trim().isEmpty()) {
                        System.out.println("Имя не может быть пустым. Попробуйте снова:");
                        name = scanner.nextLine();
                    }

                    player = new Player(name);
                    System.out.println("Добро пожаловать, " + name + "!");
                    Lobby.enter(player);
                    break;

                case "2":
                    if (SaveManager.saveExists()) {
                        player = SaveManager.loadGame();
                        if (player != null) {
                            Lobby.enter(player);
                        }
                    } else {
                        System.out.println("Сохранение не найдено.");
                    }
                    break;

                case "3":
                    System.out.println("До встречи!");
                    return;

                default:
                    System.out.println("Неверный ввод.");
            }
        }
    }
}

