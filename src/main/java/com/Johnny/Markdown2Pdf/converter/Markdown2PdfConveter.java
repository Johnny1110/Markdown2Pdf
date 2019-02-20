package com.Johnny.Markdown2Pdf.converter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import com.Johnny.Markdown2Pdf.convertSupporter.Html2XhtmlConverter;
import com.Johnny.Markdown2Pdf.convertSupporter.Markdown2HtmlConverter;
import com.Johnny.Markdown2Pdf.convertSupporter.Xhtml2PdfConverter;
import com.Johnny.Markdown2Pdf.fileReader.Markdown2PdfReader;
import com.Johnny.Markdown2Pdf.fileReader.MarkdownFiletoStringReader;

public class Markdown2PdfConveter {
	private String markdown;
	private byte[] pdf;
	private Markdown2HtmlConverter markdown2htmlConverter;
    private Html2XhtmlConverter html2XhtmlConverter;
    private Xhtml2PdfConverter xhtml2PdfConverter;
	
	public Markdown2PdfConveter() {
		this.markdown2htmlConverter = new Markdown2HtmlConverter();
		this.html2XhtmlConverter = new Html2XhtmlConverter();
		this.xhtml2PdfConverter = new Xhtml2PdfConverter();
		
	}
	
	public void readFile(Path path) throws IOException {
		File mdFile = path.toFile();
		Markdown2PdfReader markdownReader = new MarkdownFiletoStringReader(mdFile);
		this.markdown = markdownReader.getConvertedContext();
	}
	
	public void doConvert() throws IOException {
		String html = markdown2htmlConverter.convert(markdown);
		String xhtml = html2XhtmlConverter.convert(html);
		byte[] pdf = xhtml2PdfConverter.convert(xhtml);
		this.pdf = pdf;
	}
	
	public void writeTo(Path destination) throws IOException {
		File file = destination.toFile();
		FileUtils.writeByteArrayToFile(file, pdf);
	}
	
	public void destroy() {
		markdown = null;
		pdf = null;
		markdown2htmlConverter = null;
		html2XhtmlConverter = null;
		xhtml2PdfConverter = null;
	}

}
