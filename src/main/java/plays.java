public class plays {
    private String playID;
    private String type;

    public String getPlayID() {
        return playID;
    }

    public void setPlayID(String playID) {
        this.playID = playID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public plays() {
    }

    public plays(String name, String type) {
        playID = name;
        this.type = type;
    }

}
