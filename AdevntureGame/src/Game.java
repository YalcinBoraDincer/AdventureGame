import java.util.Scanner;

public class Game {

private final Scanner inp=new Scanner(System.in);
    public void start(){
        System.out.println();
        System.out.println("\t\t\t\t --> Welcome to the Adventure Game <--   ");
        System.out.println("=============================== RULES ==============================================");
        System.out.println(" ---> When you collect all items from cave forest and river you will win the game !" );
        System.out.println(" ---> All locations are closed when you collect item except mine ");
        System.out.println(" ---> You can enter mine more than one and you become more stronger");
        System.out.println("=====================================================================================");
        System.out.println(("Enter the player name   "));
        String playerName=inp.nextLine();

        Player player=new Player(playerName);
        System.out.println("Dear "+player.getName()+" Welcome to the dark and painful adventure !");
        System.out.println("Please choose your class ");
        player.selectCharacter();

        Location location=null;
        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("#####  Locations  ####");

            System.out.println("1- Safe house");
            System.out.println("2- Store");
            System.out.println("3- Cave --> Reward <Food> be careful for zombies ");
            System.out.println("4- Forest --> Reward <FireWood> be careful for vampires ");
            System.out.println("5- River --> Reward <Water> be careful for bears ");
            System.out.println("6- Mine --> Reward <Random Loot,Coin,Weapon or nothing > be careful for snakes ");
            System.out.println("0- Exit");

            System.out.println("Select the location where you go");
            int selectedLocation=inp.nextInt();

            switch (selectedLocation){
                case 0:
                    location=null;
                    break;

                case 1:
                    location=new safeHouse(player);
                    break;
                case 2:
                    location=new toolStore(player);
                    break;
                case 3:
                    if (player.getInventory().getAward().getCaveAward().equals("FOOD")){
                        System.out.println("You already collect all awards please choose different location !");
                        location=new safeHouse(player);
                    }else {
                        location=new Cave(player);
                    }
                    break;
                case 4:
                    if (player.getInventory().getAward().getForestAward().equals("FIREWOOD")){
                        System.out.println("You already collect all Forest awards please choose different location ! ");
                        location=new safeHouse(player);
                    }else {
                        location=new Forest(player);
                    }
                    break;
                case 5:
                    if (player.getInventory().getAward().getRiverAward().equals("WATER")){
                        System.out.println("You already collect all River awards please choose different location !");
                        location=new safeHouse(player);
                    }else {
                        location=new River(player);
                    }
                    break;
                case 6:
                    location=new Mine(player);
                    break;

                    default:
                    location=new safeHouse(player);

            }
            if (location==null){
                System.out.println("See ya coward ! ");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }


        }

    }


}
