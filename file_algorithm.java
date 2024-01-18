package HashCalculator;
import java.io.*;
import java.security.NoSuchAlgorithmException;

public class file_algorithm {
	static StringBuilder build = new StringBuilder();

	public StringBuilder getfile_algorithm(String path) throws IOException, NoSuchAlgorithmException {
		String st;
		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));

		while ((st = br.readLine()) != null) {
			build.append(st).append("\n");
		}
		return build;
	}

}
