import java.nio.file.FileAlreadyExistsException;
import java.util.Random;

public abstract class BattleLocation extends Location{
    private Monster monster;
    private String award;
    private int maxMonster;
    public static Random random = new Random();



    int result = random.nextInt(2);
    public BattleLocation(Player player, String name,Monster monster,String award,int maxMonster) {
        super(player, name);
        this.monster=monster;
        this.award=award;
        this.maxMonster=maxMonster;

    }
    public  int randomMonsterNum(){
        Random rand=new Random();
        return rand.nextInt(this.getMaxMonster())+1; //Generate random number between 1-3
    }


    @Override
    public boolean onLocation() {
        int obsNumber=randomMonsterNum();

        System.out.println("Current location : "+this.getName());
        System.out.println("Be careful a monster called "+this.getMonster().getName()+" lives here !");
        System.out.println("There are "+obsNumber+" of them here and very hungry ! ");
        System.out.println("<F>ight or <R>un away");
        String selectBattleCase=inp.nextLine().toUpperCase();
        if (selectBattleCase.equals("F")){
            if (combat(obsNumber)){
                System.out.println(this.getName()+" All enemies are defeated ! ");
                return true;
            }
        }
        if (this.getPlayer().getHealth()<=0){
            System.out.println("You are dead ! ");
            return false;
        }


        return true;
    }
    public boolean combat(int monsterNumber){
        for (int i=1;i<=monsterNumber;i++){
            boolean continueCombat = true;
            this.getMonster().setHealth(this.getMonster().getOriginalHealth());
            playerStats();
            monsterStats(i);
            while (this.getPlayer().getHealth() >0 && this.getMonster().getHealth()>0){
                System.out.println("<F>ight or <R>un");
                String selectChoice=inp.nextLine().toUpperCase();
                if (selectChoice.equals("F") && result==1){
                    System.out.println("You Hit ! ");
                    this.getMonster().setHealth((this.getMonster().getHealth())-(this.getPlayer().getTotalDamage()));
                    afterHit();
                    if (this.getMonster().getHealth() >0){
                        System.out.println();
                        System.out.println("Monster hit you");
                        int monsterDamage=this.getMonster().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                        if (monsterDamage < 0){
                            monsterDamage=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-monsterDamage);
                        afterHit();
                    }

                }
                else if (selectChoice.equals("F") && result==0) {
                    System.out.println("Monster Hit ! ");
                    this.getPlayer().setHealth((this.getPlayer().getHealth())-(this.getMonster().getDamage()));
                    afterHit();
                    if (this.getPlayer().getHealth() >0){
                        System.out.println();
                        System.out.println("You hit ! ");
                        int playerDamage=this.getPlayer().getTotalDamage();
                        if (playerDamage < 0){
                            playerDamage=0;
                        }
                        this.getMonster().setHealth(this.getMonster().getHealth()-playerDamage);
                        afterHit();
                    }
                }else {
                     continueCombat = false;}
                if (!continueCombat) {
                    return false;}

            }

            if (this.getMonster().getHealth()<this.getPlayer().getHealth()){
                System.out.println("Congrats all monsters defeated ! ");
                System.out.println("You won the "+this.getMonster().getAward()+" coin");
                System.out.println("Old coin "+this.getPlayer().getMoney());
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getMonster().getAward());
                System.out.println("Current coin "+this.getPlayer().getMoney());
                System.out.println();

            }else{
                return false;
            }
            if (i==monsterNumber && this.getMonster().getName().equals("zombie")){
                System.out.println("Congratulations you complated the cave and won the <FOOD>");
                System.out.println("Location Closed ! ");
                this.getPlayer().getInventory().getAward().setCaveAward("FOOD");

            }
            if (i==monsterNumber && this.getMonster().getName().equals("vampire")){
                System.out.println("Congratulations you complated the forest and won the <FIREWOOD>");
                System.out.println("Location Closed ! ");
                this.getPlayer().getInventory().getAward().setForestAward("FIREWOOD");
            }
            if (i==monsterNumber && this.getMonster().getName().equals("bear")){
                System.out.println("Congratulations you complated the river and won the <WATER>");
                System.out.println("Location Closed ! ");
                this.getPlayer().getInventory().getAward().setRiverAward("WATER");
            }
            if (i==monsterNumber && this.getMonster().getName().equals("snake")){
                dropItemMine();




            }


        }





        return  true;
    }
    public void dropItemMine(){
        int dropItemPercent=random.nextInt(101);
        int droppedItem=random.nextInt(101);
        System.out.println("DENEME SILINECEK");
        System.out.println("dropItemPercent = "+dropItemPercent);
        System.out.println("dropped item = "+droppedItem);
        System.out.println();
        // %15 Drop Weapon
        if (dropItemPercent >0 && dropItemPercent <= 15){
            if (droppedItem >0 && droppedItem<=20){
                System.out.println("Congratulations, you have completed the mine");
                System.out.println("New item added your inventory <Rifle>");
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(3));
            }
            if (droppedItem >20 && droppedItem<=50){
                System.out.println("Congratulations, you have completed the mine");
                System.out.println("New item added your inventory <Sword>");
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(2));
            }
            if (droppedItem >50){
                System.out.println("Congratulations, you have completed the mine");
                System.out.println("New item added your inventory <Pistol>");
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(1));
            }



            // %15 Drop Armor
        }if (dropItemPercent >15 && dropItemPercent <= 30){
            if (droppedItem >0 && droppedItem<=20){
                System.out.println("Congratulations, you have completed the mine");
                System.out.println("New item added your inventory <Heavy Armor>");
                this.getPlayer().getInventory().setArmor(Armor.getArmorbyID(3));
            }
            if (droppedItem >20 && droppedItem<=50){
                System.out.println("Congratulations, you have completed the mine");
                System.out.println("New item added your inventory <Normal Armor>");
                this.getPlayer().getInventory().setArmor(Armor.getArmorbyID(2));
            }
            if (droppedItem >50){
                System.out.println("Congratulations, you have completed the mine");
                System.out.println("New item added your inventory <Light Armor>");
                this.getPlayer().getInventory().setArmor(Armor.getArmorbyID(1));
            }



            // %25 coin

        }if (dropItemPercent >30 && dropItemPercent <= 55){
            if (droppedItem >0 && droppedItem<=20){
                System.out.println("Congratulations, you have completed the mine");
                System.out.println("New item added your inventory < 10 coin >");
                this.getPlayer().setMoney(getPlayer().getMoney()+10);
            }
            if (droppedItem >20 && droppedItem<=50){
                System.out.println("Congratulations, you have completed the mine");
                System.out.println("New item added your inventory <5 coin >");
                this.getPlayer().setMoney(getPlayer().getMoney()+5);
            }
            if (droppedItem >50){
                System.out.println("Congratulations, you have completed the mine");
                System.out.println("New item added your inventory <1 coin >");
                this.getPlayer().setMoney(getPlayer().getMoney()+1);
            }
        }

        //%45 Hicbir Sey
        if (dropItemPercent>55){
            System.out.println("What a pity you didn't get anything. :))");
        }
    }

    public void  afterHit(){
        System.out.println("Your health : "+this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName()+" health : "+this.getMonster().getHealth() );
        System.out.println("------------");

    }
    public void playerStats(){
        System.out.println("Player Stats");
        System.out.println("------------");
        System.out.println("Health: "+this.getPlayer().getHealth());
        System.out.println("Weapon: "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor: "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block: "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Damage: "+this.getPlayer().getTotalDamage());
        System.out.println("Money: "+this.getPlayer().getMoney());
        System.out.println();
    }
    public void monsterStats(int i){
        System.out.println(i+"."+this.getMonster().getName()+"Stats");
        System.out.println("------------");
        System.out.println("Health: "+this.getMonster().getHealth());
        System.out.println("Damage: "+this.getMonster().getDamage());
        System.out.println("Award: "+this.getMonster().getAward());
        System.out.println();
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
