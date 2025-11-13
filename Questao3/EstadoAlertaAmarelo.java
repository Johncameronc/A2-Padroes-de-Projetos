public class EstadoAlertaAmarelo implements EstadoUsina {
    @Override
    public void verificarCondicoes(UsinaNuclear usina, Usina contexto) {
        System.out.printf("> Estado ALERTA_AMARELO - Temp: %.1f°C%n", contexto.getTemperatura());

        if (contexto.getTemperatura() > 400) {
            System.out.println("> ALERTA: Temperatura crítica acima de 400°C!");
            contexto.setTempoAlertaVermelho(System.currentTimeMillis());
            usina.mudarEstado(new EstadoAlertaVermelho());
        }
        else if (contexto.getTemperatura() <= 300) {
            System.out.println("> Temperatura normalizada. Voltando para operação normal.");
            usina.mudarEstado(new EstadoOperacaoNormal());
        }
    }

    @Override
    public String getNomeEstado() { return "ALERTA_AMARELO"; }
}
