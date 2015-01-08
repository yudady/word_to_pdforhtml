package com.foya.word.to.html;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class ResumeToHTML {

	public static void main(String[] args) {
		createHTML();
		createHTML();
	}

	private static void createHTML() {
		try {
			long start = System.currentTimeMillis();

			// 1) Load DOCX into XWPFDocument
			InputStream is = new FileInputStream(new File(
					"docx/Resume.docx"));
			XWPFDocument document = new XWPFDocument(is);

			// 2) Prepare Html options
			XHTMLOptions options = XHTMLOptions.create();
			
			// 3) Convert XWPFDocument to HTML
			OutputStream out = new FileOutputStream(new File(
					"html/Resume.html"));
			XHTMLConverter.getInstance().convert(document, out, options);
			System.err.println("Generate html/Resume.html with "
					+ (System.currentTimeMillis() - start) + "ms");

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
