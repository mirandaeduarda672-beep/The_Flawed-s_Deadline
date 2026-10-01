public class EspiritoBom extends EntidadeEspiritual implements Interagivel {
    private String mensagemAlento;

    public EspiritoBom() {

    }

    @Override
    public void agirNoPlanoInvisivel() {
        ArtUtils.imprimirLento(Cores.ESPIRITO_BOM+"        -[EspiritoBom]: Não temas, pois Eu sou contigo; não te assombres, porque Eu sou o teu Deus."+Cores.VOLTARCOR,70);
        ArtUtils.imprimirLento(Cores.ESPIRITO_BOM+"        -[EspiritoBom]: A graça d'Ele se aperfeiçoa nas tuas fraquezas. Levanta-te!"+Cores.VOLTARCOR,70);

    }
    public void entregarMensagemDeDeus(Filhos alvo) {
        ArtUtils.imprimirLento(Cores.ESPIRITO_BOM+"        -[EspiritoBom]: Trago-te uma palavra do Alto..."+Cores.VOLTARCOR,70);


        // Seleciona a mensagem divina com base na maior necessidade do Filho
        if (alvo.getCulpaAcumulada() >= 40) {
            ArtUtils.imprimirLento(Cores.ESPIRITO_BOM+"        -[EspiritoBom]: 'Ainda que os teus pecados sejam como a escarlata, eles se tornarão brancos como a neve. Não aceites a condenação do inimigo!'"+Cores.VOLTARCOR,70);
            alvo.setCulpaAcumulada(Math.max(0, alvo.getCulpaAcumulada() - 20));
            alvo.statusFilho();

        }
        else if (alvo.getEloComOPai() <= 0.4f) {
            ArtUtils.imprimirLento(Cores.ESPIRITO_BOM+"        -[EspiritoBom]: 'Não te deixarei, nem te desampararei. O teu Pai não se esqueceu de ti neste vale.'"+Cores.VOLTARCOR,70);
            alvo.setEloComOPai(Math.min(1.0f, alvo.getEloComOPai() + 0.20f));
            alvo.statusFilho();
            // Restaura o elo
        }
        else {
            ArtUtils.imprimirLento(Cores.ESPIRITO_BOM+"        -[EspiritoBom]: 'Sê forte e corajoso. A minha graça te basta, pois o meu poder aperfeiçoa-se na tua fraqueza!'"+Cores.VOLTARCOR,70);
            alvo.setSanidade(Math.min(100, alvo.getSanidade() + 15));
            alvo.statusFilho();
            // Restaura a sanidade
        }

        ArtUtils.imprimirLento(Cores.DEUS+"        [Graça Divina]: Sentiste uma paz inexplicável a renovar as tuas forças."+Cores.VOLTARCOR,70);

    }
    @Override
    public boolean podeInteragir(Filhos alvo) {
        return alvo != null && alvo.isEstarVivo();
    }

    @Override
    public void interagir(Filhos alvo) {
        if (podeInteragir(alvo)) {
            agirNoPlanoInvisivel();
            entregarMensagemDeDeus(alvo);
        }
    }
}