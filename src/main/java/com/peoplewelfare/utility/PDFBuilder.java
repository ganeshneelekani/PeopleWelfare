package com.peoplewelfare.utility;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.peoplewelfare.model.PersonDetail;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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

        PdfPCell text = new PdfPCell();
        text.setPaddingBottom(15);
        text.setPaddingLeft(10);
        text.setBorder(Rectangle.BOTTOM);
        text.setBorderColor(BaseColor.LIGHT_GRAY);
        text.addElement(new Phrase("iText PDF Header Footer Example", new Font(Font.FontFamily.HELVETICA, 12)));
        text.addElement(new Phrase("https://memorynotfound.com", new Font(Font.FontFamily.HELVETICA, 8)));

        doc.add(new Paragraph("Recommended books for Spring framework1"));

        doc.add(text);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{1.0f, 2.0f, 2.0f, 3.0f, 1.0f});
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



