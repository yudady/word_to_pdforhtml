package com.foya.pdf.create;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * create pdf
 * 
 * @author tommy
 *
 */
public class HelloWorldExample {

	public static void main(String[] args) throws Exception {

		Document document = new Document(PageSize.A4);  

		PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));

		document.open();

		BaseFont bf = BaseFont.createFont(
				"F:/foya/word_to_pdforhtml/src/main/resources/ttf/kaiu.ttf",
				BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		// 設定中文字型(BaseFont、字型大小、字型型態)
		Font chineseFont = new Font(bf, 12, Font.NORMAL);
		BaseFont bfChinese = BaseFont.createFont( "STSongStd-Light" ,  "UniGB-UCS2-H" ,  false );  
		//Font fontChinese =  new  Font(bfChinese,12,Font.NORMAL,Color.GREEN);  
        Font fontChinese =  new  Font(bfChinese  ,  12 , Font.NORMAL, BaseColor.RED); 
		
		document.add(new Paragraph("A Hello World PDF document.",chineseFont));
		// 套用中文字型
		document.add(new Phrase("這是中文   珉、峯、喆", fontChinese));

		document.close(); // no need to close PDFwriter?

	}
}