public class invoice {
    private String customer;
    private performances[] performances;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public performances[] getPerformances() {
        return performances;
    }

    public void setPerformances(performances[] performances) {
        this.performances = performances;
    }

    public invoice(String customer, performances[] performances) {
        this.customer = customer;
        this.performances = performances;
    }

    /**
     * Create bill for customer
     * @return a string contain bill's information and format
     *
     * Statement for [customer's name]
     * [play's name]: [amount of money of this play]$ [total seats of this play] seats
     * ...
     * Amount owned is: [total amount of money]
     * You earned [amount of credits] credits
     */
    public String bills() {
        int totalAmount = 0;
        int volumeCredit = 0;
        StringBuilder result = new StringBuilder("Statement for " + this.getCustomer() + "\n");

        for (performances perf : this.getPerformances()) {
            plays play = perf.getPlayID();
            int thisAmount = 0;

            thisAmount = calcPerf(perf);
            totalAmount += thisAmount;
            volumeCredit += calcVolumeCredit(perf);

            result.append(play.getPlayID())
                    .append(": ")
                    .append(thisAmount)
                    .append("$ ")
                    .append(perf.getAudience())
                    .append(" seats\n");
        }

        result.append("Amount owned is: ")
                .append(totalAmount)
                .append("$\n");

        result.append("You earned ")
                .append(volumeCredit)
                .append("$ credits\n");

        return result.toString();
    }

    private int calcPerf(performances perf) {
        int result = 0;
        plays play = perf.getPlayID();

        switch (play.getType()) {
            case "tragedy":
                result = 400;
                if (perf.getAudience() > 30) {
                    result += 10 * (perf.getAudience() - 30);
                }
                break;
            case "comedy":
                result = 300;
                if (perf.getAudience() > 20) {
                    result += 100 + 5 * (perf.getAudience() - 20);
                }
                result += 3 * perf.getAudience();
                break;
            default:
                throw new Error("unknown type: " + play.getType());
        }

        return result;
    }

    private int calcVolumeCredit(performances perf) {
        int result = 0;

        result += Math.max(perf.getAudience() - 30, 0);
        result += comedyAdd(perf);

        return result;
    }

    private double comedyAdd(performances perf) {
        plays play = perf.getPlayID();

        if ("comedy".equals(play.getType())) {
            return Math.floor(perf.getAudience() / 5);
        }

        return 0;
    }
}