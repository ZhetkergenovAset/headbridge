package home.work2;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite implements Runnable{

    private final String path;
    private final String text;

    public FileWrite(String path,String text) {
        this.path = path;
        this.text=text;
    }

    @Override
    public void run() {
        System.out.println("Run thread name -"+Thread.currentThread().getName());
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Error in write file");
        }
    }
}
