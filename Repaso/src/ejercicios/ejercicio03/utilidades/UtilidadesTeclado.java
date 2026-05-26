package ejercicios.ejercicio03.utilidades;

import java.util.Scanner;

public final class UtilidadesTeclado {
    private UtilidadesTeclado() {};

    public static int enteroRango(String mensaje, int minimo, int maximo, Scanner sc){
        int entero;
        while(true){
            try{
                System.out.print(mensaje);
                entero = Integer.parseInt(sc.nextLine());
                if (entero >= minimo && entero <= maximo){
                    return entero;
                } else {
                    System.out.printf("Número fuera de rango (%d, %d)\n", minimo, maximo);
                }
            } catch (NumberFormatException e){
                System.out.println("Número no válido");
            }
        }
    }

    public static String cadena(String mensaje, Scanner sc) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    public static double doblePositivo(String mensaje, Scanner sc) {
        double doble;
        while(true){
            try{
                System.out.print(mensaje);
                doble = Double.parseDouble(sc.nextLine());
                if (doble >= 0){
                    return doble;
                } else {
                    System.out.println("Debe ser positivo.");
                }
            } catch (NumberFormatException e){
                System.out.println("Número no válido");
            }
        }
    }
}
