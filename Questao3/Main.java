public class Main {
    public static void main(String[] args) {
        System.out.println("> CONTROLE DE USINA NUCLEAR");

        UsinaNuclear usina = new UsinaNuclear();

        System.out.println("\n> Ligar Usina");
        usina.ligar();
        usina.verificarSistema();

        System.out.println("\n> Temperatura Subindo");
        usina.getContexto().setTemperatura(350);
        usina.verificarSistema();

        System.out.println("\n> Temperatura Crítica");
        usina.getContexto().setTemperatura(450);
        usina.verificarSistema();

        System.out.println("\n> Sistema de Resfriamento Falhou");
        usina.getContexto().setSistemaResfriamentoAtivo(false);
        usina.verificarSistema();

        System.out.println("\n> Tentativa de Transição Inválida");
        UsinaNuclear usina2 = new UsinaNuclear();
        usina2.ligar();
        usina2.mudarEstado(new EstadoEmergencia());

        System.out.println("\n> Modo Manutenção");
        UsinaNuclear usina3 = new UsinaNuclear();
        usina3.ligar();
        usina3.getContexto().setTemperatura(500);
        usina3.ativarModoManutencao();
        usina3.verificarSistema();
        usina3.desativarModoManutencao();
        usina3.verificarSistema();
    }
}
