public class ValidadorBancoDados extends ValidadorNFe {
    @Override
    protected boolean executarValidacao(DocumentoFiscal doc) {
        System.out.println("> Consultando banco de dados...");
        System.out.println("> Verificando duplicidade de número: " + doc.getNumeroNFe());

        // Simula inserção no banco
        doc.setInseridoBancoDados(true);
        System.out.println("> Documento inserido no banco de dados");

        return true;
    }

    @Override
    protected String getNome() {
        return "Validador de Banco de Dados";
    }

    @Override
    protected boolean necessitaRollback() {
        return true;
    }

    @Override
    protected void fazerRollback(DocumentoFiscal doc) {
        if (doc.isInseridoBancoDados()) {
            System.out.println("> ROLLBACK: Removendo documento do banco de dados");
            doc.setInseridoBancoDados(false);
        }
    }
}
