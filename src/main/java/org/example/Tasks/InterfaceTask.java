package org.example.Tasks;

import java.io.*;
import java.net.URL;

interface Task
{
    void start() ;

    void stop() throws IOException;
}


public class InterfaceTask implements Task{
    private final BufferedInputStream bufferedInputStream;
    private final FileOutputStream fileOutputStream;
    private boolean running = false;
    private boolean stoppedTread = false;


    public InterfaceTask() throws IOException {
        var url = new URL("https://gist.githubusercontent.com/khaykov/a6105154becce4c0530da38e723c2330/raw/41ab415ac41c93a198f7da5b47d604956157c5c3/gistfile1.txt");
        var outputPath = "file.txt";
        InputStream inputStream = url.openStream();
        bufferedInputStream = new BufferedInputStream(inputStream);
        fileOutputStream = new FileOutputStream(outputPath);
    }

    @Override
    public void start() {
        running = true;
        Thread tread = new Thread(() -> {
            int numBytesRead;
            byte[] bucket = new byte[2];
            while (running) {
                try {
                    numBytesRead = bufferedInputStream.read(bucket, 0, bucket.length);
                    if (numBytesRead == -1)
                        break;
                    fileOutputStream.write(bucket, 0, numBytesRead);
                } catch (IOException e) {
                    running = false;
                    throw new RuntimeException(e);
                }
            }
            stoppedTread = true;
        });

        Thread.UncaughtExceptionHandler h = (th, ex) -> {
            stoppedTread = true;
            try {
                bufferedInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(ex);
            }
        };

        tread.setUncaughtExceptionHandler(h);
        tread.start();
    }



    @Override
    public void stop() throws IOException{
        if (running){
            running = false;
            while (!stoppedTread){}
            bufferedInputStream.close();
            fileOutputStream.close();
        }
    }
}
