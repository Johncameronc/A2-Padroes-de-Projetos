public class RiskAnalysisSystem {
    private RiskStrategy strategy;

    public void setStrategy(RiskStrategy strategy) {
        this.strategy = strategy;
        System.out.println("\n>>> Estratégia alterada para: " + strategy.getClass().getSimpleName());
    }

    public void executeAnalysis(FinancialContext context) {
        if (strategy == null) {
            System.out.println("ERRO: Nenhuma estratégia definida!");
            return;
        }
        strategy.calculate(context);
    }
}
