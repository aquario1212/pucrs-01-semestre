
/**
 * Escreva uma descrição da classe padroes_string aqui.
 * 
 * @author (Eduardo de Oliveira Lopes) 
 * @version (um número da versão ou uma data)
 */
import java.util.Scanner;
public class Padroes_String{
    public static void main (String args[]){
        Scanner in = new Scanner (System.in);
        
        System.out.print("\fDigite qualquer palavra: ");
        String palavra= in.nextLine();
        
        //chamando os metodos
        System.out.println("---PADRÃO 1---");
        padrao1 (palavra);
        System.out.println("---PADRÃO 2---");
        padrao2 (palavra);
        System.out.println("---PADRÃO 3---");
        padrao3 (palavra);
        System.out.println("---PADRÃO 4---");
        padrao4 (palavra);
    }
    
    //primeiro padrão
    public static void padrao1 (String palavra){
            for(int i = 0; i <= (palavra.length()-1);i++) {
                for(int j = 0; j <= i;j++){
                    System.out.print(palavra.charAt(j));
                }
                System.out.println(" ");
            }
            System.out.println("\n");
    }
    //segundo padrão
    public static void padrao2 (String palavra){
            for(int i = 0; i <= (palavra.length()-1);i++){
                for(int j = (palavra.length()-1); j >= i;j--) {
                    System.out.print(palavra.charAt(j));
                }
                System.out.println(" ");
            }
            System.out.println("\n");
    }        
    //terceiro padrão
    public static void padrao3 (String palavra){
            for(int i = 0; i <= (palavra.length()-1);i++){
                for(int e=(palavra.length()-1); e>i;e--) System.out.print(" ");
                for(int j = i; j >= 0;j--) {
                    System.out.print(palavra.charAt(j));
                }
                System.out.println(" ");
            }
            System.out.println("\n");
    }          
    //quarto padrão
    public static void padrao4 (String palavra){
            for(int i = 0; i <= (palavra.length()-1);i++) {
                for(int e=0; e<i;e++) System.out.print(" ");
                for(int j = i; j <= (palavra.length()-1);j++)  {
                    System.out.print(palavra.charAt(j));
                }
                System.out.println(" ");
            }
    }
}