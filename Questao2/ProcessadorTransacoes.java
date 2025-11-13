public interface ProcessadorTransacoes {
    String autorizar(String cartao, double valor, String moeda);
}
