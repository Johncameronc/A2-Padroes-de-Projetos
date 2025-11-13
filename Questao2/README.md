# Integração Sistema Bancário - Adapter Pattern

## Problema
Integrar sistema moderno com legado bancário que tem interface incompatível:
- Interface moderna: `autorizar(String cartao, double valor, String moeda)`
- Interface legada: `processarTransacao(HashMap<String, Object>)`
- Conversão bidirecional necessária
- Legado exige campos que não existem na interface moderna (CODIGO_ESTABELECIMENTO)

## Por que Adapter?
- Converte interface incompatível do legado para interface moderna
- Permite reutilizar sistema legado sem modificá-lo
- Traduz dados nos dois sentidos (moderno ↔ legado)

## Estrutura
```
ProcessadorTransacoes (Interface Moderna)
    ↓ implementa
AdaptadorSistemaBancario (Adapter)
    ↓ usa/adapta
SistemaBancarioLegado (Sistema existente)
```

## Fluxo
1. Cliente → Interface Moderna
2. Adapter → Converte para formato legado
3. Legado → Processa
4. Adapter → Converte resposta de volta
5. Cliente ← Recebe resposta moderna