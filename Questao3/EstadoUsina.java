public interface EstadoUsina {
    void verificarCondicoes(UsinaNuclear usina, Usina contexto);
    String getNomeEstado();
}
