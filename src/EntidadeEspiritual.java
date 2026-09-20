public abstract class EntidadeEspiritual implements Interagivel{
    //Classe aonde sairão as entidades(Deus,Espirito Obssesor,Espirito bom)
    private String nome;
    private int nivelForca;
    public abstract void agirNoPlanoInvisivel();

    public EntidadeEspiritual(String nome, int nivelForca) {
        this.nome = nome;
        this.nivelForca = nivelForca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivelForca() {
        return nivelForca;
    }

    public void setNivelForca(int nivelForca) {
        this.nivelForca = nivelForca;
    }
}
