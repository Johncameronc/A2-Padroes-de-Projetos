# Controle de Usina Nuclear - State Pattern

## Problema
Sistema de controle para usina nuclear com estados complexos:
- Estados: DESLIGADA, OPERACAO_NORMAL, ALERTA_AMARELO, ALERTA_VERMELHO, EMERGENCIA
- Transições com validações complexas (temperatura, pressão, radiação)
- Algumas transições bidirecionais, outras unidirecionais
- EMERGENCIA só após ALERTA_VERMELHO
- Modo manutenção que suspende estados normais

## Por que State?
- Cada estado encapsula seu próprio comportamento
- Evita condicionais gigantes (if/else) para gerenciar estados
- Transições controladas e validadas
- Cada estado conhece suas regras de quando transicionar

## Estrutura
```
UsinaNuclear (Context)
    ↓ mantém
EstadoUsina (Interface)
    ↓ implementam
[Desligada] [OperacaoNormal] [AlertaAmarelo] [AlertaVermelho] [Emergencia] [Manutencao]
```

## Transições
- OPERACAO_NORMAL → ALERTA_AMARELO (temp > 300°C)
- ALERTA_AMARELO → ALERTA_VERMELHO (temp > 400°C)
- ALERTA_VERMELHO → EMERGENCIA (sistema resfriamento falha)