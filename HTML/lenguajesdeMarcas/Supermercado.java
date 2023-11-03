import java.util.Scanner;

/**
 *
 * @author David
 */
public class Fruteria {

    public static void main(String[] args) {

        int n_clientes = Numero_clientes();// Mete el valor de la funcion Numero_clientes en una variable para usarla en el main 
        for (int i = 1; i <= n_clientes; i++) {// Hace un bucle en funcion del valor de los clientes que hayan  introducidos en la funcion Numero_clientes  
            System.out.println("Cliente " + i);
            int n_productos = pedir_n_productos(); // Mete el valor que devuelve  la funcion pedir_n_productos a una variable llamada n_productos.         
            double[] precios_cuenta = showShopinglist(n_productos);
            double suma_precios = precioTotal_SinIVA(precios_cuenta);
            double IVA = giveMeIVA(suma_precios); //Se introduce el precio total sin iva 
           CuentaTotal(suma_precios,IVA);
////             
        }
    }

    public static int Numero_clientes() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Introduzca el número de clientes: ");
        int n_clientes = sc.nextInt();
        return n_clientes;

    } // Funcion que pide el numero de clientes

    public static int pedir_n_productos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número de porductos que vas a introducir");
        int n_productos = sc.nextInt();
        return n_productos;

    } // Funcion que pide el numero de productos, que determinara la amplitud del array

    public static double[] showShopinglist(int tamaño_a) {
        Scanner sc = new Scanner(System.in);

        String producto;
        double precio;

        String[] productos = new String[tamaño_a]; //Crea dos arrays uno strig y otro double e
        double[] precios = new double[tamaño_a];
        for (int i = 0; i < productos.length; i++) {// por medio de un bucle for se pide al usuariore que rellene la lista 

            System.out.println("Introduce un producto : ");
            producto = sc.nextLine();
            productos[i] = producto;
            System.out.println("Introduzca el precio de dicho producto: ");
            precio = sc.nextDouble();
            sc.nextLine();
            precios[i] = precio;
            System.out.println("         ");
        }
        System.out.println(" La lista de los productos es : ");
        System.out.println("            ");
        for (int i = 0; i < precios.length; i++) { //Bucle que muestra a la vez los dos arrays correspondiendose en producto y su coste 
            System.out.println("Producto: " + productos[i] + "         Coste: " + precios[i] + "€");
        }
        return precios;
    } // Funcion que toma el tamaño pedido por pantalla de  la funcion pedir_n_productos y muestra la lista por medio de la siguiente sentencia. 

    public static double giveMeIVA(double precioTotal) {
        double PorcentajeIVA = 0.21;
        double IVA_sinAplicar = precioTotal * PorcentajeIVA;
        System.out.println("EL precio del IVA sin aplicar es : "+IVA_sinAplicar);
        return IVA_sinAplicar;

    }// Funcion que calcula el valor del IVA

    public static double precioTotal_SinIVA(double[] precios) {
        double suma = 0;

        for (int i = 0; i < precios.length; i++) {// For que recorre el array y suma todos sus elementos
            suma += precios[i]; 

        }
        System.out.println("El precio de la cuenta sin IVA es : " + suma);
        return suma;
    } // Funcion que recorre el array de los precios y los suma para dar el total sin IVA

    public static void CuentaTotal(double cuenta, double iva){
        double Cuenta_Total = cuenta+iva; // Suma la cuenta sin iva  y el iva
        System.out.println("El precio final de la cuenta es  " + Cuenta_Total);
        
    } // Funcion que da la cuenta final
}

// Fruteria 
/*
    Esyamos en un supermercado. Tenermos que hacer lo siguiente: Para cada cliente que entra
    tenemos que:
            Mostrar su lista de la compra con los precios 
            Mostrar finalmente el total 
            Debajo ponemos el 21% de iva
            y por ultimo el total de la factura 
    Para ello tenemos al siguiente lista de precios 
        Aceitunas ....2;
        Patatillas ....1,80;
        Detergente ..... 3;
        Whiskey .....15,20;
        Coca cola ..... 4,33;
        Lechuga .....0.90;
        Tomate ....... 8;
    Variante para los mas atrevidos :
    Pedir al usuario que introduzca los productos y su precio  
    Tenemos que usar el numero maximo que podamos 
    Funciones obligatiorias : showShoppinglist  
                              giveMeIVA
                              giveMeBill //Cuenta
    
    
 */
