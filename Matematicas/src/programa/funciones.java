package programa;

public class funciones {
	public static boolean esCapicua(int x){
	       boolean capicua = false;
	       if (x < 10){
	           capicua = true;
	       }


	       if (x >= 10 && x < 100){
	           if (x / 10 == x % 10){
	               capicua = true;
	           }
	       }


	       if (x >= 100 && x < 1000){
	           if (x / 100 == x % 10){
	               capicua = true;
	           }


	       }


	       if (x >= 1000 && x < 10000){
	           if ((x / 1000 == x % 10) && ((x / 100) % 10 == (x / 10 % 10))){
	               capicua = true;
	           }


	       }


	       if (x >= 10000 && x < 100000){
	           if ((x / 10000 == x % 10) && ((x / 1000) % 10 == (x / 10 % 10))){
	               capicua = true;
	           }
	       }


	       return capicua;
	   }


	   public static boolean esPrimo(int x) {
	       for (int i = 2; i < x; i++) {
	           if ((x % i) == 0) {
	               return false;
	           }
	       }
	       return true;
	   }


	   public static int siguientePrimo(int x){
	       int a, cont = 0;
	       boolean primo = false;
	       while (!primo){
	           x++;


	           primo = esPrimo(x);


	       }


	       return x;
	   }


	   public static int potencia(int base, int exponente){
	       int total = 1, a;


	       for (a = 0; a < exponente; a++) {
	           total *= base;
	       }
	       return total;
	   }


	   public static int digitos(int x){
	       int digitos = 0;
	       while (x != 0){
	           x /= 10;
	           digitos ++;
	       }
	       return digitos;
	   }


	   public static int voltea(int x){
	       int resultado = 0, numero;


	       while (x != 0){
	           numero = x % 10;
	           x /= 10;
	           resultado = resultado * 10 + numero;
	       }
	       return resultado;
	   }


	   public static int digitoN(int numero, int posicion){
	       int volteado = voltea(numero), a, digito = 0;


	       for (a = 0; a < posicion+1; a++) {
	           digito = volteado % 10;
	           volteado /= 10;
	       }
	       return digito;


	   }


	   public static int posicionDeDigito(int numero, int digito){
	       int posicion = 0;
	       while (numero != 0){
	           if (digito == numero % 10){
	               numero = 0;
	           } else {
	               posicion++;
	               numero /= 10;
	           }


	       }
	       return posicion;
	   }


	   public static int quitaPorDetras(int numero, int cantidad){
	       int a;
	       for (a = 0; a < cantidad; a++) {
	           numero /= 10;
	       }
	       return numero;
	   }


	   public static int quitaPorDelante(int numero, int cantidad){
	       int a;
	       numero = voltea(numero);
	       for (a = 0; a < cantidad; a++) {
	           numero /= 10;
	       }
	       return voltea(numero);
	   }


	   public static int pegaPorDetras(int numero, int digito){
	       return numero * 10 + digito;
	   }


	   public static int pegaPorDelante(int numero, int digito){
	       numero = voltea(numero);
	       numero = numero * 10 + digito;
	       return voltea(numero);
	   }


	   public static int trozoDeNumero(int numero, int primero, int ultimo){
	       int a, resultado = 0;
	       numero = voltea(numero);
	       for (a = 0; a < primero+1; a++) {
	           numero /= 10;
	       }
	       for (a = primero+1; a < ultimo; a++) {
	           resultado = (resultado *10) + (numero % 10);
	           numero /= 10;
	       }
	       return resultado;
	   }


	   public static int juntaNumeros(int n1, int n2){
	       int longitud = 0, auxiliar, resultado;
	       auxiliar = n2;
	       while (auxiliar != 0){
	           auxiliar /= 10;
	           longitud++;
	       }
	       resultado = (n1 * ((int) Math.pow(10, longitud)))+n2;
	       return resultado;


	   }

}
