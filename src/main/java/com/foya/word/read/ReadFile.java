package com.foya.word.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hwpf.extractor.WordExtractor;

public class ReadFile {
	public static void main(String[] args) {
		try {
			// word 2003： 图片不会被读取
			InputStream is = new FileInputStream(
					new File("F:/foya/word_to_pdforhtml/src/main/resources/doc/SMIG-FTP上載界面規格.doc"));
			WordExtractor ex = new WordExtractor(is);
			String text2003 = ex.getText();
			System.out.println(text2003);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
