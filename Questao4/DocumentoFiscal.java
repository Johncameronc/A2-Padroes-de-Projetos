public class DocumentoFiscal {
    private String numeroNFe;
    private String xml;
    private String certificado;
    private double valorTotal;
    private boolean inseridoBancoDados;

    public DocumentoFiscal(String numeroNFe, String xml, String certificado, double valorTotal) {
        this.numeroNFe = numeroNFe;
        this.xml = xml;
        this.certificado = certificado;
        this.valorTotal = valorTotal;
        this.inseridoBancoDados = false;
    }

    public String getNumeroNFe() { return numeroNFe; }
    public String getXml() { return xml; }
    public String getCertificado() { return certificado; }
    public double getValorTotal() { return valorTotal; }
    public boolean isInseridoBancoDados() { return inseridoBancoDados; }
    public void setInseridoBancoDados(boolean inserido) { this.inseridoBancoDados = inserido; }
}
