
/**
 * Escreva uma descrição da classe atividade_vetores_entregar aqui.
 * Tecnico: Henrique
 * Cenário: Existem duas partas da estufa, uma cultivando tomate, e a outra cultivando alface. por motivos de monitoramento de 
 * produtividade foram instalados um sensor de temperatura para cada uma das partes da estufa, para monitorar a temperatura em cada uma
 * de forma separada e fazer ajustes caso for preciso. Henrique percebeu, que o ultimo valor lido do sensor dos Tomates aprecia como 100 (um erro/bug) e para resolver teve que usar o menu da estufa * @author (Eduardo Lopes) 
 * @version (3/6/2026)
 */

import java.util.Scanner;
public class atividade_vetores_estufa{
    public static void main (String args[]){
        Scanner teclado = new Scanner (System.in);
        // printando saudação (chamando metodo)
        double [] dadosTomate = new double [8];
        double[] dadosAlface = new double [8];
        imprimirSaudação();
        //ciclo para pedir informaçoes para o usuario
        System.out.println("\f--Entrada de dados dos sensores--"); // tomate e alface respectivamente
        // chamando metodo de receber as informaçoes do scanner
        dadosTomate = lerTemperaturas(teclado, "Tomate");
        dadosAlface = lerTemperaturas(teclado, "Alface");
        int opcao;
        do{
            System.out.println("====Menu Interativo===="); 
            System.out.println("1- subtrair dados do sensor");
            System.out.println("2- substitir valores (pares/impares)");
            System.out.println("3- trocar impares por -1 e pares por -2");
            System.out.println("4- Concatenar dados dos sensores");
            System.out.println("5- Clonar dados de um sensor");
            System.out.println("6- intersecção dos dois sensores");
            System.out.println("7- união dos dados");
            System.out.println("8- adicionar um novo dado a um dos sensores");
            System.out.println("9- remove um dado de um dos sensores");
            System.out.println("10- Relatorio atual da estufa");
            System.out.println("0- Sair do sistema");
            System.out.println("Escolha uma opção");
            opcao = teclado.nextInt();
            switch(opcao){
                case 1: System.out.println("\n[opção 1 selecionada]");
                    double[] resultadoSubtracao = subtrairSensores(dadosTomate,dadosAlface);
                    for (int i = 0; i < resultadoSubtracao.length; i++){
                        System.out.println("resultado da subtração dos dados: " + resultadoSubtracao[i]);
                    }
                    break;
                case 2: System.out.println("\n[opção 2 selecionada]");
                    System.out.println("Trocando pares/impares numeros tomate: ");
                    trocarParesImpares(dadosTomate);
                    for (int i = 0 ; i <dadosTomate.length; i++){
                        System.out.print(dadosTomate[i]);
                        System.out.println();
                    }
                    break;
                case 3: System.out.println("\n[opção 3 selecionada]");
                    substituirValores(dadosAlface);
                    for (int i = 0 ; i < dadosAlface.length; i++){
                        System.out.println(dadosAlface[i]);    
                    }
                    break;
                case 4: System.out.println("\n[opção 4 slecionada]");
                    double[] sensoresUnificado = concatenarSensores (dadosTomate, dadosAlface);
                    for (int i = 0 ; i < sensoresUnificado.length; i++){
                        System.out.println(sensoresUnificado[i]);    
                    }
                    break;
                case 5: System.out.println("\n[opção 5 slecionada]");
                    double [] copiaTomate = clonarVetor(dadosTomate);
                    for (int i = 0; i<copiaTomate.length; i++){
                        System.out.print(copiaTomate[i]);
                    }
                    break;
                case 6: System.out.println("\n[opção 6 slecionada]");
                    double [] valoresComuns = calcularInter(dadosTomate, dadosAlface);
                    if (valoresComuns.length == 0){
                        System.out.println("Nenhuma temperatura identica nos dois sensores");
                    }else{
                        for (int i = 0; i<valoresComuns.length; i++){
                            System.out.print(valoresComuns[i]);
                        }
                    }
                    break;
                case 7: System.out.println("\n[opção 7 selecionada]");
                    double[] dadosUniao = gerarUniao(dadosTomate, dadosAlface);
                        System.out.print("União dos dados dos sensores: [ ");
                    for (int i = 0; i < dadosUniao.length; i++) {
                        System.out.print(dadosUniao[i] + " ");
                    }
                    System.out.println("]");
                    break;
                case 8: System.out.println("\n[opção 8 selecionada - Inserir Novo Dado]");

                    // qual sensor quer botar novo numero
                    System.out.println("Em qual sensor deseja inserir o dado?");
                    System.out.println("1 - Tomate");
                    System.out.println("2 - Alface");
                    System.out.print("Escolha: ");
                    int escolhaSensor = teclado.nextInt();
                    // onde quer botar
                    System.out.print("Digite a posição onde quer inserir (0 a 7): ");
                    int pos = teclado.nextInt();
                    System.out.print("Digite o novo valor de temperatura: ");
                    double valor = teclado.nextDouble();

                    // aplica o numero no sensor escolhido
                    if (escolhaSensor == 1) {
                        inserirDado(dadosTomate, pos, valor);
                    } else if (escolhaSensor == 2) {
                        inserirDado(dadosAlface, pos, valor);
                    } else {
                        System.out.println("Sensor inválido!");
                    }
                    break;
                case 9: System.out.println("\n[opção 9 selecionada - Remover Dado]");

                    // de qual sensor quer remover
                    System.out.println("De qual sensor deseja remover o dado?");
                    System.out.println("1 - Tomate");
                    System.out.println("2 - Alface");
                    System.out.print("Escolha: ");
                    int sensorRemover = teclado.nextInt();

                    // posição da remoçao
                    System.out.print("Digite o índice da posição que deseja remover (0 a 7): ");
                    int posRemover = teclado.nextInt();

                    // aplica aremoçao
                    if (sensorRemover == 1) {
                        removerDado(dadosTomate, posRemover);
                    } else if (sensorRemover == 2) {
                        removerDado(dadosAlface, posRemover);
                    } else {
                        System.out.println("Sensor inválido!");
                    }
                    break;
                case 10: System.out.println("\n[opção 10 selecionada - Exibir Todos os Vetores]");
                
                    System.out.println("--- RELATURIO ATUAL DA ESTUFA ---");
                    
                    System.out.println ("Sensor Tomate");
                    for(int i = 0 ; i<dadosTomate.length;i++){
                        System.out.println("posição [" + i + "]: " + dadosTomate[i]);
                    }
                    
                    System.out.println("Sensor Alface");
                     for(int i = 0 ; i<dadosAlface.length;i++){
                        System.out.println("posição [" + i + "]: " + dadosAlface[i]);
                    }

                    System.out.println("---------------------------------");
                    break;
                    
                case 0: System.out.println("\n[opção 0 selecionada]"); break;
                default : System.out.println("\n[opção invalida!]"); break;
            }
        } while (opcao !=0);
        System.out.println ("Desenvolvido por Eduardo Lopes Turma 30");
    }
    //metodo para saudação
    public static void imprimirSaudação(){
        System.out.println("====Interface Da Estufa====");
    }
    //metodo para ler os sensores (repete para ler ambos os sensores)
    public static double[] lerTemperaturas (Scanner scanner, String nomeSensor){
        double[] dados = new double [8];
        System.out.println("----Entrada de dados: " + nomeSensor + "----");
        for (int i = 0; i<dados.length ;i++){
            System.out.println("Digite as temperaturas lidas nos sensores(em graus celsius) :" + (i+1) + ":");
            dados[i] = scanner.nextDouble();
        }
        return  dados;
    }
    //metodo para subtrair os dados dos sensores
    public static double [] subtrairSensores(double[] tomate,double[] alface){
        double[] resultado = new double [8];
        for (int i = 0; i < resultado.length; i++){
            resultado[i] = tomate [i] - alface[i];
        }
        return resultado;
    }
    /// metodo para trocar pares e impares
    public static void trocarParesImpares(double[] vetor){
        for (int i=0; i <vetor.length - 1; i += 2){ //avança de 2 em 2 para pegar os pares vizinhos
            double temp = vetor[i]; //temp é uma variavel auxiliar
            vetor [i] = vetor[i+1];
            vetor [i + 1] = temp;
        }
    }
    //trocar por -1 e -2 impares e pares
    public static void substituirValores(double[] vetor){
        for (int i = 0; i< vetor.length;i++){
            if (i % 2 == 0){
                vetor[i] = -2;
            } else {
                vetor [i] = -1;
            }
        }
    }
    //concatenar sensores
    public static double[] concatenarSensores(double [] tomate, double[] alface){
        //criar um vetor grande para comportar os outros dois vetores com 8 espaços, ou seja, 16 no total 
        double [] concatenacao = new double[tomate.length +alface.length]; // aqui eu pego o length dos dois, sendo 8+8
        for ( int i = 0; i<tomate.length;i++){
            concatenacao [i] = tomate[i];// vai copiar na posição 0 até 7 
            concatenacao [i+8] = alface[i];// vai copiar na posição 8 até 15 
        }
        return concatenacao;
    }
    //clonar um vetor
    public static double[] clonarVetor(double[] vetorOriginal){
        double[] vetorClone = new double[vetorOriginal.length]; // cria um vetor com o mesmo tamanho do vetor original
        for(int i = 0; i < vetorOriginal.length; i++){
            vetorClone[i] = vetorOriginal[i]; // pega o tamanho do vetor orignal e iguala ao vetor clone
        }
        return vetorClone; // faz a operação de igualar e depois retorna o vetor clonado igual ao o original
    }
    // interseccao dos dados
    public static double[] calcularInter(double[] tomate , double [] alface){
        double [] temp = new double [8];
        int contador = 0;
        for (int i = 0; i < tomate.length; i++){
            for (int j =0; j < alface.length; j++){

                if (tomate [i] == alface [j]){
                    temp [contador] = tomate[i];
                    temp [contador] = tomate [i];
                    contador++;
                    break; // para o laço pra nao repetir caso tiver duplicado
                }
            }
        }
        double [] resultado = new double[contador];
        for (int i = 0; i<contador; i++){
            resultado [i] = temp[i];
        }
        return resultado;
    }
    // uniao dos dados. metodo auxiliar + metodo principal
    public static boolean existeNoVetor(double[] vetor, int quantidadeValidos, double valor) {
        for (int i = 0; i < quantidadeValidos; i++) {
            if (vetor[i] == valor) {
                return true; // achou numero repetido
            }
        }
        return false; // nao achou numero repetido
    }

    public static double[] gerarUniao(double[] tomate, double[] alface) {
        double[] temp = new double[tomate.length + alface.length]; // tamanho maximo de 16 8+8
        int contador = 0;
        for (int i = 0; i < tomate.length; i++) {
            temp[contador] = tomate[i];
            contador++;
        }

        for (int i = 0; i < alface.length; i++) {
            if (!existeNoVetor(temp, contador, alface[i])) {
                temp[contador] = alface[i];
                contador++;
            }
        }

        double[] resultadoFinal = new double[contador];
        for (int i = 0; i < contador; i++) {
            resultadoFinal[i] = temp[i];
        }

        return resultadoFinal;
    }
    // inserir novo numero em um dos vetores
    public static void inserirDado(double[] vetor, int posicao, double novoValor) {
        // garante que o user escolheu um numero valido de 0 a 7
        if (posicao >= 0 && posicao < vetor.length) {
            vetor[posicao] = novoValor;
            System.out.println("Dado inserido com sucesso na posição " + posicao + "!");
        } else {
            System.out.println("Erro: Posição inválida! Escolha um índice entre 0 e " + (vetor.length - 1));
        }
    }
    // remover um dos dados de um vetor
    public static void removerDado(double[] vetor, int posicao) {
        // Validação para garantir que o índice existe (0 a 7)
        if (posicao >= 0 && posicao < vetor.length) {

            // Laço que puxa os elementos da direita para a esquerda
            for (int i = posicao; i < vetor.length - 1; i++) {
                vetor[i] = vetor[i + 1];
            }

            // O último elemento, que ficou duplicado, é zerado
            vetor[vetor.length - 1] = 0.0;

            System.out.println("Dado removido com sucesso e posições reajustadas!");
        } else {
            System.out.println("Erro: Posição inválida! Escolha um índice entre 0 e " + (vetor.length - 1));
        }
    }
}