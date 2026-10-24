
/**
 * Escreva uma descrição da classe investimento aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Investimento {
    private int id;
    private double valor;
    private double percentualParticipacao;
    private Startup startup;

    public Investimento(int id, double valor, double percentualParticipacao, Startup startup) {
        this.id = id;
        this.valor = valor;
        this.percentualParticipacao = percentualParticipacao;
        this.startup = startup;
    }

    // Getters e Setters
    public int getId() { return id; }
    
    public void setId(int id) { this.id = id; }
    
    public double getValor() { return valor; }
    
    public void setValor(double valor) { this.valor = valor; }
    
    public double getPercentualParticipacao() { return percentualParticipacao; }
    
    public void setPercentualParticipacao(double percentualParticipacao) { this.percentualParticipacao = percentualParticipacao; }
    
    public Startup getStartup() { return startup; }
    
    public void setStartup(Startup startup) { this.startup = startup; }
}