public class EstadoEmergencia implements EstadoUsina {
    @Override
    public void verificarCondicoes(UsinaNuclear usina, Usina contexto) {
        System.out.println("> Estado EMERGENCIA");
        System.out.println("> EVACUAÇÃO IMEDIATA! DESLIGAMENTO AUTOMÁTICO!");
    }

    @Override
    public String getNomeEstado() { return "EMERGENCIA"; }
}
