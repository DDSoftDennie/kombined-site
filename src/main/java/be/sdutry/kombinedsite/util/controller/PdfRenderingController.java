package be.sdutry.kombinedsite.util.controller;

import java.io.ByteArrayOutputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public interface PdfRenderingController {
	default ResponseEntity<byte[]> createPdfResponse(ByteArrayOutputStream baos, String filename) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData(filename, filename);

		return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.OK);
	}
}
