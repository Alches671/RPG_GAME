package RPG.entities;

import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int baseHealth = 30;
    private int baseStrength = 10;
    private int bonusHealth = 0;
    private int bonusStrength = 0;
    private int currentHealth = baseHealth;
    private int gold = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public int getMaxHealth() { return baseHealth + bonusHealth; }
    public int getStrength() { return baseStrength + bonusStrength; }
    public int getGold() { return gold; }
    public int getCurrentHealth() { return currentHealth; }

    public void takeDamage(int amount) {
        currentHealth -= amount;
        if (currentHealth < 0) currentHealth = 0;
    }

    public void heal(int amount) {
        currentHealth += amount;
        if (currentHealth > getMaxHealth()) currentHealth = getMaxHealth();
    }

    public void restoreHealth() {
        currentHealth = getMaxHealth();
    }

    public void addGold(int amount) {
        gold += amount;
    }

    public boolean spendGold(int amount) {
        if (gold >= amount) {
            gold -= amount;
            return true;
        }
        return false;
    }

    public void addBonusHealth(int amount) {
        bonusHealth += amount;
    }

    public void addBonusStrength(int amount) {
        bonusStrength += amount;
    }

    public void loseHalfUpgrades() {
        bonusHealth /= 2;
        bonusStrength /= 2;
    }

    public void loseAllGold() {
        gold = 0;
    }

    public void showStats() {
        System.out.println("Имя: " + name);
        System.out.println("Здоровье: " + currentHealth + "/" + getMaxHealth());
        System.out.println("Сила: " + getStrength());
        System.out.println("Золото: " + gold);
    }
}
