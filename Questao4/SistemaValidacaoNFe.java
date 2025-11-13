public class SistemaValidacaoNFe {
    private ValidadorNFe cadeiaValidadores;

    public SistemaValidacaoNFe() {
        ValidadorNFe v1 = new ValidadorSchemaXML();
        ValidadorNFe v2 = new ValidadorCertificadoDigital();
        ValidadorNFe v3 = new ValidadorRegrasFiscais();
        ValidadorNFe v4 = new ValidadorBancoDados();
        ValidadorNFe v5 = new ValidadorServicoSEFAZ();

        v1.setProximo(v2);
        v2.setProximo(v3);
        v3.setProximo(v4);
        v4.setProximo(v5);

        cadeiaValidadores = v1;
    }

    public boolean validarDocumento(DocumentoFiscal doc) {
        Validacao contexto = new Validacao();

        System.out.println("> INICIANDO VALIDAÇÃO DE NF-e");
        System.out.println("> Número: " + doc.getNumeroNFe());

        boolean resultado = cadeiaValidadores.validar(doc, contexto);

        System.out.println("\n" + "=".repeat(50));
        if (resultado) {
            System.out.println("> DOCUMENTO VÁLIDO - Todos os validadores passaram");
        } else {
            System.out.println("> DOCUMENTO INVÁLIDO - Validação falhou");
        }
        System.out.println("=".repeat(50));

        return resultado;
    }
}
