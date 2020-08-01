package com.trustin.docgeneration.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Component;

@Component
public class DocGenerationService {

	public void generate(String data) throws IOException {
		XWPFDocument document = new XWPFDocument(); 
		String fileName = new Date().toInstant().toString() + ".docx";
		FileOutputStream out = new FileOutputStream( new File(fileName));
		
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
	    run.setText("This is the old text. I'm adding the data from API here -> " + data );
		
		document.write(out);
		out.close();
		System.out.println(fileName + " written successully");
	}
}
