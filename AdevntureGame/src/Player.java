import java.util.Scanner;

public class Player {
    private final Scanner inp=new Scanner(System.in);
    private String name;
    private int damage;
    private int money;
    private int health;
    private int originalHealth;
    private String chaName;
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }
    public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
    }
    public void setTotalDamage(){
        this.damage=this.damage+this.getInventory().getWeapon().getDamage();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getChaName() {
        return chaName;
    }

    public void setChaName(String chaName) {
        this.chaName = chaName;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public void selectCharacter(){

        gameCharacter[] charList={new Samurai(),new Archer(),new Knight()};

        System.out.println("Classes:");
        System.out.println("-----------------------------");
        for (gameCharacter gameCharacter:charList) {
            System.out.println("ID:"+gameCharacter.getCharacterId()+
                    "\tClass:"+gameCharacter.getName()+
                    "\t Damage:"+gameCharacter.getDamage()+
                    "\t Health:"+gameCharacter.getHealth()+
                    "\t Money:"+gameCharacter.getMoney());
        }
        System.out.println("-----------------------------");
        System.out.println("Choose your class :");
        int selectedCharacter=inp.nextInt();
        switch (selectedCharacter){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());


        }

    }

    public void printInfo(){
        System.out.println(
                        "Weapon: "+this.getInventory().getWeapon().getName()+
                        "\tBlock: "+this.getInventory().getArmor().getBlock()+
                        "\tDamage: "+this.getTotalDamage()+
                        "\tHealth: "+this.getHealth()+
                        "\tCoin: "+this.getMoney());

    }



    public void initPlayer(gameCharacter gameCharacter){
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setOriginalHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setChaName(gameCharacter.getName());


    }


}

