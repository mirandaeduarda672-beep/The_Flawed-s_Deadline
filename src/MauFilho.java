public class MauFilho extends Filhos {

    public MauFilho() {
        super(Cores.MAU_FILHO);
    }


    @Override
    public void reagirATentacao() {
        // Golpe nos atributos pela falta de blindagem espiritual
        setSanidade(Math.max(0, getSanidade() - 30));
        setEloComOPai(Math.max(0.0f, getEloComOPai() - 0.25f));
        setCulpaAcumulada(getCulpaAcumulada() + 30);

        falar("        [Reação - Mau Filho]: 'É inútil resistir... A culpa sufoca-me e não sinto mais a luz do Pai!' \n");
        ArtUtils.imprimirLento(Cores.MENU+"        [Status]: Sofreste um golpe espiritual severo (-30 Sanidade). \nSanidade atual: " + getSanidade()+Cores.VOLTARCOR,70);
    }
}