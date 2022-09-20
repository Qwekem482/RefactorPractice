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

    public String bills(invoice invoice) {
        int totalAmount = 0;
        int volumeCredit = 0;
        StringBuilder result = new StringBuilder("Statement for " + invoice.getCustomer() + "\n");

        for (performances perf : invoice.getPerformances()) {
            plays play = perf.getPlayID();
            int thisAmount = 0;

            /*
            switch (pl.getType()) {
                case "tragedy":
                    thisAmount = 40000;
                    if (perf.getAudience() > 30) {
                        thisAmount += 1000 * (perf.getAudience() - 30);
                    }
                    break;
                case "comedy":
                    thisAmount = 30000;
                    if (perf.getAudience() > 20) {
                        thisAmount += 10000 + 500 * (perf.getAudience() - 20);
                    }
                    thisAmount += 300 * perf.getAudience();
                    break;
                default:
                    throw new Error("unknown type: " + pl.getType());
            }
            */

            /*
            volumeCredit = Math.max(perf.getAudience() - 30, 0);


            if ("comedy".equals(pl.getType())) {
                volumeCredit += Math.floor(perf.getAudience() / 5);
            }
             */

            thisAmount = calcPerf(perf);
            totalAmount += thisAmount;
            volumeCredit += calcVolumeCredit(perf);

            result.append(play.getPlayID()).append(": ").append(thisAmount / 100).append("$ ")
                    .append(perf.getAudience()).append(" seats\n");
        }
        result.append("Amount owned is: ").append(totalAmount / 100).append("$\n");
        result.append("You earned ").append(volumeCredit).append("$ credits\n");

        return result.toString();
    }

    private int calcPerf(performances perf) {
        int result = 0;
        plays play = perf.getPlayID();

        switch (play.getType()) {
            case "tragedy":
                result = 40000;
                if (perf.getAudience() > 30) {
                    result += 1000 * (perf.getAudience() - 30);
                }
                break;
            case "comedy":
                result = 30000;
                if (perf.getAudience() > 20) {
                    result += 10000 + 500 * (perf.getAudience() - 20);
                }
                result += 300 * perf.getAudience();
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