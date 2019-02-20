package com.Johnny.Markdown2Pdf.convertSupporter;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import com.pdfcrowd.Pdfcrowd;

public class Xhtml2PdfConverter implements Converter<String, byte[]> {

	@Override
	public byte[] convert(String input) throws RuntimeException {
		try {
			ITextRenderer renderer = new ITextRenderer();
			try {
				 ITextFontResolver fontResolver = renderer.getFontResolver();
				 fontResolver.addFont("c:/git/simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			} catch (IOException e) {
				e.printStackTrace();
			}
			renderer.setDocumentFromString(input);
			renderer.layout();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			renderer.createPDF(outputStream);
			byte[] bytes = outputStream.toByteArray();
			return bytes;
		} catch (DocumentException e) {
			throw new RuntimeException("XHTML 轉 PDF 失敗。");
		}

	}

}
