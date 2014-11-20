package stream;

import java.io.IOException;
import java.io.OutputStream;

public class Generate {

	public static void main(String[] args) {
		try (OutputStream out = System.out) {
			generateCharacters(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void generateCharacters(OutputStream out) throws IOException {
		int firstPrintable = 33;
		int offset = 0;
		int lineWidth = 72;
		int range = 94;
		byte[] line = new byte[lineWidth + 2];
		for(int r = 0; r < 30; r++) {
			for(int i = 0; i < lineWidth; i++) {
				line[i] = (byte)(firstPrintable + offset + i);
			}
			offset = (offset + 1) % range;
			line[72] = (byte)'\r';
			line[73] = (byte)'\n';
			out.write(line);
		}
		out.flush();
	}
}
