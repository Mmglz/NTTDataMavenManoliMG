package com.nttdata.mvn;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Clase Principal
 * 
 * @author manoli
 *
 */
public class App {

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Creación nuevo documento.
		Document document = new Document();

		// Creación de las fuentes
		Font italic = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.ITALIC);
		Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);

		try {
			PdfWriter.getInstance(document, new FileOutputStream("Documento.pdf"));
			document.open();

			// Creación del primer párrafo
			Paragraph paragraph = new Paragraph();
			paragraph.setFont(normal);
			String text = "Para este ejercicio se han utilizado varias dependencias.";
			if (StringUtils.isNotBlank(text)) {
				paragraph.add(text);
			} else {
				System.out.println("Deberías de escribir algo");
			}

			// Se añade el párrafo al documento
			document.add(paragraph);

			// Creación del segundo párrafo
			Paragraph paragraph2 = new Paragraph();
			String text2 = "El texto fue añadido el día " + LocalDate.now();
			paragraph2.setFont(italic);
			paragraph2.add(text2);

			// Se añade el párrafo al documento
			document.add(paragraph2);

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();

		} finally {
			document.close();
		}
	}
}
