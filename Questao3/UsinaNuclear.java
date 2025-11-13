public class UsinaNuclear {
    private EstadoUsina estadoAtual;
    private Usina contexto;
    private boolean modoManutencao;

    public UsinaNuclear() {
        this.estadoAtual = new EstadoDesligada();
        this.contexto = new Usina();
        this.modoManutencao = false;
    }

    public void mudarEstado(EstadoUsina novoEstado) {
        System.out.println("\n▶ TRANSIÇÃO: " + estadoAtual.getNomeEstado() +
                " → " + novoEstado.getNomeEstado());

        // Validação: EMERGENCIA só pode vir de ALERTA_VERMELHO
        if (novoEstado instanceof EstadoEmergencia &&
                !(estadoAtual instanceof EstadoAlertaVermelho)) {
            System.out.println("> TRANSIÇÃO BLOQUEADA: Emergência só pode ser ativada após Alerta Vermelho!");
            return;
        }

        this.estadoAtual = novoEstado;
    }

    public void verificarSistema() {
        if (modoManutencao) {
            new EstadoManutencao().verificarCondicoes(this, contexto);
        } else {
            estadoAtual.verificarCondicoes(this, contexto);
        }
    }

    public void ligar() {
        if (estadoAtual instanceof EstadoDesligada) {
            mudarEstado(new EstadoOperacaoNormal());
        }
    }

    public void ativarModoManutencao() {
        System.out.println("\n> MODO MANUTENÇÃO ATIVADO");
        modoManutencao = true;
    }

    public void desativarModoManutencao() {
        System.out.println("\n> MODO MANUTENÇÃO DESATIVADO");
        modoManutencao = false;
    }

    public Usina getContexto() { return contexto; }
    public EstadoUsina getEstadoAtual() { return estadoAtual; }
}
