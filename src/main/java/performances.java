public class performances {
    private plays playID;
    private int audience;

    public plays getPlayID() {
        return playID;
    }

    public void setPlayID(plays playID) {
        this.playID = playID;
    }

    public int getAudience() {
        return audience;
    }

    public void setAudience(int audience) {
        this.audience = audience;
    }

    public performances(plays playID, int audience) {
        this.playID = playID;
        this.audience = audience;
    }
}
