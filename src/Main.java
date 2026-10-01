import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Instanciação das Entidades Espirituais Principais
        Deus deus = new Deus();
        deus.setNome("Senhor Deus");
        deus.setNivelForca(10000);

        EspiritoObessesor obessesor = new EspiritoObessesor();
        obessesor.setNivelForca(10);
        obessesor.setNome("Acusador");

        EspiritoBom anjo = new EspiritoBom();
        anjo.setNivelForca(10);
        obessesor.setNome("Anjo de Luz");

        // 3. Adiciona os Filhos à lista gerida por Deus (Composição)
        Filhos f1 = deus.gerarFilho("bom", "Marina", 17);
        Filhos f2 = deus.gerarFilho("bom", "Miguel Alves", 18);
        Filhos f3 = deus.gerarFilho("mau", "André", 19);
        Filhos f4 = deus.gerarFilho("mau", "Rafael", 20);
        Filhos f5 = deus.gerarFilho("morno", "Manuelle", 21);
        Filhos f6 = deus.gerarFilho("morno", "Miranda", 21);


        ArtUtils.imprimirLento(Cores.TITULO+"   BEM-VINDOS À PROVAÇÃO DOS 7 DIAS!"+Cores.VOLTARCOR,70);


        // 4. Seleção do Filho para jogar nesta partida
        ArtUtils.imprimirLento(Cores.NARRADOR3+"Escolha qual dos filhos você deseja guiar na provação:"+Cores.VOLTARCOR,70);
        for (int i = 0; i < deus.getListaFilhos().size(); i++) {
            Filhos f = deus.getListaFilhos().get(i);
            System.out.println(Cores.MENU);
            ArtUtils.imprimirLento((i + 1) + " - " + f.getNome() + " (" + f.getClass().getSimpleName() + ", " + f.getIdade() + " anos)",70);
            System.out.println(Cores.VOLTARCOR);
        }
        ArtUtils.imprimirLento(Cores.PROMPT+"Opção: "+Cores.VOLTARCOR,70);

        //O menos 1 seria para o codigo ficar mais fiel ao Arraylist, que vai do 0 ao 5
        int escolha = scanner.nextInt() - 1;

        // Validação da escolha do jogador
        if (escolha < 0 || escolha >= deus.getListaFilhos().size()) {
            escolha = 0; // Padrão para Marina se a opção for inválida
        }

        Filhos jogador = deus.getListaFilhos().get(escolha);
        ArtUtils.imprimirLento(Cores.NARRADOR+"Você assumiu o destino de " + jogador.getNome() + "!"+Cores.VOLTARCOR,70);

        // 5. Loop dos 7 Dias de Provação
        for (int dia = 1; dia <= 7; dia++) {
            if (!jogador.isEstarVivo() || jogador.getSanidade() <= 0) {
                ArtUtils.imprimirLento(Cores.MENU+"[FIM DE JOGO]: A mente de " + jogador.getNome() + " não suportou a pressão espiritual."+Cores.VOLTARCOR,70);
                break;
            }

            jogador.setDiaDaSemana(dia);
            IO.println(Cores.MENU+"==========================================");
            ArtUtils.imprimirLento("                DIA " + dia + " DE 7",70);
            IO.println("=========================================="+Cores.VOLTARCOR);
            jogador.statusFilho();

            // A) Ataque do Obsessor
            ArtUtils.imprimirLento(Cores.ESPIRITO_OBSESSOR+"--- [Ataque Espiritual] ---"+Cores.VOLTARCOR,70);
            obessesor.interagir(jogador);
            ArtUtils.imprimirLento(Cores.NARRADOR+"        [Efeito]: A sua sanidade vacilou levemente (10)..."+Cores.VOLTARCOR,70);
            jogador.setSanidade(Math.max(0, jogador.getSanidade() - 10));
            jogador.statusFilho();


            if (jogador.getSanidade() <= 0) {
                ArtUtils.imprimirLento(Cores.MENU+"[FIM DE JOGO]: " + jogador.getNome() + " sucumbiu ao desespero."+Cores.VOLTARCOR,70);
                jogador.setEstarVivo(false);
                break;
            }

            // B) Menu de Ação do Jogador
            ArtUtils.imprimirLento(Cores.NARRADOR+"--- [Sua Decisão] ---"+Cores.VOLTARCOR,20);
            ArtUtils.imprimirLento(Cores.MENU+"1 - Orar (Aumenta o Elo com o Pai)",20);
            ArtUtils.imprimirLento("2 - Confessar Pecados (Deus perdoa a Culpa)",20);
            ArtUtils.imprimirLento("3 - Clamar por Socorro (Recebe a visita do Anjo)",20);
            ArtUtils.imprimirLento("4 - Pecar / Dar ouvidos ao Obsessor (Alívio imediato, mas acumula Culpa)",20);
            ArtUtils.imprimirLento("Escolha: "+Cores.VOLTARCOR,70);

            System.out.print(Cores.DEUS);
            int acao = scanner.nextInt();
            System.out.print(Cores.VOLTARCOR);
            System.out.println();

            switch (acao) {
                case 1:
                    jogador.orar(deus);
                    break;
                case 2:
                    deus.perdoarCulpa(jogador);
                    break;
                case 3:
                    anjo.interagir(jogador);
                    break;
                case 4:
                    jogador.pecar();
                    break;
                default:
                    IO.println("\n");
                    IO.println("Ficaste imóvel diante da tentação...");
                    break;
            }

        }

        // 6. Encerramento / Juízo Final

        ArtUtils.imprimirLento(Cores.TITULO+"              JUÍZO FINAL"+Cores.VOLTARCOR,70);

        if (jogador.isEstarVivo() && jogador.getSanidade() > 0) {
           ArtUtils.imprimirLento(Cores.DEUS+jogador.getNome() + "             Você atravessou os 7 dias de provação!"+Cores.VOLTARCOR,70);
            deus.aplicarConsequencia(jogador);
        }
        else {

        ArtUtils.imprimirLento(Cores.MAU_FILHO+"              GAME OVER"+Cores.VOLTARCOR,70);

        scanner.close();
    }
}}