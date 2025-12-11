package es.maos17.cdr.programacion.ut04.ejercicios.clases.ejerciciomochilav2;

import java.util.Scanner;

public class ProgramaMochila {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mochila mochila = new Mochila(10); // 10 filas

        boolean salir = false;
        while (!salir) {
            System.out.println("\n1. Ver \n2. Recoger \n3. Tirar \n4. Salir");
            int op = leerEnteroLimites("Opción: ", 1, 4, sc);

            switch (op) {
                case 1:
                    mochila.mostrarInventario();
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    
                    System.out.println("Tipo: 1.ARMA 2.POCION 3.RECURSO");
                    int t = leerEnteroLimites("Tipo: ", 1, 3, sc);
                    TipoMaterial tipo = switch(t) {
                        case 1 -> TipoMaterial.ARMA;
                        case 2 -> TipoMaterial.POCION;
                        default -> TipoMaterial.RECURSO;
                    };
                    
                    int cant = leerEnteroLimites("Cantidad: ", 1, 50, sc);
                    mochila.anadir(nom, tipo, cant);
                    break;
                case 3:
                    int fila = leerEnteroLimites("Fila (0-9): ", 0, 9, sc);
                    int c = leerEnteroLimites("Cantidad a tirar: ", 1, 50, sc);
                    mochila.tirar(fila, c);
                    break;
                case 4:
                    salir = true;
                    break;
            }
        }
    }
    
    public static int leerEnteroLimites(String mensaje, int min, int max, Scanner sc) {
    	int numero;
    	while(true) {
	    	try {
	    		System.out.print(mensaje);
	    		numero = Integer.parseInt(sc.nextLine());
	    		if (numero >= min && numero <= max) {
	    			return numero;
	    		}else {
	    			System.out.println("Número fuera de rango");
	    		}
	    	}catch(NumberFormatException e) {
	    		System.out.println("Número no válido");
	    	}
    	}
    }
}