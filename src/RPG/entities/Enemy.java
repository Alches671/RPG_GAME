package RPG.entities;

public class Enemy {
    private String name;
    private int health;
    private int damage;
    private int reward;

    public Enemy(String name, int health, int damage, int reward) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.reward = reward;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getReward() { return reward; }

    public void takeDamage(int amount) {
        health -= amount;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
