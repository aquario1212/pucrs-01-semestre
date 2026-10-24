
/**
 * Escreva uma descrição da classe valuation aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Valuation {
    private Startup startup;
    private double valorCaptado;

    public Valuation(Startup startup) {
        this.startup = startup;
        this.valorCaptado = 0.0;
    }

    public Startup getStartup() { return startup; }
    
    public double getValorCaptado() { return valorCaptado; }
    
    public void setValorCaptado(double valorCaptado) { this.valorCaptado = valorCaptado; }
    
}