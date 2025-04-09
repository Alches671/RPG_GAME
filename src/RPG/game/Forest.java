package RPG.game;

import RPG.entities.Enemy;
import RPG.entities.Player;

import java.util.Random;
import java.util.Scanner;

public class Forest {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void explore(Player player) {
        while (true) {
            Enemy enemy = getRandomEnemy();
            System.out.println("Вы встретили врага: " + enemy.getName());

            // Бой
            while (player.getCurrentHealth() > 0 && enemy.isAlive()) {
                enemy.takeDamage(player.getStrength());
                if (enemy.isAlive()) {
                    player.takeDamage(enemy.getDamage());
                }
            }

            if (player.getCurrentHealth() > 0) {
                System.out.println("Вы победили " + enemy.getName() + "! Получено золото: " + enemy.getReward());
                player.addGold(enemy.getReward());
            } else {
                System.out.println("Вы проиграли бой!");
                player.loseAllGold();
                player.loseHalfUpgrades();
                player.restoreHealth();
                return;
            }

            System.out.println("1. Вернуться в лобби");
            System.out.println("2. Искать следующего врага");
            String choice = scanner.nextLine();
            if (choice.equals("1")) return;
        }
    }

    private static Enemy getRandomEnemy() {
        int roll = random.nextInt(100);
        if (roll < 50) return new Enemy("Крыса", 10, 5, 2);
        if (roll < 80) return new Enemy("Мародёр", 15, 10, 5);
        if (roll < 99) return new Enemy("Бандит", 20, 15, 10);
        return new Enemy("Дракон", 30, 20, 30);
    }
}
