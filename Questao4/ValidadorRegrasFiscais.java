public class ValidadorRegrasFiscais extends ValidadorNFe {
    @Override
    protected boolean executarValidacao(DocumentoFiscal doc) {
        System.out.println(">  Validando cálculos de ICMS, IPI, PIS, COFINS...");

        if (doc.getValorTotal() <= 0) {
            System.out.println(">  Erro: Valor total inválido");
            return false;
        }

        double impostoCalculado = doc.getValorTotal() * 0.18;
        System.out.printf(">  Imposto calculado: R$ %.2f%n", impostoCalculado);

        return true;
    }

    @Override
    protected String getNome() {
        return "Validador de Regras Fiscais";
    }
}
