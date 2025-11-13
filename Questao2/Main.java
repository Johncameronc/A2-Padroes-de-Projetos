public class Main {
    public static void main(String[] args) {
        System.out.println("> INTEGRAÇÃO BANCÁRIA - ADAPTER PATTERN");

        // Sistema legado
        SistemaBancarioLegado legado = new SistemaBancarioLegado();

        // Adapter que faz a ponte
        ProcessadorTransacoes processador = new AdaptadorSistemaBancario(legado);

        // Cliente usa interface MODERNA (simples e limpa)
        System.out.println("\n> TRANSAÇÃO 1");
        String resultado1 = processador.autorizar("1234-5678-9012-3456", 150.50, "USD");
        System.out.println("\n> Resposta para o cliente: " + resultado1);

        System.out.println("\n> TRANSAÇÃO 2");
        String resultado2 = processador.autorizar("9876-5432-1098-7654", 89.90, "BRL");
        System.out.println("\n> Resposta para o cliente: " + resultado2);

        System.out.println("\n> TRANSAÇÃO 3");
        String resultado3 = processador.autorizar("1111-2222-3333-4444", 250.00, "EUR");
        System.out.println("\n> Resposta para o cliente: " + resultado3);
    }
}
