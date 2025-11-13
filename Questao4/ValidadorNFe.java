public abstract class ValidadorNFe {
    protected ValidadorNFe proximoValidador;

    public void setProximo(ValidadorNFe proximo) {
        this.proximoValidador = proximo;
    }

    public final boolean validar(DocumentoFiscal doc, Validacao contexto) {
        // Circuit Breaker: interrompe após 3 falhas
        if (contexto.circuitBreakerAtivado()) {
            System.out.println("> CIRCUIT BREAKER ATIVADO! Validação interrompida.");
            return false;
        }

        System.out.println("\n▶ Executando: " + getNome());

        boolean sucesso = executarValidacao(doc);

        if (!sucesso) {
            contexto.registrarFalha();
            System.out.println("> FALHOU - Falhas consecutivas: " + contexto.getFalhasConsecutivas());

            if (necessitaRollback()) {
                fazerRollback(doc);
            }

            return false;
        }

        System.out.println("> PASSOU");

        // Passa para o próximo validador na cadeia
        if (proximoValidador != null) {
            return proximoValidador.validar(doc, contexto);
        }

        return true;
    }

    protected abstract boolean executarValidacao(DocumentoFiscal doc);
    protected abstract String getNome();

    protected boolean necessitaRollback() {
        return false;
    }

    protected void fazerRollback(DocumentoFiscal doc) {
        // Override em validadores que precisam
    }
}
