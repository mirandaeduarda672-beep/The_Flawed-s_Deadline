import java.util.Scanner;

public class Main {
    //Método criado para dar um tempo entre as frases
    private static void pausar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            System.out.println("A pausa foi interrompida!");
        }
    }

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

        IO.println("\n");
        IO.println("==========================================");
        IO.println("   BEM-VINDOS À PROVAÇÃO DOS 7 DIAS!   ");
        IO.println("==========================================");
        pausar(1000);

        // 4. Seleção do Filho para jogar nesta partida
        IO.println("\n");
        IO.println("Escolha qual dos filhos você deseja guiar na provação:");
        IO.println("\n");
        for (int i = 0; i < deus.getListaFilhos().size(); i++) {
            Filhos f = deus.getListaFilhos().get(i);
            IO.println((i + 1) + " - " + f.getNome() + " (" + f.getClass().getSimpleName() + ", " + f.getIdade() + " anos)");
        }
        System.out.print("Opção: ");
        //O menos 1 seria para o codigo ficar mais fiel ao Arraylist, que vai do 0 ao 5

        int escolha = scanner.nextInt() - 1;

        // Validação da escolha do jogador
        if (escolha < 0 || escolha >= deus.getListaFilhos().size()) {
            escolha = 0; // Padrão para Marina se a opção for inválida
        }

        Filhos jogador = deus.getListaFilhos().get(escolha);
        IO.println("\nVocê assumiu o destino de " + jogador.getNome() + "!\n");
        pausar(1500);

        // 5. Loop dos 7 Dias de Provação
        for (int dia = 1; dia <= 7; dia++) {
            if (!jogador.isEstarVivo() || jogador.getSanidade() <= 0) {
                IO.println("\n[FIM DE JOGO]: A mente de " + jogador.getNome() + " não suportou a pressão espiritual.");
                break;
            }

            jogador.setDiaDaSemana(dia);
            IO.println("\n==========================================");
            IO.println("                DIA " + dia + " DE 7");
            IO.println("==========================================");
            jogador.statusFilho();
            pausar(3000);

            // A) Ataque do Obsessor
            IO.println("\n--- [Ataque Espiritual] ---");
            obessesor.interagir(jogador);
            pausar(5000);
            IO.println("        [Efeito]: A sua sanidade vacilou levemente (10)...");
            jogador.setSanidade(Math.max(0, jogador.getSanidade() - 10));
            jogador.statusFilho();
            pausar(5000);


            if (jogador.getSanidade() <= 0) {
                IO.println("\n[FIM DE JOGO]: " + jogador.getNome() + " sucumbiu ao desespero.");
                jogador.setEstarVivo(false);
                break;
            }

            // B) Menu de Ação do Jogador
            IO.println("\n--- [Sua Decisão] ---");
            IO.println("1 - Orar (Aumenta o Elo com o Pai)");
            IO.println("2 - Confessar Pecados (Deus perdoa a Culpa)");
            IO.println("3 - Clamar por Socorro (Recebe a visita do Anjo)");
            IO.println("4 - Pecar / Dar ouvidos ao Obsessor (Alívio imediato, mas acumula Culpa)");
            System.out.print("Escolha: ");
            int acao = scanner.nextInt();

            IO.println("");
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
            pausar(4000);
        }

        // 6. Encerramento / Juízo Final
        IO.println("\n");
        IO.println("\n==========================================");
        IO.println("              JUÍZO FINAL");
        IO.println("==========================================");

        if (jogador.isEstarVivo() && jogador.getSanidade() > 0) {
            IO.println(jogador.getNome() + " atravessou os 7 dias de provação!");
            deus.aplicarConsequencia(jogador);
        }pausar(4000);

        IO.println("\n==========================================");
        IO.println("              GAME OVER");
        IO.println("==========================================");

        scanner.close();
    }
}