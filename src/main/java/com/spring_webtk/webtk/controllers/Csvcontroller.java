package com.spring_webtk.webtk.controllers;
import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Csvcontroller {
    @GetMapping("/download-csv")
    public ResponseEntity<Resource> downloadCsv() {
        Resource resource = new ClassPathResource("ursa-file.csv");

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"data.csv\"")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(resource);
    }
    @GetMapping("/display-csv")
    public ResponseEntity<List<String[]>> getCsvData() throws IOException {
        try {
            ClassPathResource csvresource = new ClassPathResource("ursa-file.csv"); // Replace "data.csv" with your file name
            InputStream inputStream = csvresource.getInputStream();
            
            try (CSVReader reader = new CSVReader(new InputStreamReader(inputStream))) {
                List<String[]> records = reader.readAll();
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.set("Content Type", "text/csv");
                return ResponseEntity.ok(records);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;    
    }
}