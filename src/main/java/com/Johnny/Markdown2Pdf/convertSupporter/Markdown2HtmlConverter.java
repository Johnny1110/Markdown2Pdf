package com.Johnny.Markdown2Pdf.convertSupporter;

import java.io.IOException;

import org.markdown4j.Markdown4jProcessor;

public class Markdown2HtmlConverter implements Converter<String, String> {

	@Override
	public String convert(String input) throws RuntimeException {
		try {
			String result = new Markdown4jProcessor().process(input).trim();
			return new String(result.getBytes(), "UTF-8");
		} catch (IOException e) {
			throw new RuntimeException("md 轉 html 失敗。");
		}
	}

}
