//importar las librerias que vamos a usar
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneraLog {
    public void guardarJson(List<String> lista) {
        try {
            FileWriter fileWriter = new FileWriter("convertidor_monedas.txt");
            for (String resultado : lista) {
                fileWriter.write(resultado);
                fileWriter.write("\n");
            }
            fileWriter.close();
            System.out.println("Consulta correctamente guardada en archivo 'convertidor_monedas.txt'");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo de consultas: " + e.getMessage());
        }
    }
}
