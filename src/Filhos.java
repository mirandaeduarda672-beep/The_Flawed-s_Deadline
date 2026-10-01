public abstract class Filhos extends Deus {
    private String nome;
    private int idade;
    private int sanidade=100;
    private float eloComOPai= 1.0F;
    private int diaDaSemana=1;
    private boolean estarVivo=true;
    private int culpaAcumulada;
    private String cor;

    public Filhos() {
        this.sanidade = 100;        // Começa com sanidade total
        this.eloComOPai = 1.0f;     // Começa com elo máximo (100%)
        this.culpaAcumulada = 0;    // Começa sem culpa
        this.diaDaSemana = 1;       // Inicia no Dia 1
        this.estarVivo = true;      // Começa vivo
    }
    public Filhos(String cor) {
        this(); // Executa primeiro as inicializações do construtor acima!
        this.cor = cor;
    }

    public String statusFilho(){
        ArtUtils.imprimirLento (Cores.MENU+"--------------- Status -> Sanidade: " +sanidade + " | Elo com o Pai: " + eloComOPai + "%" + " | Culpa: " + culpaAcumulada+Cores.VOLTARCOR,70);
        return "";}

    public void falar(String mensagem) {
        String textoFormatado = this.cor + "        [" + getNome() + "]: " + mensagem + Cores.VOLTARCOR;
        ArtUtils.imprimirLento(textoFormatado, 70);
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getSanidade() {
        return sanidade;
    }

    public float getEloComOPai() {
        return eloComOPai;
    }

    public int getDiaDaSemana() {
        return diaDaSemana;
    }

    public boolean isEstarVivo() {
        return estarVivo;
    }

    public int getCulpaAcumulada() {
        return culpaAcumulada;
    }

    public String getCor() {return cor;}

    public void pecar() {
        ArtUtils.imprimirLento(Cores.NARRADOR+"        [Tentação]: Cedes ao desejo momentâneo, mas o prazer efémero dá lugar a uma fria e pesada culpa no teu peito."+Cores.VOLTARCOR,70);

            // Impacto nos atributos
        this.eloComOPai = Math.max(0.0f, this.eloComOPai - 0.20f); // Reduz a conexão divina
        this.sanidade = Math.max(0, this.sanidade - 15);           // Perde paz de espírito
        this.culpaAcumulada += 25;
        statusFilho();
    }
    public void confessar(Deus deus) {
        falar("        [Confissão]: 'Pai, pequei contra o céu e contra Ti; não sou mais digno de ser chamado Teu filho, mas clamo pela Tua misericórdia...'");
        eloComOPai+=0.5f;
        sanidade+=10;
        statusFilho();
        deus.perdoarCulpa(Filhos.this);
    }
    //interceder:orar pelos irmaos, abencoa-los
    public void interceder(Deus deus) {
        falar("        [Intercessão]: Clamas não por ti, mas pela proteção e fortalecimento da fé dos teus irmãos na caminhada.");
        deus.perdoarCulpa(Filhos.this);
        falar("        [Efeito]: A sua sanidade e o seu elo com o pai subiram levemente ...");
        eloComOPai+=0.1f;
        sanidade+=30;
        statusFilho();
    }
    public abstract void reagirATentacao();

    public void orar(Deus deus){
        if (this.sanidade < 30) {
            falar("        [Oração Desesperada]: Em lágrimas e com a voz trêmula, clamas por socorro na tua escuridão...");

        } else {
            falar("        [Oração]: Fechas os olhos e sentes a presença renovadora do Altíssimo...");
        }
        ArtUtils.imprimirLento(Cores.NARRADOR+"        [Efeito]: A sua sanidade e o seu elo com o pai subiram levemente ..."+Cores.VOLTARCOR,70);
        eloComOPai+=0.1f;
        sanidade+=30;
        statusFilho();
        deus.perdoarCulpa(Filhos.this);

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSanidade(int sanidade) {
        this.sanidade = sanidade;
    }

    public void setDiaDaSemana(int diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public void setEstarVivo(boolean estarVivo) {
        this.estarVivo = estarVivo;
    }

    public void setCulpaAcumulada(int culpaAcumulada) {
        this.culpaAcumulada = culpaAcumulada;
    }

    public void setEloComOPai(float eloComOPai) {
        this.eloComOPai = eloComOPai;
    }

    public void setCor(String cor) { this.cor = cor; }

}
