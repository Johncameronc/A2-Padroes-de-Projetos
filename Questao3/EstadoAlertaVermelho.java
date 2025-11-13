public class EstadoAlertaVermelho implements EstadoUsina {
    @Override
    public void verificarCondicoes(UsinaNuclear usina, Usina contexto) {
        long tempoDecorrido = (System.currentTimeMillis() - contexto.getTempoAlertaVermelho()) / 1000;
        System.out.printf("> Estado ALERTA_VERMELHO - Temp: %.1f°C - Tempo: %ds%n",
                contexto.getTemperatura(), tempoDecorrido);

        // Regra: ALERTA_VERMELHO → EMERGENCIA se sistema de resfriamento falhar
        if (!contexto.isSistemaResfriamentoAtivo()) {
            System.out.println("> EMERGÊNCIA: Sistema de resfriamento FALHOU!");
            usina.mudarEstado(new EstadoEmergencia());
        }
        // Simulação: após 30s em alerta vermelho com temp alta
        else if (tempoDecorrido > 30 && contexto.getTemperatura() > 400) {
            System.out.println("> EMERGÊNCIA: Tempo crítico excedido!");
            usina.mudarEstado(new EstadoEmergencia());
        }
    }

    @Override
    public String getNomeEstado() { return "ALERTA_VERMELHO"; }
}
