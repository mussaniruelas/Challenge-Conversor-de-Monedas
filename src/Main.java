import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        MonedaApi consulta = new MonedaApi();

        System.out.println("Puede escoger de las siguientes opciones");
        System.out.println("Debera escribir las opciones");
        System.out.println("BOB)  Boliviano");
        System.out.println("USD)  Dolar");
        System.out.println("EUR)  Euro");
        System.out.println("JPY)  Yen Japones");
        System.out.println("ARS)  Peso Argentino");
        System.out.println("CLP)  Peso Chileno");
        System.out.println("COP)  Peso Colombiano");
        System.out.println("MXN)  Peso Mexicano");
        System.out.println("0) salir");

        while ( true ){
            System.out.println("Escoja la Moneda de origen");
            String origen = input.nextLine();

            if(origen.equals("0")){
                System.out.println("Fin de la Aplicacion");
                System.out.println("Nos vemos muy pronto :D");
                break;
            }

            System.out.println("Escoja la Moneda de cambio");
            String cambio= input.nextLine();

            System.out.println("Introdusca el monto");
            double monto = Double.valueOf(input.nextLine());

            Moneda moneda = consulta.Cambio(origen, cambio, monto);
            System.out.println(monto + "[" + cambio.toUpperCase() + "] = "
                    + moneda.conversion_result() + "[" + cambio.toUpperCase() + "]" );
        }
    }
}