// Importar librerias necesarias
import com.google.gson.JsonSyntaxException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int eleccionUsuario = 0;

        // Clase que realiza la consultarApi a la API.
        ConsultaApi respuestaApi = new ConsultaApi();
        //Pasar la clase a la API para traer la respuesta/
        CalcularTipoCambio calculoTipoCambio = new CalcularTipoCambio(respuestaApi);
        GeneraLog generador = new GeneraLog();

        List<String> respuestas = new ArrayList<>();

        String menu = """
                \n
                ****** Seleccione la Operación a Realizar ******
                
                1) Peso Mexicano a USA Dólar
                2) Peso Mexicano a Euro
                3) Peso Mexicano a Libra Esterlina
                4) USA Dólar a Peso Mexicano
                5) Euro a Peso Mexicano
                6) Libra Esterlina a Peso Mexicano
                
                7) Otras opciones
                
                8) Salir
              
                """;

        while (eleccionUsuario != 8) {
            try {
                System.out.println(menu);
                eleccionUsuario = Integer.parseInt(lectura.nextLine());

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                switch (eleccionUsuario) {
                    case 1:
                        calculoTipoCambio.guardarValores("MXN", "USD");
                        respuestas.add(formattedDate + " - " + calculoTipoCambio.obtenerMensajeRespuesta());
                        break;
                    case 2:
                        calculoTipoCambio.guardarValores("MXN", "EUR");
                        respuestas.add(formattedDate + " - " + calculoTipoCambio.obtenerMensajeRespuesta());
                        break;
                    case 3:
                        calculoTipoCambio.guardarValores("MXN", "GBP");
                        respuestas.add(formattedDate + " - " + calculoTipoCambio.obtenerMensajeRespuesta());
                        break;
                    case 4:
                        calculoTipoCambio.guardarValores("USD", "MXN");
                        respuestas.add(formattedDate + " - " + calculoTipoCambio.obtenerMensajeRespuesta());
                        break;
                    case 5:
                        calculoTipoCambio.guardarValores("EUR", "MXN");
                        respuestas.add(formattedDate + " - " + calculoTipoCambio.obtenerMensajeRespuesta());
                        break;
                    case 6:
                        calculoTipoCambio.guardarValores("GBP", "MXN");
                        respuestas.add(formattedDate + " - " + calculoTipoCambio.obtenerMensajeRespuesta());
                        break;
                    case 7:
                        calculoTipoCambio.guardarValoresPersonalizados();
                        respuestas.add(formattedDate + " - " + calculoTipoCambio.obtenerMensajeRespuesta());
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Ingrese una opción válida");
                }
            } catch (JsonSyntaxException | NullPointerException e) {
                System.out.println("Error. El código de moneda no es válido.");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Error. Ingrese un valor válido.");
            }
        }
        generador.guardarJson(respuestas);

        System.out.println("Salir del programa");
    }
}