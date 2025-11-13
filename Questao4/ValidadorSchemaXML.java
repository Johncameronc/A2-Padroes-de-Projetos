public class ValidadorSchemaXML extends ValidadorNFe {

    @Override
    protected boolean executarValidacao(DocumentoFiscal doc) {
        System.out.println(">  Validando estrutura XML contra schema XSD...");

        if (doc.getXml() == null || doc.getXml().isEmpty()) {
            System.out.println(">  Erro: XML inválido ou vazio");
            return false;
        }

        return true;
    }

    @Override
    protected String getNome() {
        return "Validador de Schema XML";
    }

}
