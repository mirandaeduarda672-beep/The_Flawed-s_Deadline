public abstract class Filhos extends Deus {
    private String nome;
    private int idade;
    private int sanidade=100;
    private float eloComOPai= 1.0F;
    private int diaDaSemana=1;
    private boolean estarVivo=true;
    private int culpaAcumulada;



     ///////////////////colocar o metodo pausssaaar
    public Filhos() {
        this.sanidade = 100;        // Começa com sanidade total
        this.eloComOPai = 1.0f;     // Começa com elo máximo (100%)
        this.culpaAcumulada = 0;    // Começa sem culpa
        this.diaDaSemana = 1;       // Inicia no Dia 1
        this.estarVivo = true;      // Começa vivo
    }
    public String statusFilho(){
        IO.println("\n");
        return ("--------------- Status -> Sanidade: " +sanidade + " | Elo com o Pai: " + eloComOPai + "%" + " | Culpa: " + culpaAcumulada);

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

    public void pecar() {
        IO.println("        [Tentação]: Cedes ao desejo momentâneo, mas o prazer efémero dá lugar a uma fria e pesada culpa no teu peito.");

            // Impacto nos atributos
        this.eloComOPai = Math.max(0.0f, this.eloComOPai - 0.20f); // Reduz a conexão divina
        this.sanidade = Math.max(0, this.sanidade - 15);           // Perde paz de espírito
        this.culpaAcumulada += 25;
        statusFilho();
    }
    public void confessar(Deus deus) {
        IO.println("        [Confissão]: 'Pai, pequei contra o céu e contra Ti; não sou mais digno de ser chamado Teu filho, mas clamo pela Tua misericórdia...'");
        eloComOPai+=0.5f;
        sanidade+=10;
        statusFilho();
        deus.perdoarCulpa(Filhos.this);


    }
    //interceder:orar pelos irmaos, abencoa-los
    public void interceder(Deus deus) {
        IO.println("        [Intercessão]: Clamas não por ti, mas pela proteção e fortalecimento da fé dos teus irmãos na caminhada.");
        deus.perdoarCulpa(Filhos.this);
        IO.println("        [Efeito]: A sua sanidade e o seu elo com o pai subiram levemente ...");
        eloComOPai+=0.1f;
        sanidade+=30;
        statusFilho();
    }
    public abstract void reagirATentacao();

    public void orar(Deus deus){
        if (this.sanidade < 30) {
            IO.println("        [Oração Desesperada]: Em lágrimas e com a voz trêmula, clamas por socorro na tua escuridão...");

        } else {
            IO.println("        [Oração]: Fechas os olhos e sentes a presença renovadora do Altíssimo...");
        }
        IO.println("        [Efeito]: A sua sanidade e o seu elo com o pai subiram levemente ...");
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

}
