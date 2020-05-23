package be.sdutry.kombinedsite.util.pdf;

import java.awt.Color;
import java.io.OutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {
	public void writeLinesAsParagraphs(final List<String> lines, final OutputStream outputStream) {
		final Document doc = new Document();
		final PdfWriter writer = PdfWriter.getInstance(doc, outputStream);
		final Font font = new Font(Font.HELVETICA, 16, Font.NORMAL, Color.BLACK);
		
		doc.open();

		for (final String line : lines) {
			Paragraph para = new Paragraph(line, font);
			para.setSpacingAfter(20);
			doc.add(para);
		}

		doc.close();
		writer.close();
	}
}
