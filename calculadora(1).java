
/**
 * Escreva uma descrição da classe datas1a7 aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
import java.util.Scanner;
public class calculadora
{
    public static void main(String args[]){
      Scanner teclado = new Scanner(System.in);
      double n1,n2;
      int calculo;
      System.out.println("\f Digite o primeiro numero: ");
      n1= teclado.nextDouble();
      System.out.println("Digite o segundo numero: ");
      n2= teclado.nextDouble();
      System.out.println("Digite a operação desejada \n 1- somar \n 2- subtrair \n 3- multiplicar \n 4- dividir");
      calculo= teclado.nextInt();
      switch (calculo){
        case 1 :System.out.println("A soma dos valores é" + (n1+n2));
        break;
        case 2 :System.out.println("A subtração dos valores é" + (n1-n2));
        break;
        case 3 :System.out.println("A multiplicação dos valores é" + (n1*n2));
        break;
        case 4 :System.out.println("A divisão dos valores é" + (n1/n2));
        break;
        default :System.out.println("Valores invalidos");
      }
      }      
    }