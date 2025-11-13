import java.util.HashMap;

public class SistemaBancarioLegado {
    public HashMap<String, Object> processarTransacao(HashMap<String, Object> parametros) {
        System.out.println("\n> SISTEMA LEGADO PROCESSANDO...");
        System.out.println("Parâmetros: " + parametros);

        HashMap<String, Object> resultado = new HashMap<>();

        // Verifica campo obrigatório do legado
        if (!parametros.containsKey("CODIGO_ESTABELECIMENTO")) {
            resultado.put("STATUS", 0);
            resultado.put("MENSAGEM", "ERRO: CODIGO_ESTABELECIMENTO obrigatório");
            return resultado;
        }

        // Simula aprovação
        resultado.put("STATUS", 1);
        resultado.put("CODIGO_AUTH", "AUTH-" + System.currentTimeMillis() % 10000);
        resultado.put("MENSAGEM", "TRANSACAO APROVADA");

        System.out.println("Resultado: " + resultado);
        return resultado;
    }
}
