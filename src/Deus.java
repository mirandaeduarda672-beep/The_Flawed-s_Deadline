import java.util.ArrayList;
import java.util.List;

public class Deus extends EntidadeEspiritual {
    // Composição: Deus mantém e gere a existência da lista de Filhos (1..*)
    private List<Filhos> listaFilhos;

    public Deus(String nome, int nivelForca) {
        super(nome, nivelForca);
        this.listaFilhos = new ArrayList<>();
    }

    private void pausar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            System.out.println("A pausa foi interrompida!");
        }
    }

    // Adiciona um Filho à composição divina
    public void adicionarFilho(Filhos filho) {
        if (filho != null) {
            this.listaFilhos.add(filho);
        }
    }

    @Override
    public void agirNoPlanoInvisivel() {
        IO.println("        -[Deus]: Eu sou o Alfa e o Ômega, o Princípio e o Fim.");
        pausar(1000);
    }

    // Chama o Filho para um momento de ajuste espiritual ou provação
    public void chamarFilho(Filhos alvo) {
        if (alvo != null && alvo.isEstarVivo()) {
            IO.println("        -[Deus]: " + alvo.getNome() + ", dá-me o teu coração e observa os Meus caminhos.");
            pausar(1000);
        }
    }

    // Zera ou reduz drasticamente a culpa acumulada após confissão/oração
    public void perdoarCulpa(Filhos alvo) {
        if (alvo != null && alvo.isEstarVivo()) {
            alvo.setCulpaAcumulada(0);
            float eloAtual = alvo.getEloComOPai();
            alvo.setEloComOPai(Math.min(1.0f, eloAtual + 0.30f)); // Restaura forte o elo

            IO.println("        -[Deus]: VAI EM PAZ. Os teus pecados foram perdoados.");
            pausar(1000);
            IO.println("        [Intervenção Divina]: Toda a culpa foi removida e o teu Elo com o Pai subiu significativamente!");
            pausar(1000);
        }
    }

    // Aplica o julgamento com base na negligência do Filho
    public void aplicarConsequencia(Filhos alvo) {
        if (alvo != null && alvo.isEstarVivo()) {
            if (alvo.getCulpaAcumulada() >= 70 || alvo.getEloComOPai() <= 0.1f) {
                IO.println("        -[Deus]: Deus não se deixa escarnecer; pois aquilo que o homem semear, isso também ceifará.");
                pausar(1000);

                // Consequência severa: perda de sanidade por disciplina espiritual
                int novaSanidade = Math.max(0, alvo.getSanidade() - 25);
                alvo.setSanidade(novaSanidade);

                IO.println("        [Disciplina Divina]: A ausência da luz trouxe peso sobre o teu espírito (-25 Sanidade)!");
                pausar(1000);
            } else {
                IO.println("        -[Deus]: Muito bem, servo bom e fiel. Sobre o pouco foste fiel, sobre muito te colocarei.");
                pausar(1000);
            }
        }
    }

    // Método da Composição: Encerra a existência de todos os Filhos geridos
    public void destruirFilhos() {
        IO.println("        -[Deus]: O tempo da provação terminou. As almas retornam ao seu Criador.");
        pausar(1000);

        for (Filhos filho : listaFilhos) {
            if (filho.isEstarVivo()) {
                filho.setEstarVivo(false);
                IO.println("        [Juízo Final]: A jornada terrestre de " + filho.getNome() + " foi encerrada.");
                pausar(800);
            }
        }
        listaFilhos.clear();
    }

    public List<Filhos> getListaFilhos() {
        return listaFilhos;
    }

    @Override
    public boolean podeInteragir(Filhos alvo) {
        return alvo != null && alvo.isEstarVivo();
    }

    @Override
    public void interagir(Filhos alvo) {
        if (podeInteragir(alvo)) {
            agirNoPlanoInvisivel();
            chamarFilho(alvo);

            // Se o filho estiver carregado de culpa, Deus aplica o julgamento/perdão
            if (alvo.getCulpaAcumulada() >= 50) {
                aplicarConsequencia(alvo);
            } else {
                perdoarCulpa(alvo);
            }
        }
    }}