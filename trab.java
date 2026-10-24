
/**
 * Escreva uma descrição da classe trab aqui.
 * 
 * @author (Eduardo Lopes, Eduardo Latorres, Vinicius Faraco) 
 * @version (um número da versão ou uma data)
 */
import java.util.Scanner;
public class trab

{
    public static void main(String args[]){
        Scanner teclado = new Scanner (System.in);
        System.out.println("\f DIGITE SUA DATA DE NASCIMENTO: DD MM AAAA");
        int dianasc = teclado.nextInt();
        int mesnasc = teclado.nextInt();
        int anonasc = teclado.nextInt();
        System.out.println("DIGITE A DATA DE HOJE: DD MM AAAA");
        int diahj = teclado.nextInt();
        int meshj = teclado.nextInt();
        int anohj = teclado.nextInt();
        String diaSemana = calcularDiaSemana(dianasc, mesnasc, anonasc);
        System.out.println("VOCÊ NASCEU EM: " + diaSemana);
        String signo = calcularsigno(dianasc, mesnasc);
        System.out.println("SIGNO: "+signo);
        if (diahj == dianasc && meshj == mesnasc){System.out.println("HOJE É SEU ANIVERSÁRIO");}else{
            int diasate = calculardiasfalt(dianasc, mesnasc, anonasc, diahj, meshj, anohj);
            System.out.println("DIAS ATE SEU ANIVERSÁRIO: "+diasate);}

    }

    public static String calcularsigno(int dia, int mes) {
        switch(mes) {
            case 1: if(dia<=20){return "CAPRICÓRNIO";} else {return "AQUÁRIO";}
            case 2: if(dia<=18){return "AQUÁRIO";} else {return "PEIXES";}
            case 3: if(dia<=20){return "PEIXES";} else {return "ÁRIES";}
            case 4: if(dia<=20){return "ÁRIES";} else {return "TOURO";}
            case 5: if(dia<=20){return "TOURO";} else {return "GÊMEOS";}
            case 6: if(dia<=20){return "GÊMEOS";} else {return "CÂNCER";}
            case 7: if(dia<=22){return "CÂNCER";} else {return "LEÃO";}
            case 8 : if(dia<=22){return "LEÃO";} else {return "VIRGEM";}
            case 9: if(dia<=22){return "VIRGEM";} else {return "LIBRA";}
            case 10: if(dia<=22){return "LIBRA";} else {return "ESCORPIÃO";}
            case 11: if(dia<=21){return "ESCORPIÃO";} else {return "SAGITÁRIO";}
            case 12: if(dia<=21){return "SAGITÁRIO";} else {return "CAPRICÓRNIO";}
            default: return "INVÁLIDO";}
    }

    public static int calculardiasfalt(int dianasc, int mesnasc, int anonasc, int diahj, int meshj, int anohj) {

        switch(mesnasc){
            case 1:  mesnasc= 0;break;
            case 2:  mesnasc= 31;break;
            case 3:  mesnasc= 59;break;
            case 4:  mesnasc= 90;break;
            case 5: mesnasc= 120;break;
            case 6:  mesnasc= 151;break;
            case 7:  mesnasc= 181;break;
            case 8:  mesnasc= 212;break;
            case 9: mesnasc= 243;break;
            case 10: mesnasc= 273;break;
            case 11:  mesnasc= 304;break;
            case 12:  mesnasc= 334;break;

        }

        switch(meshj){
            case 1:  meshj= 0;break;
            case 2:  meshj=31;break;
            case 3:  meshj=59;break;
            case 4:  meshj=90;break;
            case 5:  meshj=120;break;
            case 6: meshj=151;break;
            case 7: meshj=181;break;
            case 8: meshj=212;break;
            case 9: meshj=243;break;
            case 10:  meshj=273;break;
            case 11:  meshj=304;break;
            case 12: meshj=334;break;

        }
        int diasano;
        if (bissexto(anohj)){
            diasano = 366;
        } else {
            diasano = 365;
        }
        int diasate;
        int diaspassados;
        int diashoje= diahj + meshj;
        int diasnasc= dianasc + mesnasc;

        if(diasnasc >= diashoje){
            diasate = diasnasc - diashoje;
            diaspassados = (diasano - diasnasc) + diashoje;
        } else {
            diasate = (diasano - diashoje) + diasnasc;
            diaspassados = diashoje - diasnasc;
        }

        System.out.println("DIAS DESDE O ÚLTIMO ANIVERSÁRIO: " + diaspassados);
        return diasate;
    }

    public static boolean bissexto(int ano){
        if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)){
            return true;
        } else {
            return false;
        }
    }

    public static String calcularDiaSemana(int dia, int mes, int ano) {
        if (mes < 3) {
            mes += 12;
            ano--;
        }

        int K = ano % 100;
        int J = ano / 100;

        int h = (dia + (13 * (mes + 1)) / 5 + K + (K / 4) + (J / 4) + (5 * J)) % 7;

        switch (h) {
            case 0: return "SÁBADO";
            case 1: return "DOMINGO";
            case 2: return "SEGUNDA-FEIRA";
            case 3: return "TERÇA-FEIRA";
            case 4: return "QUARTA-FEIRA";
            case 5: return "QUINTA-FEIRA";
            case 6: return "SEXTA-FEIRA";
            default: return "ERRO";
        }
    }

}