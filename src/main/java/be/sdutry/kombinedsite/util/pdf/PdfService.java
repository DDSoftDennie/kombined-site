package be.sdutry.kombinedsite.util.pdf;

import java.awt.Color;
import java.io.OutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {
	public void writeLinesAsParagraphs(final List<String> lines, final OutputStream outputStream,
			final String footerText) {
		final Document doc = new Document(PageSize.A4, 16, 16, 36, 56);
		final PdfWriter writer = PdfWriter.getInstance(doc, outputStream);
		final Font font = new Font(Font.HELVETICA, 16, Font.NORMAL, Color.BLACK);
		PdfPageFooterHelper event = new PdfPageFooterHelper(footerText);
		writer.setPageEvent(event);

		doc.open();
		PdfPTable table = new PdfPTable(1);
		table.setTotalWidth(527);
		table.setLockedWidth(true);

		for (final String line : lines) {
			PdfPCell cell = new PdfPCell(new Phrase(line, font));
			cell.setBorder(Rectangle.BOTTOM | Rectangle.TOP);
			cell.setPaddingBottom(20);
			cell.setPaddingTop(20);
			table.addCell(cell);
		}

		doc.add(table);

		doc.close();
		writer.close();
	}
}
