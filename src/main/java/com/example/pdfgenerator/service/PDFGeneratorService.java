package com.example.pdfgenerator.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class PDFGeneratorService {
    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());

        document.open();
        Font fontForTitle = FontFactory.getFont(FontFactory.COURIER);
        fontForTitle.setSize(30);

        Paragraph paragraph = new Paragraph("Title of the PDF.", fontForTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontForParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontForParagraph.setSize(16);

        Paragraph paragraph1 = new Paragraph("Paragraph is here.");
        paragraph1.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(paragraph1);
        document.close();


    }

}
