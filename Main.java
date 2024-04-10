import java.util.Scanner; //Importar Scanner
import programa.*; //Importar paquete

public class Main {

    //CONSTANTES
    public static final int N = 5; //Longitud del array

    //SCANNER
    static Scanner escaner = new Scanner(System.in); //Crear objeto Scanner

    public static void main(String[] args){

//====================================DECLARACIONES===========================================

        int eleccion; //Variable que guarda la eleccion en el menu

        Articulo[] articulos = new Articulo[N]; //Array de objetos

//====================================PROGRAMA================================================

        //Menú
        do {
            System.out.println("\nGESTIón SIMplificada de Almacén");
            System.out.println("===============================");
            System.out.println("1. Listado");
            System.out.println("2. Alta");
            System.out.println("3. Baja");
            System.out.println("4. Modificación");
            System.out.println("5. Entrada de mercancía");
            System.out.println("6. Salida de mercancía");
            System.out.println("7. Salir");
            eleccion = escaner.nextInt();

            //Buscar la posicion vacia del array
            int hueco = comprobar_hueco(articulos);

            //Acciones menu
            switch (eleccion) {

                case 1 :
                    System.out.println("\n1. Listado");
                    System.out.println("==========");

                    listado(articulos, hueco);

                    break;

                case 2 :
                    System.out.println("\n2. Alta");
                    System.out.println("=======");

                    alta(articulos, hueco);

                    break;

                case 3 :
                    System.out.println("\n3. Baja");
                    System.out.println("=======");

                    baja(articulos, hueco);

                    break;

                case 4 :
                    System.out.println("\n4. Modificación");
                    System.out.println("===============");

                    modificacion(articulos, hueco);

                    break;

                case 5 :
                    System.out.println("\n5. Entrada de mercancía");
                    System.out.println("=======================");

                    entrada_salida(articulos, hueco, eleccion);

                    break;

                case 6 :
                    System.out.println("\n6. Salida de mercancía");
                    System.out.println("======================");

                    entrada_salida(articulos, hueco, eleccion);

                    break;

                case 7 :
                    break;

                default :
                    System.out.println("Opción inválida" );
            }

        } while (eleccion != 7);

    }

//====================================MÉTODOS==========================================
    public static int comprobar_hueco(Articulo[] articulos){
        int hueco = N;
        for (int a = 0; a < N; a++) {
            if (articulos[a] == null){
                hueco = a;
                break;
            }
        }
        return hueco;
    }

    public static boolean comprobar_artículos (int hueco){
        boolean hay = true;
        if (hueco == 0){
            System.out.println("ERROR: No hay artículos");
            hay = false;
        }
        return hay;
    }

    public static int buscar_codigo(Articulo[] articulos, int hueco){
        int posicion = -1;

        listado(articulos, hueco);
        System.out.println("\n Dime el código del artículo");
        int codigo = escaner.nextInt();

        for (int a = 0; a < hueco; a++) {
            if (articulos[a].getCodigo() == codigo){
                posicion = a;
            }
        }
        return posicion;
    }

    public static void ordenar_array(Articulo[] articulos){
        int vacio = 100;
        for (int a = 0; a < N; a++) {
            //Buscar le primer hueco vacio
            if (articulos[a] == null){
                vacio = a;
            }

            //Si no está vacio...
            if (articulos[a] != null){

                //Me aseguro de que esté después del espacio vacío iniciandolo en 100
                if (a > vacio){
                    //Intercambio el lleno de alante con el vacío de atrás y pongo vacio el de alante
                    articulos[vacio] = articulos[a];
                    articulos[a] = null;
                    //Y sumo 1 a vacío para no pisar el que acabo de modificar
                    vacio++;
                }
            }
        }
    }

//====================================CASE 1==========================================
    public static void listado(Articulo[] articulos, int hueco){
        //Comprobar si hay artículos
        if (comprobar_artículos(hueco)){

            //Mostrar los que no son null
            /*for (int a = 0; a < N; a++) {
                if (articulos[a] != null){
                    System.out.println(articulos[a]);
                }
            }*/

            //Mostrar huecos vacios
            for (int a = 0; a < N; a++) {
                if (articulos[a] != null){
                    System.out.println(articulos[a]);
                } else {
                    System.out.println("Espacio vacio");
                }
            }
        }
    }

//====================================CASE 2==========================================
    public static void alta(Articulo[] articulos, int hueco){
        //Comprobar si hay hueco
        if (hueco == N){
            System.out.println("ERROR: No caben más artículos");
        } else {

            //Pedir datos
            escaner.nextLine();
            System.out.println("Dime la descripcion del articulo:");
            String descripcion = escaner.nextLine();

            //En caso de poner un código secreto se crea automaticamente
            if (descripcion.equals("qwer")){
                for (int a = 0; a < N; a++) {
                    articulos[a] = new Articulo("Fantasma"+(a+1), 100, 100, 100);
                }

            } else {

                //Pedir datos
                System.out.println("Dime el precio de compra");
                float precio_compra = escaner.nextFloat();

                System.out.println("Dime el precio de venta");
                float precio_venta = escaner.nextFloat();

                System.out.println("Dime el stock");
                int stock = escaner.nextInt();

                //Crear producto
                articulos[hueco] = new Articulo(descripcion, precio_compra, precio_venta, stock);
            }

        }
    }

//====================================CASE 3==========================================
    public static void baja(Articulo[] articulos, int hueco){

        //Comprobar si hay artículos
        if (comprobar_artículos(hueco)){

            //Conseguir posicion
            int posicion = buscar_codigo(articulos, hueco);

            //Comprobar que se ha encontrado el articulo
            if (posicion == -1){
                System.out.println("ERROR: No se ha encontrado un artículo con ese código");
            } else {

                //Borrar
                articulos[posicion] = null;
                System.out.println("Borrado con exito");

                //Ordenar la lista
                ordenar_array(articulos);
            }
        }
    }

//====================================CASE 4==========================================
    public static void modificacion(Articulo[] articulos, int hueco){

        //Comprobar si hay artículos
        if (comprobar_artículos(hueco)){

            //Conseguir posicion
            int posicion = buscar_codigo(articulos, hueco);

            //Comprobar que se ha encontrado el articulo
            if (posicion == -1){
                System.out.println("ERROR: No se ha encontrado un artículo con ese código");
            } else {

                //Preguntar qué quiere modificar
                System.out.println("Elige qué modificar:");
                System.out.println("1. Descripcion");
                System.out.println("2. Precio de compra");
                System.out.println("3. Precio de venta");
                System.out.println("4. Salir");
                int eleccion = escaner.nextInt();

                //Ejecutar la eleccion
                switch (eleccion) {

                    case 1 :
                        escaner.nextLine();
                        System.out.println("\n Dime la nueva descripcion");
                        String descripcion = escaner.nextLine();

                        articulos[posicion].setDescripcion(descripcion);

                        break;

                    case 2 :
                        System.out.println("\nDime el nuevo precio de compra");
                        float precio_compra = escaner.nextFloat();

                        articulos[posicion].setPrecio_compra(precio_compra);

                        break;

                    case 3 :
                        System.out.println("\nDime el nuevo precio de venta");
                        float precio_venta = escaner.nextFloat();

                        articulos[posicion].setPrecio_compra(precio_venta);

                        break;

                    case 4 :
                        break;

                    default :
                        System.out.println("Opción inválida" );
                }
            }
        }
    }

//====================================CASE 5 y 6==========================================
    public static void entrada_salida(Articulo[] articulos, int hueco, int eleccion){
        //Comprobar que hay artículos
        if (comprobar_artículos(hueco)){

            //Conseguir posicion
            int posicion = buscar_codigo(articulos, hueco);

            //Comprobar que se ha encontrado el articulo
            if (posicion == -1){
                System.out.println("ERROR: No se ha encontrado un artículo con ese código");
            } else {

                //Preguntar cuanto entra
                System.out.println("Dime la cantidad");
                int stock = escaner.nextInt();

                //Comprobar si hay que meter o sacar
                if (eleccion == 5){
                    articulos[posicion].entrada(stock);
                } else {
                    articulos[posicion].salida(stock);
                }
            }
        }
    }
}