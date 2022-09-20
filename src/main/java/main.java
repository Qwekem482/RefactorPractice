public class main {
    public static void main(String[] args) {
        plays[] plays = new plays[3];
        plays[0] = new plays("Hamlet", "tragedy");
        plays[1] = new plays("As You Like It", "comedy");
        plays[2] = new plays("Othello", "tragedy");

        performances[] performances = new performances[3];
        performances[0] = new performances(plays[0], 55);
        performances[1] = new performances(plays[1], 35);
        performances[2] = new performances(plays[2], 40);

        invoice invoice = new invoice("BigCo", performances);

        String print = invoice.bills(invoice);

        System.out.println(print);
    }
}
