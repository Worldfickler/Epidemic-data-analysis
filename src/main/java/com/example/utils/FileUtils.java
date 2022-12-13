package com.example.utils;

import java.io.*;

/**
 * @author dell
 * @version 1.0
 */
public class FileUtils {

    BufferedWriter bufferedWriter = null;
    static BufferedReader bufferedReader = null;

    public  BufferedWriter writeFile(String fileName) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        return bufferedWriter;
    }

    public static BufferedReader readFile(String fileName) throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(fileName));
        return bufferedReader;
    }

}
