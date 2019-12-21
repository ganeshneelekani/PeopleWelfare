package com.peoplewelfare.utility;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.peoplewelfare.model.PersonDetail;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PDFBuilder extends AbstractITextPdfView {

    static Logger LOGGER = Logger.getLogger(PDFBuilder.class);

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
                                    PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        List<PersonDetail> listOfPerson = (List<PersonDetail>) model.get("personDetailList");
        PersonDetail pd = (PersonDetail) model.get("personDetail");

        int distributionAmount=(int)model.get("distributionAmount");


        for (PersonDetail personDetail : listOfPerson) {
            LOGGER.info(personDetail.getPersonFirstName());
        }



        Rectangle rect = new Rectangle(577, 825, 18, 15); // you can resize rectangle
        rect.enableBorderSide(1);
        rect.enableBorderSide(2);
        rect.enableBorderSide(4);
        rect.enableBorderSide(8);
        rect.setBorderColor(BaseColor.RED);
        rect.setBorderWidth(1);
        doc.add(rect);

        PdfPCell text = new PdfPCell();
        text.setPaddingBottom(15);
        text.setPaddingLeft(10);
        text.setBorder(Rectangle.BOTTOM);
        text.setBorderColor(BaseColor.LIGHT_GRAY);
        text.addElement(new Phrase("iText PDF Header Footer Example", new Font(Font.FontFamily.HELVETICA, 12)));
        text.addElement(new Phrase("https://memorynotfound.com", new Font(Font.FontFamily.HELVETICA, 8)));

        Font orange = new Font(Font.FontFamily.HELVETICA, 30.0f, Font.BOLDITALIC, BaseColor.ORANGE);
        Font darkGrey = new Font(Font.FontFamily.HELVETICA, 13.0f, Font.BOLDITALIC, BaseColor.DARK_GRAY);
        Font header = new Font(Font.FontFamily.HELVETICA, 12.0f, Font.BOLD, BaseColor.DARK_GRAY);

        Paragraph preface = new Paragraph("     People Welfare foundation", orange);
        preface.setAlignment(Element.ALIGN_CENTER);
        doc.add(preface);

        doc.add(text);

        PdfPTable table1 = new PdfPTable(3);
        table1.setWidthPercentage(100.0f);
        table1.setWidths(new float[]{2.5f, 2.5f, 3.0f});
        table1.setSpacingBefore(20);

        doc.add(new Paragraph(" ", darkGrey));
        doc.add(new Paragraph(" ", darkGrey));
        doc.add(new Paragraph("Donor Code - " + pd.getPersonId(), darkGrey));
        doc.add(new Paragraph("Name            - " + pd.getPersonFirstName() + " " + pd.getPersonLastName(), darkGrey));

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        doc.add(new Paragraph("Date              - " + formatter.format(date), darkGrey));

        doc.add(table1);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{1.0f, 2.5f, 2.5f, 1.0f});
        table.setSpacingBefore(20);


        Font grey = new Font(Font.FontFamily.HELVETICA, 10.0f, Font.BOLD, BaseColor.GRAY);


        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setPadding(5);

        cell.setPhrase(new Phrase(" ", header));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name", header));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell.setPhrase(new Phrase("Address", header));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell.setPhrase(new Phrase("Amount", header));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        int i = 1;

        // write table row data
        for (PersonDetail personDetail : listOfPerson) {

            PdfPCell cell1 = new PdfPCell(new Paragraph(String.valueOf(i++), grey));
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setPadding(5.0f);
            cell1.setMinimumHeight(20.0f);
            table.addCell(cell1);

            PdfPCell cell2 =
                    new PdfPCell(new Paragraph(personDetail.getPersonFirstName()+"  "+ personDetail.getPersonLastName() +
                    " (" + personDetail.getPersonId() + ")", grey));
            cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell2.setPadding(5.0f);
            cell2.setMinimumHeight(20.0f);
            table.addCell(cell2);

            PdfPCell cell3 =
                    new PdfPCell(new Paragraph(personDetail.getPersonAddress()+ System.lineSeparator()+personDetail.getPinCode(), grey));
            cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell3.setPadding(5.0f);
            cell3.setMinimumHeight(20.0f);
            table.addCell(cell3);

            PdfPCell cell4 =
                    new PdfPCell(new Paragraph(String.valueOf(distributionAmount), grey));
            cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell4.setPadding(5.0f);
            cell4.setMinimumHeight(50.0f);
            table.addCell(cell4);
        }

        doc.add(table);

    }

}



