public class EstadoDesligada implements EstadoUsina {
    @Override
    public void verificarCondicoes(UsinaNuclear usina, Usina contexto) {
        System.out.println("> Estado DESLIGADA");
    }

    @Override
    public String getNomeEstado() { return "DESLIGADA"; }
}
