package com.enterprise.ems.controllers;

import com.enterprise.ems.dtos.Item;
import com.enterprise.ems.services.DemoHtmlToPdfService;
import com.enterprise.ems.services.DemoPdfGenratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoPdfController {
    @Autowired
    private DemoPdfGenratorService htmlGeneratorService;
    private DemoHtmlToPdfService pdfService;

    // http://localhost:8080/invoice/pdf
    /*fetch("http://localhost:8080/invoice/pdf", {
        method: "POST",
                headers: { "Content-Type": "application/json" },
        body: JSON.stringify(invoiceData)
    })
            .then(res => res.blob())
            .then(blob => window.open(URL.createObjectURL(blob)));

*/
    @GetMapping("/invoice/pdf")
    public ResponseEntity<byte[]> generatePdf() {

        Map<String, Object> data = new HashMap<>();
        data.put("name", "John Doe");
        data.put("date", LocalDate.now());
        data.put("items", List.of(
                new Item("Laptop", 800),
                new Item("Mouse", 20)
        ));

        String html = htmlGeneratorService.generateHtml(data);
        byte[] pdf = pdfService.generatePdf(html);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=invoice.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }

}
