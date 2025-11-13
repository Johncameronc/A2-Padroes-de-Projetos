public class EstadoOperacaoNormal implements EstadoUsina {
    @Override
    public void verificarCondicoes(UsinaNuclear usina, Usina contexto) {
        System.out.printf("> Estado OPERACAO_NORMAL - Temp: %.1f°C%n", contexto.getTemperatura());

        if (contexto.getTemperatura() > 300) {
            System.out.println("> ALERTA: Temperatura acima de 300°C!");
            usina.mudarEstado(new EstadoAlertaAmarelo());
        }
    }

    @Override
    public String getNomeEstado() { return "OPERACAO_NORMAL"; }
}
