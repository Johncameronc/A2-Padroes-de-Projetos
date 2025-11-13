public class Validacao {
    private int falhasConsecutivas;
    private static final int MAX_FALHAS = 3;

    public Validacao() {
        this.falhasConsecutivas = 0;
    }

    public void registrarFalha() {
        falhasConsecutivas++;
    }

    public boolean circuitBreakerAtivado() {
        return falhasConsecutivas >= MAX_FALHAS;
    }

    public int getFalhasConsecutivas() {
        return falhasConsecutivas;
    }
}
