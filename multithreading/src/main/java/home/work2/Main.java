package home.work2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService=Executors.newFixedThreadPool(3);
        Future<String> readFuture = executorService.submit(new FileRead("test.txt"));
        Future<String> formatFuture = executorService.submit(new FormatWork(new TrimAllSpaceFormat(), readFuture.get()));
        executorService.execute(new FileWrite("test2.txt",formatFuture.get()));
        executorService.shutdown();

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
