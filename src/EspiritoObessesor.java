public class EspiritoObessesor extends EntidadeEspiritual implements Interagivel {
    private int diaDaSemana;

    @Override
    public void agirNoPlanoInvisivel() {

        switch (this.diaDaSemana) {
            case 1:
                ArtUtils.imprimirLento(Cores.ESPIRITO_OBSESSOR+ "       -EspiritoObssesor: Olhe esse mundo e essas regras ridiculas, pense naquela cidade que você sempre sonhou morar,toda aquela liberdade que tanto sonhou, \ntudo isto lhe darei se você se prostrar e me adorar, até porque Deus sabe que, no dia em que dele comerem, seus olhos se abrirão, e vocês serão como Deus"+Cores.VOLTARCOR,70);
                break;
            case 2:
                ArtUtils.imprimirLento(Cores.ESPIRITO_OBSESSOR+"        -EspiritoObssesor: Você é um pecador e não tem mais jeito, Deus ja desistiu da sua alma, e todos ao seu redor evitam conviver contigo por medo de serem tentados, eles sentem nojo de você"+Cores.VOLTARCOR,70);
                break;
            case 3:
                ArtUtils.imprimirLento(Cores.ESPIRITO_OBSESSOR+"        -EspiritoObssesor: Você ainda não desistiu? Está pensando mesmo que é durão e que esse tal Deus lhe salvará?Se você é o Filho de Deus, mande que estas pedras se transformem em pães"+Cores.VOLTARCOR,70);
                break;
            case 4:
                ArtUtils.imprimirLento(Cores.ESPIRITO_OBSESSOR+"        -EspiritoObssesor: Seu Pai criou o universo, mas se esqueceu de você neste buraco, ele te chama de filho, mas te deixa sangrar aqui sozinho?"+Cores.VOLTARCOR,70);
                break;
            case 5:
                ArtUtils.imprimirLento(Cores.ESPIRITO_OBSESSOR+"        -EspiritoObssesor: Chame por Ele! Grite o nome Dele! Vamos ver se as paredes deste inferno vão te ouvir!"+Cores.VOLTARCOR,70);
                ArtUtils.imprimirLento(Cores.ESPIRITO_OBSESSOR+"        -EspiritoObssesor:Olhe para você... tão fraco. Tem certeza de que foi Você o escolhido?"+Cores.VOLTARCOR,70);
                break;
            case 6:
                ArtUtils.imprimirLento(Cores.ESPIRITO_OBSESSOR+"        -EspiritoObssesor: Por que seguir o caminho estreito e doloroso se eu posso te dar as chaves do mundo agora?Seu Deus exige sacrifício. Eu só exijo a sua ambição."+Cores.VOLTARCOR,70);
                ArtUtils.imprimirLento(Cores.ESPIRITO_OBSESSOR+"        -EspiritoObssesor: Seu Deus é santo demais para olhar para uma criatura imunda como você."+Cores.VOLTARCOR,70);
                break;
            case 7:
                ArtUtils.imprimirLento(Cores.ESPIRITO_OBSESSOR+"        -EspiritoObssesor: Use o meu poder. Salve a si mesmo. Ele não vai vir te resgatar."+Cores.VOLTARCOR,70);
                ArtUtils.imprimirLento(Cores.ESPIRITO_OBSESSOR+"        -EspiritoObssesor: Lembre-se de tudo o que você já fez de errado. Você realmente acha que merece o Paraíso"+Cores.VOLTARCOR,70);
                ArtUtils.imprimirLento(Cores.ESPIRITO_OBSESSOR+"        -EspiritoObsessor: Será que Ele realmente se importa, ou você é só um peão em um jogo cósmico? "+Cores.VOLTARCOR,70);
                break;
        }
    }
    public void semearDuvida(Filhos alvo) {
        // Se o elo com o Pai for alto, o obsessor ataca com mais força
        if (alvo.getEloComOPai() > 0.5f) {
            ArtUtils.imprimirLento(Cores.NARRADOR+"        [Efeito]: A sua sanidade vacilou levemente (-0.10)..."+Cores.VOLTARCOR,70);
            alvo.statusFilho();
            ArtUtils.imprimirLento(Cores.ESPIRITO_OBSESSOR+"        -EspiritoObsessor: Não adianta pedir perdão de novo."+Cores.VOLTARCOR,70);
        } else {
            // Se a sanidade ou elo já estiverem baixos, ele acumula culpa
            alvo.setCulpaAcumulada(alvo.getCulpaAcumulada() + 15);
            ArtUtils.imprimirLento(Cores.NARRADOR+"        [Efeito]: A culpa consome a tua mente (+15 culpa acumulada)..."+Cores.VOLTARCOR,70);
            alvo.statusFilho();
            ArtUtils.imprimirLento(Cores.ESPIRITO_OBSESSOR+"        -EspiritoObsessor: Se as pessoas souberem quem você é, todos vão te abandonar."+Cores.VOLTARCOR,70);
        }
    }
    public EspiritoObessesor() {
    }


    @Override
    public boolean podeInteragir(Filhos alvo) {
        return alvo != null && alvo.isEstarVivo();        }

    @Override
    public void interagir(Filhos alvo) {
        this.diaDaSemana = alvo.getDiaDaSemana();
        agirNoPlanoInvisivel();
        semearDuvida(alvo);
        alvo.reagirATentacao();
    }

}



