public class toolStore extends NormalLocation {
    public toolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("----------- Welcome to the store ! -----------");
        boolean showMenu=true;
        while (showMenu){
            System.out.println("1-Weapons");
            System.out.println("2-Armors");
            System.out.println("3-Exit to safe house");
            System.out.print("Your Choice");
            int selectCase = inp.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Invalid value choose again ! ");
                selectCase = inp.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                default:
                    System.out.println("See you later !");
                    showMenu=false;
                    break;


            }


        }

        return true;

    }

    public void printWeapon() {
        System.out.println("----- Weapons! -----");
        for (Weapon v : Weapon.weapons()) {
            System.out.println(v.getId() + "-" + v.getName() + " <Price :" + v.getPrice() + " Damage :" + v.getDamage() + " >");
        }
        System.out.println("0-Exit");

    }
    public void buyWeapon(){

        System.out.print("\tChoose your weapon ");
        System.out.println();
        int selectWeaponID = inp.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.print("\tInvalid value choose again ! ");
            selectWeaponID = inp.nextInt();
        }
        if (selectWeaponID !=0){
            Weapon selectedWeapon = Weapon.getWeaponById(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > getPlayer().getMoney()) {
                    System.out.println("You do not have enough money ! ");
                } else {
                    //Purchasing Process
                    System.out.println("Purchase confirmed you got the " + selectedWeapon.getName());
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining money : " + this.getPlayer().getMoney());
                    System.out.println("Previous weapon: "+this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("New weapon: "+this.getPlayer().getInventory().getWeapon().getName());


                }

            }

        }


    }


    public void printArmor() {
        System.out.println("----- Armors -----");
        for (Armor armor:Armor.armors()){
            System.out.println(armor.getId() + "-" + armor.getName() + " <Price :" + armor.getPrice() + " Block :" + armor.getBlock() + " >");
        }
        System.out.println("0-Exit");




    }

    public  void buyArmor(){

        System.out.print("Choose your armor ");
        int selectArmorID = inp.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.print("Invalid value choose again ! ");
            selectArmorID = inp.nextInt();
        }
        if (selectArmorID !=0){
            Armor selectedArmor = Armor.getArmorbyID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > getPlayer().getMoney()) {
                    System.out.println("You do not have enough money ! ");
                } else {
                    //Purchasing Process
                    System.out.println("Purchase confirmed you got the " + selectedArmor.getName());
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining money : " + this.getPlayer().getMoney());
                    System.out.println("Previous Armor: "+this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("New Armor: "+this.getPlayer().getInventory().getArmor().getName());


                }

            }
        }



    }
}
