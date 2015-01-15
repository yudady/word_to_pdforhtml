package com.foya.rtf.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

public class RtfFile {
	
	public static void main(String[] args) throws Exception {
		String result = null;
		File file = new File("F:/foya/bonus_project/BONUS/2系統分析/Activity.rtf");
		DefaultStyledDocument styledDoc = new DefaultStyledDocument();
		InputStream is = new FileInputStream(file);
		new RTFEditorKit().read(is, styledDoc, 0);
		result = new String(styledDoc.getText(0, styledDoc.getLength())
				.getBytes("ISO8859_1"));
		System.out.println(result);

	}
}
