public class ValidadorCertificadoDigital extends ValidadorNFe {
    @Override
    protected boolean executarValidacao(DocumentoFiscal doc) {
        System.out.println(">  Verificando expiração e revogação do certificado...");

        if (doc.getCertificado() == null || doc.getCertificado().equals("EXPIRADO")) {
            System.out.println(">  Erro: Certificado expirado ou inválido");
            return false;
        }

        return true;
    }

    @Override
    protected String getNome() {
        return "Validador de Certificado Digital";
    }
}
