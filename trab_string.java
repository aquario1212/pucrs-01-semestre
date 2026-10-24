
/**
 * Escreva uma descrição da classe trab_string aqui.
 * 
 * @author (Eduardo de Oliveira Lopes, Vinicius Faraco Ferreira) 
 * @version (um número da versão ou uma data)
 */
import java.util.Scanner;
public class trab_string{
    public static void main (String args[]){
        System.out.println("\f");
        Scanner teclado = new Scanner (System.in);
        System.out.println("Digite a frase para ser analisada: ");
        String frase = teclado.nextLine();
        //inverter frase
        String invertido = invertida(frase);
        System.out.println(invertido);
        //quantidade de caracteres  
        int caracteres = caracteres(frase);
        System.out.println("numero de caracteres na frase é: "+caracteres);
        //caixa alta
        String frasegritada = frasegritada(frase);
        System.out.println(frasegritada);
        //caixa baixa 
        String frasecochichada = frasecochichada(frase);
        System.out.println(frasecochichada);
        //vogais
        int vogais= vogais(frase);
        System.out.println("quantidade de vogais "+vogais);
    }
    
    public static String invertida(String frase){
        String invertida = "";
        for (int i = frase.length()-1 ; i>=0; i--){
            invertida += frase.charAt(i);
        }

        return invertida;
    }

    public static int caracteres(String frase){
        int caracteres = frase.length();
        return caracteres;
    }

    public static String frasegritada(String frase){
        String frasegritada= frase.toUpperCase();
        
        
        return frasegritada;
        
    }
    
    public static String frasecochichada(String frase){
        String frasecochichada= frase.toLowerCase();
        
        
        return frasecochichada;
        
    }
    public static boolean Vogal(char vogal) {
        vogal = Character.toLowerCase(vogal);
        return vogal == 'a' || vogal == 'e' || vogal == 'i' || vogal == 'o' || vogal == 'u';
    }
    
    public static int vogais(String frase){
        int numerovogais= 0;
        // teste de mesa do for abaixo usando a frase "oi profe"
        //frase.length=8/8/8/8/8/8/8/8
        //i=0/1/2/3/4/5/6/7/8
        //numerodevogais=1/2/2/2/2/3/3/4
        
        for (int i = 0; i < frase.length(); i++) {
            char caractere = frase.charAt(i);
            if (Vogal(caractere)){
                numerovogais++;
            
            }
        }
        return numerovogais;
    }
}