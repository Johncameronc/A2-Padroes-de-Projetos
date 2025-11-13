public class Usina {
    private double temperatura;
    private double pressao;
    private double nivelRadiacao;
    private boolean sistemaResfriamentoAtivo;
    private long tempoAlertaVermelho;

    public Usina() {
        this.temperatura = 25.0;
        this.pressao = 1.0;
        this.nivelRadiacao = 0.1;
        this.sistemaResfriamentoAtivo = true;
        this.tempoAlertaVermelho = 0;
    }

    public double getTemperatura() { return temperatura; }
    public void setTemperatura(double temp) { this.temperatura = temp; }

    public double getPressao() { return pressao; }
    public void setPressao(double p) { this.pressao = p; }

    public double getNivelRadiacao() { return nivelRadiacao; }
    public void setNivelRadiacao(double rad) { this.nivelRadiacao = rad; }

    public boolean isSistemaResfriamentoAtivo() { return sistemaResfriamentoAtivo; }
    public void setSistemaResfriamentoAtivo(boolean ativo) { this.sistemaResfriamentoAtivo = ativo; }

    public long getTempoAlertaVermelho() { return tempoAlertaVermelho; }
    public void setTempoAlertaVermelho(long tempo) { this.tempoAlertaVermelho = tempo; }
}
