package main;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.Johnny.Markdown2Pdf.converter.Markdown2PdfConveter;

public class Main {

	public static void main(String[] args) {
		Path mdPath = Paths.get("c:\\git\\README.md");
		Path pdfPath = Paths.get("c:\\git\\readme.pdf");
		Markdown2PdfConveter m2p = new Markdown2PdfConveter();
		try {
			m2p.readFile(mdPath);
			m2p.doConvert();
			m2p.writeTo(pdfPath);
			m2p.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
