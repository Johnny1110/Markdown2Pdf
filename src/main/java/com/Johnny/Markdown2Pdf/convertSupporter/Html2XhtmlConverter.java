package com.Johnny.Markdown2Pdf.convertSupporter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.w3c.tidy.Tidy;

public class Html2XhtmlConverter implements Converter<String, String> {
	private static final String ENCODING = "UTF-8";

	@Override
	public String convert(String input)throws RuntimeException{
		try {
			ByteArrayInputStream stringAsStream = new ByteArrayInputStream(input.getBytes(ENCODING));
			ByteArrayOutputStream outputAsStream = new ByteArrayOutputStream();
	        Tidy xhtmlBuilder = new Tidy();
	        xhtmlBuilder.setXHTML(true);
	        xhtmlBuilder.setCharEncoding(0);
	        xhtmlBuilder.parse(stringAsStream, outputAsStream);
	        String result = outputAsStream.toString(ENCODING).trim();
	        return result;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("HTML 轉 XHTML 失敗。");
		}
	}

}
