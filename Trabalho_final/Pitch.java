
/**
 * Escreva uma descrição da classe pitch aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Pitch {
    private int id;
    private String titulo;
    private double notaInovacao;
    private double notaMercado;
    private Startup startup;

    public Pitch(int id, String titulo, double notaInovacao, double notaMercado, Startup startup) {
        this.id = id;
        this.titulo = titulo;
        this.notaInovacao = notaInovacao;
        this.notaMercado = notaMercado;
        this.startup = startup;
    }

    
    public double calcularNotaMedia() {
        return (this.notaInovacao + this.notaMercado) / 2.0;
    }

    
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public double getNotaInovacao() { return notaInovacao; }

    public void setNotaInovacao(double notaInovacao) { this.notaInovacao = notaInovacao; }
    
    public double getNotaMercado() { return notaMercado; }
    
    public void setNotaMercado(double notaMercado) { this.notaMercado = notaMercado; }
    
    public Startup getStartup() { return startup; }
    
    public void setStartup(Startup startup) { this.startup = startup; }
}