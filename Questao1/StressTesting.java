public class StressTesting implements RiskStrategy {
    @Override
    public void calculate(FinancialContext context) {
        double stressLoss = context.getPortfolioValue() * 0.25;

        System.out.println("\n========== STRESS TESTING ==========");
        System.out.println("Algoritmo: Análise de Cenários Extremos");
        System.out.printf("Portfolio: $%.2f%n", context.getPortfolioValue());
        System.out.printf("Perda em Cenário de Crise: $%.2f%n", stressLoss);
        System.out.printf("Impacto: %.0f%% do portfolio%n", 25.0);
        System.out.println("Recomendação: Revisar exposição a ativos de alto risco");
    }
}
