package com.foya.word.to.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Base {

	private static final String NAME = "quartz 時間配置規則";

	public static void main(String[] args) {
		createPDF();
	}

	private static void createPDF() {
		try {

			String path = Base.class.getClassLoader()
					.getResource(".").getPath();
			System.out.println(path);
			String outputPath = new File(".").getAbsolutePath();
			outputPath = outputPath.replace(".", "");
			System.out.println(outputPath);


			// 1) Load DOCX into XWPFDocument
			InputStream is = new FileInputStream(new File(path + "docx/" + NAME
					+ ".docx"));
			XWPFDocument document = new XWPFDocument(is);

			// 2) Prepare Pdf options
			PdfOptions options = PdfOptions.create();

			// 3) Convert XWPFDocument to Pdf
			OutputStream out = new FileOutputStream(new File(outputPath
					+ "pdf/" + NAME + ".pdf"));
			PdfConverter.getInstance().convert(document, out, options);
			System.out.println("ok");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
