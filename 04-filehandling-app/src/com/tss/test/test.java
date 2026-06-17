package com.tss.test;

import java.io.*;

public class test {
    public static void main(String[] args) throws Exception{
        BufferedReader bfr=new BufferedReader(new FileReader("C:\\prince\\Assignment\\04-filehandling-app\\src\\com\\tss\\test\\abc.text"));

        String data;

        while((data = bfr.readLine()) != null) {
            System.out.println(data);
        }

        bfr.close();
        FileWriter fos =
                new FileWriter("C:\\prince\\Assignment\\04-filehandling-app\\src\\com\\tss\\test\\abc.text");
        fos.write("hello welcome");
        fos.close();
    }
}
