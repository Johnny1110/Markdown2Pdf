package com.Johnny.Markdown2Pdf.convertSupporter;

public interface Converter<I, T> {
	
	public T convert(I input);

}
