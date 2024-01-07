import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Stock[] stocks = new Stock[5];
        stocks[0] = new Stock("ORCL", "Oracle Corporation", 34.5, 34.35);
        stocks[1] = new Stock("CSCO", "Cisco Systems", 42.0, 40.5);
        stocks[2] = new Stock("HPQ", "Hewlett Packard", 55.0, 53.0);
        stocks[3] = new Stock("IBM", "Int'l Business Machines", 100.0, 102.50);
        stocks[4] = new Stock("SUNW", "Sun Microsystems", 80.0, 80.50);

        Arrays.sort(stocks);

        System.out.println("Stocks in order:");
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
    }
}