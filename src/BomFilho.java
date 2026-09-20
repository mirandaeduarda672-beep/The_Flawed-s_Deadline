public class BomFilho extends Filhos {


    public BomFilho(String nome, int idade, int sanidade, float eloComOPai, int diaDaSemana, boolean estarVivo, int culpaAcumulada) {
        super(nome, idade, sanidade, eloComOPai, diaDaSemana, estarVivo, culpaAcumulada);
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
        pausar(1000);
        IO.println("        [Status]: Perdeu 5 de Sanidade. Sanidade atual: " + getSanidade());
        pausar(1000);
    }
}