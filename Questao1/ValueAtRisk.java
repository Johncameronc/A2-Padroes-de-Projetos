public class ValueAtRisk implements RiskStrategy {
    @Override
    public void calculate(FinancialContext context) {
        double varAmount = context.getPortfolioValue() *
                context.getVolatility() *
                context.getConfidenceLevel();

        System.out.println("\n============= VALUE AT RISK =============");
        System.out.println("Algoritmo: VaR Paramétrico");
        System.out.printf("Portfolio: $%.2f%n", context.getPortfolioValue());
        System.out.printf("Risco Calculado: $%.2f%n", varAmount);
        System.out.printf("Confiança: %.0f%%%n", context.getConfidenceLevel() * 100);
        System.out.println("Recomendação: Manter reserva de capital");
    }
}
