package com.foya.pdf.read;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;


/**
 * pdfbox read
 * @author tommy
 *
 */
public class PdfReaderOneFile {

	private static String pdfFilePath = "F:/foya/word_to_pdforhtml/pdf/quartz 時間配置規則.pdf";

	public static void main(String[] args) throws IOException {

		String result = null;
		FileInputStream is = null;
		PDDocument document = null;
		try {
			is = new FileInputStream(pdfFilePath);
			PDFParser parser = new PDFParser(is);
			parser.parse();
			document = parser.getPDDocument();
			PDFTextStripper stripper = new PDFTextStripper();
			result = stripper.getText(document);
		} finally {
			if (is != null) {
				is.close();
			}
			if (document != null) {
				document.close();
			}
			System.out.println(result);
		}
	}
}
