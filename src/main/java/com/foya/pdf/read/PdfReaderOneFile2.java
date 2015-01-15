package com.foya.pdf.read;

import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;



/**
 * itextpdf read
 * @author tommy
 *
 */
public class PdfReaderOneFile2 {

	public static void main(String[] args) throws IOException {
		PdfReader reader = new PdfReader(
				"F:/foya/word_to_pdforhtml/pdf/quartz 時間配置規則.pdf"); // 讀取pdf所使用的輸出流

		int num = reader.getNumberOfPages();// 獲得頁數

		String content = ""; // 存放讀取出的文檔內容

		for (int i = 1; i < num; i++) {

			content += PdfTextExtractor.getTextFromPage(reader, i); // 讀取第i頁的文檔內容
		}
		System.out.println(content);
	}
}
