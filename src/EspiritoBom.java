public class EspiritoBom extends EntidadeEspiritual implements Interagivel {
    private String mensagemAlento;

    public EspiritoBom(String nome, int nivelForca) {
        super(nome, nivelForca);
    }

    private void pausar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            System.out.println("A pausa foi interrompida!");
        }
    }

    @Override
    public void agirNoPlanoInvisivel() {
        IO.println("        -[EspiritoBom]: Não temas, pois Eu sou contigo; não te assombres, porque Eu sou o teu Deus.");
        pausar(1000);
        IO.println("        -[EspiritoBom]: A graça d'Ele se aperfeiçoa nas tuas fraquezas. Levanta-te!");
        pausar(1000);
    }
    public void entregarMensagemDeDeus(Filhos alvo) {
        IO.println("        -[EspiritoBom]: Trago-te uma palavra do Alto...");
        pausar(1000);

        // Seleciona a mensagem divina com base na maior necessidade do Filho
        if (alvo.getCulpaAcumulada() >= 40) {
            IO.println("        -[EspiritoBom]: 'Ainda que os teus pecados sejam como a escarlata, eles se tornarão brancos como a neve. Não aceites a condenação do inimigo!'");
            alvo.setCulpaAcumulada(Math.max(0, alvo.getCulpaAcumulada() - 20)); // Reduz a culpa
        }
        else if (alvo.getEloComOPai() <= 0.4f) {
            IO.println("        -[EspiritoBom]: 'Não te deixarei, nem te desampararei. O teu Pai não se esqueceu de ti neste vale.'");
            alvo.setEloComOPai(Math.min(1.0f, alvo.getEloComOPai() + 0.20f)); // Restaura o elo
        }
        else {
            IO.println("        -[EspiritoBom]: 'Sê forte e corajoso. A minha graça te basta, pois o meu poder aperfeiçoa-se na tua fraqueza!'");
            alvo.setSanidade(Math.min(100, alvo.getSanidade() + 15)); // Restaura a sanidade
        }

        pausar(1000);
        IO.println("        [Graça Divina]: Sentiste uma paz inexplicável a renovar as tuas forças.");
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