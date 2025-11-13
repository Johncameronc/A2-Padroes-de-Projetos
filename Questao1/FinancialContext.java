public class FinancialContext {
    private double portfolioValue;
    private double volatility;
    private double confidenceLevel;

    public FinancialContext(double portfolioValue, double volatility, double confidenceLevel) {
        this.portfolioValue = portfolioValue;
        this.volatility = volatility;
        this.confidenceLevel = confidenceLevel;
    }

    public double getPortfolioValue() { return portfolioValue; }
    public double getVolatility() { return volatility; }
    public double getConfidenceLevel() { return confidenceLevel; }
}
