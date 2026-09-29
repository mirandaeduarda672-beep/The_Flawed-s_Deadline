public class BomFilho extends Filhos {


    public BomFilho() {
        super();
    }

    private void pausar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            System.out.println("A pausa foi interrompida!");
        }
    }

    @Override
    public void reagirATentacao() {
        int sanidadeAtual = getSanidade();
        setSanidade(Math.max(0, sanidadeAtual - 5)); // Perde apenas 5 de sanidade

        IO.println("        [Reação - Bom Filho]: O meu coração vacila por um instante, mas a minha fé permanece firme.");
        IO.println("\n");
        pausar(2000);
        IO.println("\n");
        IO.println("        [Status]: Perdeu 5 de Sanidade. \n "+statusFilho()
        );
        IO.println("\n");
        pausar(2000);
    }
}