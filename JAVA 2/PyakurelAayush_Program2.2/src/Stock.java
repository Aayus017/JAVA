public class Stock implements Comparable<Stock> {
    private String symbol;
    private String name;
    private double prevClosingPrice;
    private double currentPrice;
    private double changePercent;

    public Stock(String symbol, String name, double prevClosingPrice, double currentPrice) {
        this.symbol = symbol;
        this.name = name;
        this.prevClosingPrice = prevClosingPrice;
        this.currentPrice = currentPrice;
        this.changePercent = ((currentPrice - prevClosingPrice) / prevClosingPrice) * 100;
    }

    @Override
    public int compareTo(Stock other) {
        return Double.compare(this.changePercent, other.changePercent);
    }

    @Override
    public String toString() {
        String finalChangePercent = String.format("%.2f", changePercent);
        return symbol + " " + name + " -- change percent " + finalChangePercent;
    }
}