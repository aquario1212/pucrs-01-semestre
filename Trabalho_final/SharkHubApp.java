
/**
 * Escreva uma descrição da classe Sharkhub aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
import java.util.Scanner;

public class SharkHubApp {
    private static final int MAX = 100;
    
    private static Investidor[] investidores = new Investidor[MAX];
    private static int totalInvestidores = 0;

    private static Startup[] startups = new Startup[MAX];
    private static int totalStartups = 0;

    private static Pitch[] pitches = new Pitch[MAX];
    private static int totalPitches = 0;

    private static Investimento[] investimentos = new Investimento[MAX];
    private static int totalInvestimentos = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- SHARK HUB MENU ---");
            System.out.println("1 - Cadastrar Investidor");
            System.out.println("2 - Cadastrar Startup");
            System.out.println("3 - Adicionar Pitch");
            System.out.println("4 - Adicionar Investimento");
            System.out.println("5 - Consultar Startup");
            System.out.println("6 - Consultar Investidores");
            System.out.println("7 - Consultar Investimentos");
            System.out.println("8 - Calcular Valuation");
            System.out.println("9 - Exibir Ranking de Startups (IPU)");
            System.out.println("10 - Exibir Índice de Unicornização (Destaques)");
            System.out.println("11 - [EXTRA] Simular Crescimento de 5 Anos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            
            opcao = lerInt(in);

            switch (opcao) {
                case 1: cadastrarInvestidor(in); break;
                case 2: cadastrarStartup(in); break;
                case 3: adicionarPitch(in); break;
                case 4: adicionarInvestimento(in); break;
                case 5: consultarStartup(in); break;
                case 6: consultarInvestidoresMenu(); break;
                case 7: consultarInvestimentosMenu(); break;
                case 8: calcularValuationMenu(in); break;
                case 9: exibirRankingIPU(); break;
                case 10: exibirIndiceUnicornizacao(); break;
                case 11: simularCrescimento5Anos(in); break;
                case 0: System.out.println("Saindo do sistema..."); break;
                default: System.out.println("Opcao invalida! Tente novamente.");
            }
            
            if (opcao != 0) {
                System.out.println("\nPressione ENTER para continuar...");
                in.nextLine(); 
            }
        }
    }

    private static int lerInt(Scanner in) {
        while (!in.hasNextInt()) {
            System.out.println("Erro: Entrada invalida! Digite apenas numeros inteiros.");
            System.out.print("Tente novamente: ");
            in.next();
        }
        int valor = in.nextInt();
        in.nextLine();
        return valor;
    }

    private static double lerDouble(Scanner in) {
        while (!in.hasNextDouble()) {
            System.out.println("Erro: Entrada invalida! Digite apenas numeros.");
            System.out.print("Tente novamente: ");
            in.next();
        }
        double valor = in.nextDouble();
        in.nextLine();
        return valor;
    }

    private static void cadastrarInvestidor(Scanner in) {
        System.out.print("\f");
        System.out.println("=== CADASTRO DE INVESTIDOR ===");
        System.out.print("ID do Investidor (Inteiro): ");
        int id = lerInt(in);
        
        System.out.print("Nome: ");
        String nome = in.nextLine();
        System.out.print("Email: ");
        String email = in.nextLine();

        for (int i = 0; i < totalInvestidores; i++) {
            if (investidores[i].getEmail().equalsIgnoreCase(email)) {
                System.out.println("Erro: Ja existe um investidor com este e-mail.");
                return;
            }
        }

        investidores[totalInvestidores++] = new Investidor(id, nome, email);
        System.out.println("Investidor cadastrado com sucesso!");
    }

    private static void cadastrarStartup(Scanner in) {
        if (totalInvestidores == 0) {
            System.out.println("Erro: Cadastre pelo menos um investidor primeiro.");
            return;
        }

        System.out.print("\f");
        System.out.println("=== CADASTRO DE STARTUP ===");
        System.out.print("ID da Startup (Inteiro): ");
        int id = lerInt(in);
        
        System.out.print("Nome: ");
        String nome = in.nextLine();
        System.out.print("Segmento: ");
        String segmento = in.nextLine();
        System.out.print("Ano de Fundacao (YYYY): ");
        String ano = in.nextLine();

        System.out.println("\nSelecione o ID do Investidor Responsavel abaixo:");
        consultarInvestidores();
        System.out.print("Digite o ID escolhido: ");
        int idInv = lerInt(in);

        Investidor investidorEncontrado = null;
        for (int i = 0; i < totalInvestidores; i++) {
            if (investidores[i].getId() == idInv) {
                investidorEncontrado = investidores[i];
                break;
            }
        }

        if (investidorEncontrado == null) {
            System.out.println("Erro: Investidor nao encontrado. Cadastro cancelado.");
            return;
        }

        startups[totalStartups++] = new Startup(id, nome, segmento, ano, investidorEncontrado);
        System.out.println("Startup cadastrada com sucesso!");
    }

    private static void adicionarPitch(Scanner in) {
        if (totalStartups == 0) {
            System.out.println("Erro: Nenhuma startup cadastrada.");
            return;
        }

        System.out.print("\f");
        System.out.println("=== ADICIONAR PITCH ===");
        System.out.print("ID do Pitch (Inteiro): ");
        int id = lerInt(in);
        
        System.out.print("Titulo da Apresentacao: ");
        String titulo = in.nextLine();
        
        System.out.print("Nota Inovacao (0-100): ");
        double nInov = lerDouble(in);
        
        System.out.print("Nota Mercado (0-100): ");
        double nMerc = lerDouble(in);

        System.out.print("ID da Startup Associada: ");
        int idStart = lerInt(in);

        Startup s = buscarStartupPorId(idStart);
        if (s == null) {
            System.out.println("Erro: Startup nao encontrada. Operacao cancelada.");
            return;
        }

        pitches[totalPitches++] = new Pitch(id, titulo, nInov, nMerc, s);
        System.out.println("Pitch adicionado com sucesso!");
    }

    private static void adicionarInvestimento(Scanner in) {
        if (totalStartups == 0) {
            System.out.println("Erro: Nenhuma startup cadastrada.");
            return;
        }

        System.out.print("\f");
        System.out.println("=== REGISTRAR INVESTIMENTO ===");
        System.out.print("ID do Investimento (Inteiro): ");
        int id = lerInt(in);
        
        System.out.print("Valor do Aporte: R$ ");
        double valor = lerDouble(in);
        
        System.out.print("Percentual de Participacao adquirida (%): ");
        double percentual = lerDouble(in);
        
        System.out.print("ID da Startup: ");
        int idStart = lerInt(in);

        Startup s = buscarStartupPorId(idStart);
        if (s == null) {
            System.out.println("Erro: Startup nao encontrada. Operacao cancelada.");
            return;
        }

        investimentos[totalInvestimentos++] = new Investimento(id, valor, percentual, s);
        System.out.println("Investimento registrado com sucesso!");
    }

    private static void consultarStartup(Scanner in) {
        System.out.print("\f");
        System.out.print("Digite o ID da Startup para consulta: ");
        int id = lerInt(in);
        Startup s = buscarStartupPorId(id);

        if (s == null) {
            System.out.println("Startup nao encontrada.");
            return;
        }

        System.out.println("\n=== DADOS DA STARTUP ===");
        System.out.println("Nome: " + s.getNome() + " | Segmento: " + s.getSegmento() + " | Idade: " + s.calcularTempoExistencia() + " anos");
        System.out.println("Investidor Principal: " + s.getInvestidor().getNome() + " (" + s.getInvestidor().getEmail() + ")");
        
        System.out.println("--- Pitches Cadastrados ---");
        for (int i = 0; i < totalPitches; i++) {
            if (pitches[i].getStartup().getId() == s.getId()) {
                System.out.println("- " + pitches[i].getTitulo() + " | Media: " + pitches[i].calcularNotaMedia());
            }
        }

        System.out.println("--- Investimentos Recebidos ---");
        for (int i = 0; i < totalInvestimentos; i++) {
            if (investimentos[i].getStartup().getId() == s.getId()) {
        System.out.printf("- ID: %d | Valor: R$ %.2f | Participacao: %.2f%%\n", investimentos[i].getId(), investimentos[i].getValor(), investimentos[i].getPercentualParticipacao());            }
        }
    }

    private static void consultarInvestidoresMenu() {
         System.out.print("\f");
        System.out.println("=== LISTA DE INVESTIDORES ===");
        consultarInvestidores();
    }

    private static void consultarInvestidores() {
        if (totalInvestidores == 0) System.out.println("Nenhum investidor cadastrado.");
        for (int i = 0; i < totalInvestidores; i++) {
            System.out.println("ID: " + investidores[i].getId() + " | Nome: " + investidores[i].getNome() + " | Email: " + investidores[i].getEmail());
        }
    }

    private static void consultarInvestimentosMenu() {
        System.out.print("\f");
        System.out.println("=== LISTA DE INVESTIMENTOS ===");
        if (totalInvestimentos == 0) System.out.println("Nenhum investimento cadastrado.");
        for (int i = 0; i < totalInvestimentos; i++) {
        System.out.printf("ID: %d | Valor: R$ %.2f | Startup: %s\n", investimentos[i].getId(), investimentos[i].getValor(), investimentos[i].getStartup().getNome());        }
    }

    private static void calcularValuationMenu(Scanner in) {
        System.out.print("\f");
        System.out.print("ID da Startup: ");
        int id = lerInt(in);
        Startup s = buscarStartupPorId(id);

        if (s == null) {
            System.out.println("Startup nao encontrada.");
            return;
        }

        double totalValuation = calcularTotalCaptado(s);
        System.out.printf("O Valuation (Total Captado) da Startup %s e: R$ %.2f\n", s.getNome(), totalValuation);
    }

    private static double calcularIPU(Startup s) {
        double pontosPitches = 0;
        int contPitches = 0;
        for (int i = 0; i < totalPitches; i++) {
            if (pitches[i].getStartup().getId() == s.getId()) {
                pontosPitches += pitches[i].calcularNotaMedia();
                contPitches++;
            }
        }
        double mediaPitches = (contPitches == 0) ? 0 : (pontosPitches / contPitches);
        double totalInvestido = calcularTotalCaptado(s);
        
        return mediaPitches + (totalInvestido / 10000.0);
    }

    private static String classificarIPU(double score) {
        if (score <= 100) return "Startup Inicial";
        if (score <= 250) return "Startup Promissora";
        if (score <= 500) return "Startup em Crescimento";
        return "Potencial Unicornio";
    }

    private static void exibirRankingIPU() {
        System.out.print("\f");
        if (totalStartups == 0) {
            System.out.println("Nenhuma startup cadastrada.");
            return;
        }

        Startup[] ordenado = new Startup[totalStartups];
        double[] scores = new double[totalStartups];

        for (int i = 0; i < totalStartups; i++) {
            ordenado[i] = startups[i];
            scores[i] = calcularIPU(startups[i]);
        }

        for (int i = 0; i < totalStartups - 1; i++) {
            for (int j = 0; j < totalStartups - i - 1; j++) {
                if (scores[j] < scores[j + 1]) {
                    double tempScore = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = tempScore;

                    Startup tempStartup = ordenado[j];
                    ordenado[j] = ordenado[j + 1];
                    ordenado[j + 1] = tempStartup;
                }
            }
        }

        System.out.println("\n=== RANKING DE STARTUPS (IPU) ===");
        for (int i = 0; i < totalStartups; i++) {
            System.out.println((i + 1) + "º - " + ordenado[i].getNome() + " | Pontos IPU: " + scores[i] + " | Classificacao: " + classificarIPU(scores[i]));
        }
    }

    private static void exibirIndiceUnicornizacao() {
        System.out.print("\f");
        if (totalStartups == 0) {
            System.out.println("Dados insuficientes.");
            return;
        }

        Startup maisPromissora = startups[0];
        double maxIPU = calcularIPU(startups[0]);

        Startup maiorVolumeStartup = startups[0];
        double maxInvestido = calcularTotalCaptado(startups[0]);

        for (int i = 1; i < totalStartups; i++) {
            double ipuAtual = calcularIPU(startups[i]);
            if (ipuAtual > maxIPU) {
                maxIPU = ipuAtual;
                maisPromissora = startups[i];
            }

            double invAtual = calcularTotalCaptado(startups[i]);
            if (invAtual > maxInvestido) {
                maxInvestido = invAtual;
                maiorVolumeStartup = startups[i];
            }
        }

        Investidor topInvestidor = null;
        double maxInvestidorAporte = 0;

        for (int i = 0; i < totalInvestidores; i++) {
            double somaAportes = 0;
            for (int j = 0; j < totalInvestimentos; j++) {
                if (investimentos[j].getStartup().getInvestidor().getId() == investidores[i].getId()) {
                    somaAportes += investimentos[j].getValor();
                }
            }
            if (somaAportes > maxInvestidorAporte) {
                maxInvestidorAporte = somaAportes;
                topInvestidor = investidores[i];
            }
        }

        System.out.println("\n=== DESTAQUES DO ECOSSISTEMA ===");
        System.out.println("Startup mais promissora (Maior IPU): " + maisPromissora.getNome() + " (" + maxIPU + " pts)");
        System.out.printf("Startup com maior volume de investimentos: %s (R$ %.2f)\n", maiorVolumeStartup.getNome(), maxInvestido); 
        if (topInvestidor != null) {
            System.out.println("Investidor com maior valor investido: " + topInvestidor.getNome() + " (R$ " + maxInvestidorAporte + ")");
        }
    }

    private static void simularCrescimento5Anos(Scanner in) {
        System.out.print("\f");
        System.out.print("ID da Startup para simulacao: ");
        int id = lerInt(in);
        Startup s = buscarStartupPorId(id);

        if (s == null) {
            System.out.println("Startup nao encontrada.");
            return;
        }

        System.out.print("Informe o percentual de crescimento anual estimado (%): ");
        double taxaCrescimento = lerDouble(in) / 100.0;

        double valuationAtual = calcularTotalCaptado(s);
        if (valuationAtual == 0) {
            System.out.print("A startup ainda nao tem aportes. Informe um valuation base inicial: R$ ");
            valuationAtual = lerDouble(in);
        }

        System.out.println("\n=== SIMULACAO DE CRESCIMENTO EM VALUATION (PROXIMOS 5 ANOS) ===");
        System.out.printf("Valuation Inicial: R$ %.2f\n", valuationAtual);
        
        double valuationProjetado = valuationAtual;
        for (int ano = 1; ano <= 5; ano++) {
            valuationProjetado += (valuationProjetado * taxaCrescimento);
            System.out.printf("Ano %d: R$ %.2f\n", ano, valuationProjetado);
        }
    }

    private static Startup buscarStartupPorId(int id) {
        for (int i = 0; i < totalStartups; i++) {
            if (startups[i].getId() == id) return startups[i];
        }
        return null;
    }

    private static double calcularTotalCaptado(Startup s) {
        double total = 0;
        for (int i = 0; i < totalInvestimentos; i++) {
            if (investimentos[i].getStartup().getId() == s.getId()) {
                total += investimentos[i].getValor();
            }
        }
        return total;
    }
}