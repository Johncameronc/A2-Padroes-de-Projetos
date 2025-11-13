# Validação de NF-e - Chain of Responsibility Pattern

## Problema
Sistema de validação de documentos fiscais eletrônicos com múltiplas regras:
- 5 validadores especializados em sequência
- Validações condicionais (alguns só executam se anteriores passarem)
- Circuit breaker após 3 falhas
- Rollback para validadores que modificam o documento

**Validadores:**
1. Schema XML
2. Certificado Digital
3. Regras Fiscais (condicional)
4. Banco de Dados (com rollback)
5. Serviço SEFAZ (condicional)

## Por que Chain of Responsibility?
- Processa requisição através de cadeia de handlers
- Cada validador decide se passa adiante ou interrompe
- Validadores independentes e desacoplados
- Fácil adicionar/remover validadores da cadeia

## Estrutura
```
SistemaValidacaoNFe
    ↓ inicia cadeia
ValidadorNFe (Handler abstrato)
    ↓ implementam
[ValidadorSchemaXML] → [ValidadorCertificado] → [ValidadorRegras] → [ValidadorBD] → [ValidadorSEFAZ]
```

## Fluxo
1. Documento entra na cadeia
2. Cada validador processa
3. Se passar: chama próximo
4. Se falhar: interrompe ou ativa rollback
5. Circuit breaker: para após 3 falhas