public class MauFilho extends Filhos {

    public MauFilho() {
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
        // Golpe nos atributos pela falta de blindagem espiritual
        setSanidade(Math.max(0, getSanidade() - 30));
        setEloComOPai(Math.max(0.0f, getEloComOPai() - 0.25f));
        setCulpaAcumulada(getCulpaAcumulada() + 30);

        IO.println("       \n [Reação - Mau Filho]: 'É inútil resistir... A culpa sufoca-me e não sinto mais a luz do Pai!' \n");
        pausar(2000);
        IO.println("        [Status]: Sofreste um golpe espiritual severo (-30 Sanidade). \nSanidade atual: " + getSanidade());
        pausar(2000);
    }
}