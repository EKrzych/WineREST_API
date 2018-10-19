package com.codecool.wineREST.helpers;


import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileReaderCSV {
    public FileReaderCSV() {
    }

    public List<String> readData(Path path) {
        List<String> dataFromFile = new ArrayList<>();

        try(BufferedReader br = Files.newBufferedReader(path)) {
            br.readLine(); // for header
            String line = br.readLine();

            while (line != null) {
                dataFromFile.add(line);

                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataFromFile;
    }
}

