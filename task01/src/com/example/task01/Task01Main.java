package com.example.task01;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Task01Main {
    public static void main(String[] args) throws IOException {
        System.out.println(checkSumOfStream(new ByteArrayInputStream(new byte[]{0x33, 0x45, 0x01})));
        System.out.println(checkSumOfStream(null));
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        if (inputStream == null) throw new IllegalArgumentException();
        int checkSum = 0, number = 0;
        while (number != -1)
            checkSum = Integer.rotateLeft(checkSum, 1) ^ (number = inputStream.read());
        return (checkSum ^ number) / 2;
    }
}
