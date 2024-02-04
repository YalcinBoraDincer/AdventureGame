public class CheckAward {
    private String caveAward;
    private String forestAward;
    private String riverAward;

    public CheckAward(String caveAward, String forestAward, String riverAward) {
        this.caveAward = caveAward;
        this.forestAward = forestAward;
        this.riverAward = riverAward;
    }

    public String getCaveAward() {
        return caveAward;
    }

    public void setCaveAward(String caveAward) {
        this.caveAward = caveAward;
    }

    public String getForestAward() {
        return forestAward;
    }

    public void setForestAward(String forestAward) {
        this.forestAward = forestAward;
    }

    public String getRiverAward() {
        return riverAward;
    }

    public void setRiverAward(String riverAward) {
        this.riverAward = riverAward;
    }
}
