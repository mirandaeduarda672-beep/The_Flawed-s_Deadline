public class MornoFilho extends Filhos {

    public MornoFilho() {
        super(Cores.MORNO_FILHO);
    }

    @Override
    public void reagirATentacao() {
        // Desgaste moderado (meio-termo entre o BomFilho e o MauFilho)
        setSanidade(Math.max(0, getSanidade() - 15));
        setEloComOPai(Math.max(0.0f, getEloComOPai() - 0.15f));
        setCulpaAcumulada(getCulpaAcumulada() + 15);

       falar("       [Reação - Morno Filho]: A dúvida toma conta da tua mente... Hesitas e a tua paz esvai-se. \n");
        ArtUtils.imprimirLento(Cores.MENU+"        [Status]: Perdeu 15 de Sanidade.\n Sanidade atual: " + getSanidade()+Cores.VOLTARCOR,70);

    }
}