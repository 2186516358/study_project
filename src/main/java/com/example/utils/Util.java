package com.example.utils;


import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

public class Util<T> {

    /**
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static byte[] file2byte(File file) throws Exception {
        byte[] buffer = new byte[(int)file.length()];

        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] b = new byte[4096];
        int n;
        while ((n = fis.read(b)) != -1) {
            bos.write(b, 0, n);

        }
        fis.close();
        bos.close();
        buffer = bos.toByteArray();
        return buffer;
    }

    /**
     *
     * @param date
     * @return
     */
    public static String changeDate(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }
}
