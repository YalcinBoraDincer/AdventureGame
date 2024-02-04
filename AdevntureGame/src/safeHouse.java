public class safeHouse extends NormalLocation{
    public safeHouse(Player player) {
        super(player,"Safe house");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Your are in a safe house");
        System.out.println("Your health has been renewed");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());


        if (getPlayer().getInventory().getAward().getCaveAward().equals("FOOD") &&
                getPlayer().getInventory().getAward().getForestAward().equals("FIREWOOD") &&
                getPlayer().getInventory().getAward().getRiverAward().equals("WATER")) {
            System.out.println("You collected all the awards and  finished The Game Congarts :)) ! ");
            return false;

        }
        return  true;
    }
}
