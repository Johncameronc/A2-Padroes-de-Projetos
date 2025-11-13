public class ValidadorServicoSEFAZ extends ValidadorNFe {
    @Override
    protected boolean executarValidacao(DocumentoFiscal doc) {
        System.out.println("> Consultando serviço online da SEFAZ...");
        System.out.println("> Aguardando resposta do webservice...");

        // Simulação de timeout ou falha
        try {
            Thread.sleep(500); // Simula latência
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("> SEFAZ retornou: Documento autorizado");
        return true;
    }

    @Override
    protected String getNome() {
        return "Validador de Serviço SEFAZ";
    }
}
