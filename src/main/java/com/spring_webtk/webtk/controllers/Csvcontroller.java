package com.spring_webtk.webtk.controllers;


import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
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
        String csvFilePath = "src/main/resources/ursa-file.csv"; // Replace with your CSV file path
        
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> records = reader.readAll();
            return ResponseEntity.ok(records);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;    
    }
}
