package com.peoplewelfare.utility;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.peoplewelfare.controller.PdfGeneratorController;
import com.peoplewelfare.model.PersonDetail;
import org.apache.log4j.Logger;

public class PDFBuilder extends AbstractITextPdfView {

    static Logger LOGGER = Logger.getLogger(PDFBuilder.class);

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
                                    PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        List<PersonDetail> listOfPerson = (List<PersonDetail>) model.get("PersonDetail");



        for (PersonDetail personDetail : listOfPerson) {
            LOGGER.info(personDetail.getPersonFirstName());
        }


        doc.add(new Paragraph("Recommended books for Spring framework"));

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {1.0f, 2.0f, 2.0f, 3.0f, 1.0f});
        table.setSpacingBefore(10);

        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);

        // write table header
        cell.setPhrase(new Phrase("Person ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("First Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Last Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Address", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Price", font));
        table.addCell(cell);

        // write table row data
        for (PersonDetail personDetail : listOfPerson) {
            table.addCell(personDetail.getPersonId());
            table.addCell(personDetail.getPersonFirstName());
            table.addCell(personDetail.getPersonLastName());
            table.addCell(personDetail.getEmailAddress());
            table.addCell("1000");
        }

        doc.add(table);

    }

}



