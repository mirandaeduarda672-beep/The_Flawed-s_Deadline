public abstract class Filhos {
    private String nome;
    private int idade;
    private int sanidade;
    private float eloComOPai;
    private int diaDaSemana;
    private boolean estarVivo;
    private int culpaAcumulada;

    public Filhos(String nome, int idade, int sanidade, float eloComOPai, int diaDaSemana, boolean estarVivo, int culpaAcumulada) {
        this.nome = nome;
        this.idade = idade;
        this.sanidade = sanidade=100;
        this.eloComOPai = eloComOPai= 1.0F;
        this.diaDaSemana = diaDaSemana=1;
        this.estarVivo = estarVivo=true;
        this.culpaAcumulada = culpaAcumulada;
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
    }
    public void confessar(){

    }
    //interceder:orar pelos irmaos, abencoa-los
    public void interceder(){

    }
    public abstract void reagirATentacao();

    public void orar(){

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

    public void setEloComOPai(float v) {
    }
}
