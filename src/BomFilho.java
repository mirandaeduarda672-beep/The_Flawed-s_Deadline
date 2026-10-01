public class BomFilho extends Filhos {


    public BomFilho() {
        super(Cores.BOM_FILHO);
    }


    @Override
    public void reagirATentacao() {
        int sanidadeAtual = getSanidade();
        setSanidade(Math.max(0, sanidadeAtual - 5)); // Perde apenas 5 de sanidade

        ArtUtils.imprimirLento(Cores.BOM_FILHO+"        [Reação - Bom Filho]: O meu coração vacila por um instante, mas a minha fé permanece firme."+Cores.VOLTARCOR,70);
        ArtUtils.imprimirLento(Cores.BOM_FILHO+"        [Status]: Perdeu 5 de Sanidade. \n "+statusFilho()+Cores.VOLTARCOR,70
        );

    }
}