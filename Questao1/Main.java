public class Main {
    public static void main(String[] args) {
        // Criar o contexto financeiro
        FinancialContext context = new FinancialContext(
                1000000.0,  // Portfolio de $1M
                0.15,       // Volatilidade de 15%
                0.95        // Confiança de 95%
        );

        // Criar o sistema de análise
        RiskAnalysisSystem system = new RiskAnalysisSystem();

        System.out.println(">   SISTEMA DE ANÁLISE DE RISCO - STRATEGY PATTERN");

        system.setStrategy(new ValueAtRisk());
        system.executeAnalysis(context);

        system.setStrategy(new ExpectedShortfall());
        system.executeAnalysis(context);

        system.setStrategy(new StressTesting());
        system.executeAnalysis(context);

        // Simular mudança de necessidade de negócio
        System.out.println("\n\n> MUDANÇA DE NECESSIDADE DE NEGÓCIO");
        System.out.println("Regulação exige análise conservadora...");
        system.setStrategy(new ValueAtRisk());
        system.executeAnalysis(context);
    }
}
