public class EspiritoObessesor extends EntidadeEspiritual implements Interagivel {
    private int diaDaSemana;

    private void pausar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            System.out.println("A pausa foi interrompida!");
        }
    }
    @Override
    public void agirNoPlanoInvisivel() {

        switch (this.diaDaSemana) {
            case 1:
                IO.println( "       -EspiritoObssesor: Olhe esse mundo e essas regras ridiculas, pense naquela cidade que você sempre sonhou morar, toda aquela liberdade que tanto sonhou, tudo isto lhe darei se você se prostrar e me adorar, até porque Deus sabe que, no dia em que dele comerem, seus olhos se abrirão, e vocês serão como Deus");
                pausar(5000);
                break;
            case 2:
                IO.println("        -EspiritoObssesor: Você é um pecador e não tem mais jeito, Deus ja desistiu da sua alma, e todos ao seu redor evitam conviver contigo por medo de serem tentados, eles sentem nojo de você");
                pausar(5000);
                break;
            case 3:
                IO.println("        -EspiritoObssesor: Você ainda não desistiu? Está pensando mesmo que é durão e que esse tal Deus lhe salvará?Se você é o Filho de Deus, mande que estas pedras se transformem em pães");
                pausar(5000);
                break;
            case 4:
                IO.println("        -EspiritoObssesor: Seu Pai criou o universo, mas se esqueceu de você neste buraco, ele te chama de filho, mas te deixa sangrar aqui sozinho?");
                pausar(5000);
                break;
            case 5:
                IO.println("        -EspiritoObssesor: Chame por Ele! Grite o nome Dele! Vamos ver se as paredes deste inferno vão te ouvir!");
                IO.println("\n");
                pausar(5000);
                IO.println("        -EspiritoObssesor:Olhe para você... tão fraco. Tem certeza de que foi Você o escolhido?");
                pausar(5000);
                break;
            case 6:
                IO.println("        -EspiritoObssesor: Por que seguir o caminho estreito e doloroso se eu posso te dar as chaves do mundo agora?Seu Deus exige sacrifício. Eu só exijo a sua ambição.");
                IO.println("\n");
                pausar(5000);
                IO.println("        -EspiritoObssesor: Seu Deus é santo demais para olhar para uma criatura imunda como você.");
                pausar(5000);
                break;
            case 7:
                IO.println("        -EspiritoObssesor: Use o meu poder. Salve a si mesmo. Ele não vai vir te resgatar.");
                IO.println("\n");
                pausar(5000);
                IO.println("        -EspiritoObssesor: Lembre-se de tudo o que você já fez de errado. Você realmente acha que merece o Paraíso");
                IO.println("\n");
                pausar(5000);
                IO.println("        -EspiritoObsessor: Será que Ele realmente se importa, ou você é só um peão em um jogo cósmico? ");
                pausar(5000);
                break;
        }
    }
    public void semearDuvida(Filhos alvo) {
        // Se o elo com o Pai for alto, o obsessor ataca com mais força
        if (alvo.getEloComOPai() > 0.5f) {
            alvo.statusFilho();
            IO.println("        [Efeito]: A sua sanidade vacilou levemente (-0.10)...");
            alvo.statusFilho();
            IO.println("\n");
            pausar(5000);
            IO.println("        -EspiritoObsessor: Não adianta pedir perdão de novo.");
            pausar(5000);
        } else {
            // Se a sanidade ou elo já estiverem baixos, ele acumula culpa
            alvo.setCulpaAcumulada(alvo.getCulpaAcumulada() + 15);
            IO.println("        [Efeito]: A culpa consome a tua mente (+15 culpa acumulada)...");
            alvo.statusFilho();
            IO.println("\n");
            pausar(5000);
            IO.println("        -EspiritoObsessor: Se as pessoas souberem quem você é, todos vão te abandonar.");
            pausar(5000);

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



