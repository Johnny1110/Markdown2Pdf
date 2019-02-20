package com.Johnny.Markdown2Pdf.fileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

/*
 * MarkdownFiletoStringReader 實例化時會直接把 markdown 內容 轉成 String
 * 如果傳入的不是 markdown 檔案，會拋出 RuntimeException。
 * getMarkdownFile() 可以把 markdown 轉好的 String 傳出。
 */

public class MarkdownFiletoStringReader implements Markdown2PdfReader {
	private String StringOfMarkdown;

	public MarkdownFiletoStringReader (File markdownFile) throws IOException {
		if (isMarkdownFile(markdownFile.getName())) {
			this.StringOfMarkdown = getStringOfMarkdown(markdownFile);							 
		}else {
			throw new RuntimeException("檔案讀取錯誤，指允許讀取MD檔。");
		}
	}
	
	@Override
	public String getConvertedContext() {
		return StringOfMarkdown;
	}

	private String getStringOfMarkdown(File markdownFile) throws IOException {
		BufferedReader fileReader = new BufferedReader(new FileReader(markdownFile));
		StringBuilder sb = new StringBuilder();
		String reader = new String();
		while((reader = fileReader.readLine()) != null) {
			sb.append(reader + "\n");
		}
		return sb.toString();
	}

	private boolean isMarkdownFile(String filename) {
		return filename.substring(filename.lastIndexOf(".") + 1)
					   .equals("md");
	}

}
