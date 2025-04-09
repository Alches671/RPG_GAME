package RPG.game;

import RPG.entities.Player;
import RPG.services.SaveManager;
import RPG.services.Trader;

import java.util.Scanner;

public class Lobby {
    private static final Scanner scanner = new Scanner(System.in);

    public static void enter(Player player) {
        while (true) {
            System.out.println("\n=== Лобби ===");
            System.out.println("1. Отправиться в лес");
            System.out.println("2. Подойти к торговцу");
            System.out.println("3. Поспать (восстановить здоровье)");
            System.out.println("4. Посмотреть статистику");
            System.out.println("5. Сохранить игру");
            System.out.println("6. Загрузить игру");
            System.out.println("7. Выйти из игры");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Forest.explore(player);
                    break;
                case "2":
                    Trader.shop(player);
                    break;
                case "3":
                    player.restoreHealth();
                    System.out.println("Вы отдохнули. Здоровье восстановлено.");
                    break;
                case "4":
                    player.showStats();
                    break;
                case "5":
                    SaveManager.saveGame(player);
                    break;
                case "6":
                    Player loaded = SaveManager.loadGame();
                    if (loaded != null) {
                        enter(loaded);
                        return;
                    }
                    break;
                case "7":
                    System.out.println("До встречи!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод.");
            }
        }
    }
}
