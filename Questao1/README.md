# Sistema de Análise de Risco - Strategy Pattern

## Problema
Empresa financeira precisa calcular risco com diferentes algoritmos (VaR, Expected Shortfall, Stress Testing) que podem mudar em tempo de execução.

## Por que Strategy?
- Permite trocar algoritmos dinamicamente (`setStrategy()`)
- Cada algoritmo isolado em sua própria classe
- Cliente usa interface simples sem conhecer detalhes

## Estrutura
```
RiskAnalysisSystem (Context)
    ↓ usa
RiskStrategy (Interface)
    ↓ implementam
[ValueAtRisk] [ExpectedShortfall] [StressTesting]
```