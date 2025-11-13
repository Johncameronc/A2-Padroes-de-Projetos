public class Main {
    public static void main(String[] args) {
        SistemaValidacaoNFe sistema = new SistemaValidacaoNFe();

        System.out.println("\n> CENÁRIO 1: Documento Válido ###\n");
        DocumentoFiscal doc1 = new DocumentoFiscal(
                "NFe-12345",
                "<xml>...</xml>",
                "CERT-VALIDO-2025",
                1000.00
        );
        sistema.validarDocumento(doc1);

        System.out.println("\n\n> CENÁRIO 2: Certificado Expirado ###\n");
        DocumentoFiscal doc2 = new DocumentoFiscal(
                "NFe-67890",
                "<xml>...</xml>",
                "EXPIRADO",
                1500.00
        );
        sistema.validarDocumento(doc2);

        System.out.println("\n\n> CENÁRIO 3: XML Inválido ###\n");
        DocumentoFiscal doc3 = new DocumentoFiscal(
                "NFe-99999",
                "", // XML vazio
                "CERT-VALIDO-2025",
                2000.00
        );
        sistema.validarDocumento(doc3);
    }
}
