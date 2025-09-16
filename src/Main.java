import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite su valor: ");
        int valor = input.nextInt();

        long ini = System.nanoTime();
        System.out.println("Tiempo Inicial en ns: "+ini);
        System.out.println("Tiempo Inicial en ms: "+(ini/1000000.0));
        boolean[] primos = validarPrimos(valor);
        long fin = System.nanoTime();

        System.out.println("Los numeros Primos de "+valor);
        for(int i = 2; i <= valor; i++) {
            if(primos[i] && i == 2) {
                System.out.printf(""+i);
            } else if(primos[i] && i != 2) {
                System.out.printf(","+ i);
            }
        }

        long tiempo = fin - ini;
        System.out.println("\nTiempo en ns: "+tiempo);
        System.out.println("\nTiempo en ms: "+(tiempo/1000000.0));
        input.close();

    }
    public static boolean[] validarPrimos(int valor) {
        boolean[] validar = new boolean[valor + 1];

        for (int i = 2; i <= valor; i++) {
            validar[i] = true;
        }

        for (int p = 2; p * p <= valor; p++) {
            if (validar[p]) {
                for (int multiplo = p * p; multiplo <= valor; multiplo += p) {
                    validar[multiplo] = false;
                }
            }
        }

        return validar;
    }
}