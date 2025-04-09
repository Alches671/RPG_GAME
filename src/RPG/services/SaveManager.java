package RPG.services;

import RPG.entities.Player;

import java.io.*;

public class SaveManager {
    private static final String SAVE_FILE = "save.dat";

    public static void saveGame(Player player) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            out.writeObject(player);
            System.out.println("Игра сохранена.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении игры: " + e.getMessage());
        }
    }

    public static Player loadGame() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
            Player player = (Player) in.readObject();
            System.out.println("Игра загружена.");
            return player;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке игры: " + e.getMessage());
            return null;
        }
    }

    public static boolean saveExists() {
        return new File(SAVE_FILE).exists();
    }
}
