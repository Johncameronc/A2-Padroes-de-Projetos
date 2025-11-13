public class EstadoManutencao implements EstadoUsina {
    @Override
    public void verificarCondicoes(UsinaNuclear usina, Usina contexto) {
        System.out.println("> Estado MANUTENCAO");
        System.out.println("Modo manual ativo | Operador tem controle total");
    }

    @Override
    public String getNomeEstado() { return "MANUTENCAO"; }
}
