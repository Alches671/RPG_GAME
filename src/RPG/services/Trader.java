package RPG.services;

import RPG.entities.Player;

import java.util.Scanner;

public class Trader {
    private static final Scanner scanner = new Scanner(System.in);

    public static void shop(Player player) {
        while (true) {
            System.out.println("\n=== Торговец ===");
            System.out.println("Ваше золото: " + player.getGold());
            System.out.println("1. Купить +5 к здоровью (20 золота)");
            System.out.println("2. Купить +5 к силе (20 золота)");
            System.out.println("3. Выйти");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (player.spendGold(20)) {
                        player.addBonusHealth(5);
                        SaveManager.saveGame(player);
                        player.restoreHealth();
                        System.out.println("Вы увеличили здоровье!");
                    } else {
                        System.out.println("Недостаточно золота.");
                    }
                    break;
                case "2":
                    if (player.spendGold(20)) {
                        player.addBonusStrength(5);
                        SaveManager.saveGame(player);
                        System.out.println("Вы увеличили силу!");
                    } else {
                        System.out.println("Недостаточно золота.");
                    }
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Неверный ввод.");
            }
        }
    }
}
