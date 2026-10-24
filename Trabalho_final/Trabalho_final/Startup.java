
/**
 * Escreva uma descrição da classe startup aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Startup {
    private int id;
    private String nome;
    private String segmento;
    private String dataFundacao; // ano com 4 digitos
    private Investidor investidor;

    public Startup(int id, String nome, String segmento, String dataFundacao, Investidor investidor) {
        this.id = id;
        this.nome = nome;
        this.segmento = segmento;
        this.dataFundacao = dataFundacao;
        this.investidor = investidor;
    }

    
    public int calcularTempoExistencia() {
        int anoFundacao = Integer.parseInt(this.dataFundacao);
        return 2026 - anoFundacao;
    }

    
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }
    
    public String getSegmento() { return segmento; }

    public void setSegmento(String segmento) { this.segmento = segmento; }

    public String getDataFundacao() { return dataFundacao; }

    public void setDataFundacao(String dataFundacao) { this.dataFundacao = dataFundacao; }

    public Investidor getInvestidor() { return investidor; }

    public void setInvestidor(Investidor investidor) { this.investidor = investidor; }
}