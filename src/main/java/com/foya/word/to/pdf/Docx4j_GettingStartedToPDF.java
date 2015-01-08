package com.foya.word.to.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Docx4j_GettingStartedToPDF {

	public static void main(String[] args) {
		createPDF();
		createPDF();
	}

	private static void createPDF() {
		try {
			long start = System.currentTimeMillis();

			// 1) Load DOCX into XWPFDocument
			InputStream is = new FileInputStream(new File(
					"docx/Docx4j_GettingStarted.docx"));
			XWPFDocument document = new XWPFDocument(is);

			// 2) Prepare Pdf options
			PdfOptions options = PdfOptions.create();

			// 3) Convert XWPFDocument to Pdf
			OutputStream out = new FileOutputStream(new File(
					"pdf/Docx4j_GettingStarted.pdf"));
			PdfConverter.getInstance().convert(document, out, options);
			
			System.err.println("Generate pdf/Docx4j_GettingStarted.pdf with "
					+ (System.currentTimeMillis() - start) + "ms");
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
