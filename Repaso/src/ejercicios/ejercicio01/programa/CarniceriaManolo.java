package ejercicios.ejercicio01.programa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import ejercicios.ejercicio01.clases.Administrador;
import ejercicios.ejercicio01.clases.Cliente;
import ejercicios.ejercicio01.clases.Producto;
import ejercicios.ejercicio01.clases.Usuario;
import ejercicios.ejercicio01.utilidades.UtilidadesTeclado;

public class CarniceriaManolo {
    private static List<Producto> productos = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static Set<String> nombres = new HashSet<>();
    private static double gananciaTotal = 0.0;
    private static final String FILE_USUARIOS = "usuarios.bin";
    private static final String FILE_PRODUCTOS = "productos.bin";
    private static final String FILE_GANANCIA = "ganancia.txt";
    private static Scanner sc = new Scanner(System.in);
    private static Usuario usuario = null;

    public static void main(String[] args) {
        inicializarAplicacion();

        boolean salir = false;
        while (!salir) {
            System.out.printf("Usuario: %s\n", usuario != null ? usuario.getNombre() : "Invitado");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("==============");
            if (usuario == null) {
                salir = menuInvitado();
            } else if (usuario instanceof Administrador) {
                salir = menuAdministrador();
            } else {
                salir = menuCliente();
            }
        }

        cerrarAplicacion();
        System.out.println("Hasta pronto.");
    }

    private static boolean menuAdministrador() {
        System.out.println("1. Mostrar todos los productos");
        System.out.println("2. Mostrar producto por código/descripción");
        System.out.println("3. Añadir producto / Modificar stock");
        System.out.println("4. Mostrar Ganancia");
        System.out.println("5. Dar de alta a un usuario");
        System.out.println("6. Desconectar");
        System.out.println("7. Salir");
        int opcion = UtilidadesTeclado.enteroRango("Opción: ", 1, 7, sc);

        switch (opcion) {
            case 1:
                mostrarProductos();
                break;
            case 2:
                mostrarProducto();
                break;
            case 3:
                altaModifProducto();
                break;
            case 4:
                System.out.printf("Ganancia total: %.2f €\n", gananciaTotal);
                break;
            case 5:
                String admin = UtilidadesTeclado.cadena("¿Administrador? (S/N): ", sc);
                registrarUsuario(admin.equalsIgnoreCase("S"));
                break;
            case 6:
                usuario = null;
                break;
            case 7:
                return true;
        }
        return false;
    }

    private static boolean menuInvitado() {
        System.out.println("1. Mostrar todos los productos");
        System.out.println("2. Mostrar producto por código/descripción");
        System.out.println("3. Registrar usuario");
        System.out.println("4. Login");
        System.out.println("5. Salir");
        int opcion = UtilidadesTeclado.enteroRango("Opción: ", 1, 5, sc);

        switch (opcion) {
            case 1:
                mostrarProductos();
                break;
            case 2:
                mostrarProducto();
                break;
            case 3:
                usuario = registrarUsuario(false);
                if (usuario != null) {
                    System.out.println("Usuario creado correctamente");
                } else {
                    System.out.println("No se pudo crear el nuevo usuario");
                }
                ;
                break;
            case 4:
                login();
                break;
            case 5:
                return true;
        }
        return false;
    }

    private static boolean menuCliente() {
        System.out.println("1. Mostrar todos los productos");
        System.out.println("2. Mostrar producto por código/descripción");
        System.out.println("3. Comprar");
        System.out.println("4. Desconectar");
        System.out.println("5. Salir");
        int opcion = UtilidadesTeclado.enteroRango("Opción: ", 1, 5, sc);

        switch (opcion) {
            case 1:
                mostrarProductos();
                break;
            case 2:
                mostrarProducto();
                break;
            case 3:
                comprar();
                break;
            case 4:
                usuario = null;
                break;
            case 5:
                return true;
        }
        return false;
    }

    private static void inicializarAplicacion() {
        try (ObjectInputStream oisU = new ObjectInputStream((new FileInputStream(FILE_USUARIOS)))) {
            // El fichero de usuarios existe
            try {
                usuarios = (List<Usuario>) oisU.readObject();
                // Creamos un Set de nombres para agilizar búsquedas
                for (Usuario u : usuarios) {
                    nombres.add(u.getNombre());
                }

                // Cargamos productos
                try (ObjectInputStream oisP = new ObjectInputStream(new FileInputStream(FILE_PRODUCTOS))) {
                    productos = (List<Producto>) oisP.readObject();
                } catch (IOException e) {
                    System.out.println("Error al acceder al archivo de productos");
                }

                // Cargamos ganancia
                try (BufferedReader br = new BufferedReader(new FileReader(FILE_GANANCIA))) {
                    try {
                        gananciaTotal = Double.parseDouble(br.readLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Formato erróneo en fichero de ganacia total");
                    }
                } catch (IOException e) {
                    System.out.println("Error al acceder al archivo de ganancia total");
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Error de formato en fichero de entrada");
            }
        } catch (FileNotFoundException e) {
            // El fichero no existe
            System.out.println("Primer acceso a la aplicación. Registre un usuario administrador.");
            usuario = registrarUsuario(true);
        } catch (IOException e) {
            System.out.println("Error cargar fichero de usuarios: " + e.getMessage());
        }
    }

    private static Usuario registrarUsuario(boolean isAdministrador) {
        String nombre, password;
        Usuario nuevoUsuario = null;

        nombre = UtilidadesTeclado.cadena("Nombre de usuario: ", sc);
        // Bucle para asegurar un nombre único
        while (buscarUsuario(nombre)) {
                System.out.println("Error: El nombre de usuario ya está en uso. Pruebe otro.");
                nombre = UtilidadesTeclado.cadena("Nombre de usuario: ", sc);
        }

        // Solo pedimos la contraseña si el nombre ha pasado la validación
        password = UtilidadesTeclado.cadena("Contraseña: ", sc);

        if (isAdministrador) {
            nuevoUsuario = new Administrador(nombre, password);
        } else {
            nuevoUsuario = new Cliente(nombre, password);
        }

        usuarios.add(nuevoUsuario);
        nombres.add(nombre);
        return nuevoUsuario;
    }

    private static boolean buscarUsuario(String nombre) {
        return nombres.contains(nombre);
    }

    private static void mostrarProductos() {
        if (productos.size() == 0) {
            System.out.println("Lista de productos vacía");
            return;
        }
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    private static void mostrarProducto() {
        String texto = UtilidadesTeclado.cadena("Introduzca código o texto a buscar: ", sc).toLowerCase();
        boolean encontrado = false;
        for (Producto p : productos) {
            if (p.getDescripcion().toLowerCase().contains(texto) || Integer.toString(p.getCodigo()).equals(texto)) {
                System.out.println(p);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado");
        }
    }

    private static Producto buscarProducto(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    private static void altaModifProducto() {
        int codigo = UtilidadesTeclado.enteroRango("Intruduzca el código: ", 1, Integer.MAX_VALUE, sc);
        Producto producto = buscarProducto(codigo);
        if (producto != null) { // El producto existe
            int stock = UtilidadesTeclado.enteroRango("Introduzca nuevo stock: ", 0, Integer.MAX_VALUE, sc);
            producto.setStock(stock);
        } else { // Nuevo producto
            String descripcion = UtilidadesTeclado.cadena("Introduzca descripción: ", sc);
            int stock = UtilidadesTeclado.enteroRango("Introduzca stock inicial: ", 0, Integer.MAX_VALUE, sc);
            double precio = UtilidadesTeclado.doblePositivo("Introduzca precio: ", sc);
            productos.add(new Producto(codigo, descripcion, stock, precio));
        }
    }

    public static void login() {
        String nombre = UtilidadesTeclado.cadena("Intruduzca usuario: ", sc);
        String password = UtilidadesTeclado.cadena("Introduzca contraseña: ", sc);
        for (Usuario u : usuarios) {
            if (u.getNombre().equals(nombre) && u.getPassword().equals(password)) {
                usuario = u;
                System.out.println("Login correcto.");
                return;
            }
        }
        System.out.println("Credenciales incorrectas");
    }

    public static void comprar() {
        int codigo = UtilidadesTeclado.enteroRango("Introduzca código: ", 1, Integer.MAX_VALUE, sc);
        Producto p = buscarProducto(codigo);
        if (p != null) {
            int cantidad = UtilidadesTeclado.enteroRango("Introduzca cantidad: ", 1, Integer.MAX_VALUE, sc);
            if (cantidad <= p.getStock()) {
                p.setStock(p.getStock() - cantidad);
                gananciaTotal += cantidad * p.getPrecio();
            } else {
                System.out.printf("Stock insuficiente (%d unidades disponibles).\n", p.getStock());
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void cerrarAplicacion() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_GANANCIA));
                ObjectOutputStream oosU = new ObjectOutputStream(new FileOutputStream(FILE_USUARIOS));
                ObjectOutputStream oosP = new ObjectOutputStream(new FileOutputStream(FILE_PRODUCTOS))) {
            bw.write(Double.toString(gananciaTotal));
            oosU.writeObject(usuarios);
            oosP.writeObject(productos);
        } catch (IOException e) {
            System.out.println("Error al salvar la información: " + e.getMessage());
        }
    }
}
