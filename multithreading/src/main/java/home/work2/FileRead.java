package home.work2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;

public class FileRead implements Callable<String> {

    private final String path;

    public FileRead(String path) {
        this.path = path;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Run thread name -" + Thread.currentThread().getName());
        StringBuilder sb = new StringBuilder();
        try (FileInputStream in = new FileInputStream(path);
             InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                sb.append(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e){
            throw new RuntimeException("Error reads data");
        }
        return sb.toString();
    }
}
