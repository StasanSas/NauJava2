package org.example;

import org.example.Tasks.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        WorkingWithArray.printResult();
        WorkingWithLists.printResult();
        StreamAPI.printResult();
        var interfaceTask = new InterfaceTask();
        interfaceTask.start();
        Thread.sleep(100);
        interfaceTask.stop();
        HTTPAndJSON.printResult();
    }
}