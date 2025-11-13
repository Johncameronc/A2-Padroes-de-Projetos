public class ExpectedShortfall implements RiskStrategy {
    @Override
    public void calculate(FinancialContext context) {
        double esAmount = context.getPortfolioValue() *
                context.getVolatility() *
                context.getConfidenceLevel() * 1.3;

        System.out.println("\n============ EXPECTED SHORTFALL =============");
        System.out.println("Algoritmo: Conditional VaR");
        System.out.printf("Portfolio: $%.2f%n", context.getPortfolioValue());
        System.out.printf("Risco Calculado: $%.2f%n", esAmount);
        System.out.printf("Perda Média Esperada: $%.2f%n", esAmount * 0.8);
        System.out.println("Recomendação: Diversificar investimentos");
    }
}
