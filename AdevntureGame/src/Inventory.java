public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private CheckAward award;


    public Inventory() {
       this.weapon=new Weapon(-1,"fist",15,0);
       this.armor=new Armor(-1,"Naked",0,0);
       this.award=new CheckAward("","","");
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public CheckAward getAward() {
        return award;
    }

    public void setAward(CheckAward award) {
        this.award = award;
    }

}
