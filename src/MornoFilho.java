public class MornoFilho extends Filhos {

    public MornoFilho() {
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
        // Desgaste moderado (meio-termo entre o BomFilho e o MauFilho)
        setSanidade(Math.max(0, getSanidade() - 15));
        setEloComOPai(Math.max(0.0f, getEloComOPai() - 0.15f));
        setCulpaAcumulada(getCulpaAcumulada() + 15);

        IO.println("      \n  [Reação - Morno Filho]: A dúvida toma conta da tua mente... Hesitas e a tua paz esvai-se. \n");
        pausar(2000);
        IO.println("        [Status]: Perdeu 15 de Sanidade.\n Sanidade atual: " + getSanidade());
        pausar(2000);
    }
}