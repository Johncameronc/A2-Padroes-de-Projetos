import java.util.HashMap;

public class AdaptadorSistemaBancario implements ProcessadorTransacoes {

    private SistemaBancarioLegado sistemaLegado;

    public AdaptadorSistemaBancario(SistemaBancarioLegado sistemaLegado) {
        this.sistemaLegado = sistemaLegado;
    }

    @Override
    public String autorizar(String cartao, double valor, String moeda) {
        System.out.println("\n> Convertendo para moderno");

        HashMap<String, Object> parametrosLegado = new HashMap<>();
        parametrosLegado.put("NUMERO_CARTAO", cartao);
        parametrosLegado.put("VALOR_CENTAVOS", (long)(valor * 100)); // Converte para centavos
        parametrosLegado.put("CODIGO_MOEDA", converterCodigoMoeda(moeda)); // USD=1, EUR=2, BRL=3
        parametrosLegado.put("CODIGO_ESTABELECIMENTO", "EST001"); // Campo obrigatório do legado!

        System.out.printf("Convertido: Cartão=%s, Valor=%.2f->%d centavos, Moeda=%s->%d%n",
                cartao, valor, (long)(valor * 100), moeda, converterCodigoMoeda(moeda));

        HashMap<String, Object> respostaLegado = sistemaLegado.processarTransacao(parametrosLegado);

        // 3. Converte de legado para moderno
        return converterResposta(respostaLegado);
    }

    private int converterCodigoMoeda(String moeda) {
        return switch (moeda.toUpperCase()) {
            case "USD" -> 1;
            case "EUR" -> 2;
            case "BRL" -> 3;
            default -> throw new IllegalArgumentException("Moeda inválida: " + moeda);
        };
    }

    private String converterResposta(HashMap<String, Object> respostaLegado) {
        int status = (Integer) respostaLegado.get("STATUS");
        String mensagem = (String) respostaLegado.get("MENSAGEM");

        if (status == 1) {
            String codigo = (String) respostaLegado.get("CODIGO_AUTH");
            return "APROVADA - Código: " + codigo + " - " + mensagem;
        } else {
            return "RECUSADA - " + mensagem;
        }
    }
}
