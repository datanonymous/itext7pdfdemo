package com.itextpdf.jumpstart;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Project Structure -> module -> dependencies
Requires:
itext7 io jar
itext7 kernal jar
itext7 layout jar
slf4j api
slf4j simple
// https://stackoverflow.com/questions/12926899/java-lang-noclassdeffounderror-org-slf4j-loggerfactory
// https://www.slf4j.org/download.html
// https://www.tutorialspoint.com/itext/index.htm
 */

// testing Commit

public class HelloWorld {

    public static final String DEST="results/chapter01/hello_world.pdf";

    public static void main(String[] args) throws IOException{
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new HelloWorld().createPdf(DEST);
    }

    public void createPdf(String destination) throws IOException{
        //Initialize PDF writer
        FileOutputStream fos = new FileOutputStream(DEST);
        PdfWriter writer = new PdfWriter(fos);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        //Initialize document
        Document document = new Document(pdf);

        //Add paragraph to the content
        // Change the font
        document.add(new Paragraph("Hello World, this is Alex trying to learn programmatic pdf's!").setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD)));

        // Change the color
        document.add(new Paragraph("This is a second paragraph!").setFontColor(Color.BLUE));

        // Paragraphs will loop to the beginning of the page
        document.add(new Paragraph("This is the third paragraph! asdfasdf dasdadsfdskj;aolwehfjoaiheswf;olijaf;olaifjdjifdo;asdkjisf;oaijdef;oai j;alsdkjf;l kflkjasd;lfkj;asldkjf;lasjdf;lkjasd;flkjasd;lfkjasd;lfkj;lasdkjffjeo;awifjo;awifjdskif"));

        // Adding a line?
        document.add(new Paragraph("_______________________________________________").setFontColor(Color.RED));

        // Adding a list
        // Creating a list
        List list = new List();

        // Add elements to the list
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");

        // Adding list to the document
        document.add(list);



        // Creating a line
        // Creating a new page
        PdfPage pdfPage = pdf.addNewPage();

        // Creating a PdfCanvas object
        PdfCanvas canvas = new PdfCanvas(pdfPage);

        // Initial point of the line
        canvas.moveTo(100, 300);

        // Drawing the line
        canvas.lineTo(500, 300);

        // Closing the path stroke
        canvas.closePathStroke();



        // https://developers.itextpdf.com/examples/itext-action-second-edition/chapter-2#103-directoroverview3.java
        // how to add a line separator?





        // Creating an Area Break
        AreaBreak aB = new AreaBreak();

        // Adding area break to the PDF
        document.add(aB);







        // Adding an image
        // Creating an ImageData object
        String imFile = "C:/Users/Alex/Documents/itext7pdfdemo/intj.jpg";
        ImageData data = ImageDataFactory.create(imFile);

        // Creating an Image object
        Image image = new Image(data);

        // Setting the position of the image to the center of the page
        image.setFixedPosition(100,250);

        // Adding image to the document
        document.add(image);









        //Close document
        document.close();
    }

}
