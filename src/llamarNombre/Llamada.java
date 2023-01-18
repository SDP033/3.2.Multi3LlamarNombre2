package llamarNombre;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Llamada {

	public static void main(String[] args) throws IOException {

		File directorio = new File("C:\\Users\\sergi\\eclipse-workspace\\3.2.Multi3CrearNombre2\\bin");

		ProcessBuilder pb = new ProcessBuilder("java.exe", "crearNombre2.Nombre");

		pb.directory(directorio);

		File fInp = new File("dato.txt");
		pb.redirectInput(fInp);
		pb.start();

		Process p = pb.start();
		int salida = -1;
		try {
			salida = p.waitFor();
			System.out.println("Valor de Salida: " + salida);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (salida == 0) {
			try {

				InputStream is = p.getInputStream();

				int c;
				while ((c = is.read()) != -1)
					System.out.print((char) c);
				is.close();
				System.exit(0);

			} catch (Exception e) {
				System.exit(-1);
				e.printStackTrace();
			}
		}
	}
}
