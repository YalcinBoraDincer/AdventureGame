import java.util.Random;

public class Monster {
    private  int Id;
    private String name;
    private int damage;
    private int health;
    private int award;
    private int originalHealth;
    private int snakeDamage;
    public static Random random = new Random();


    public Monster(int id, String name, int damage, int health,int award) {
        Id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.originalHealth=health;
        this.award=award;
        this.snakeDamage=damage;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health<0){
            health=0;
        }
        this.health = health;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAward() {
        return award;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getSnakeDamage() {
        return snakeDamage;
    }

    public void setSnakeDamage(int snakeDamage) {
        this.snakeDamage = snakeDamage;
    }
}
