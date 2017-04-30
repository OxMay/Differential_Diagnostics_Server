package utils;

import spark.utils.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Lantiets on 29.03.2017.
 */
public class StreamUtil {
    //Переменные характеризующие название файла
    public static final String PREFIX = "stream2file";
    public static final String SUFFIX = ".txt";
// преобразование в файл
    public static File stream2file (InputStream in) throws IOException {
        //Создание новой переменной
        final File tempFile = File.createTempFile(PREFIX, SUFFIX);
        tempFile.deleteOnExit();
        //копирование переменной из Input Stream в Output Stream
        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(in, out);
        }
        return tempFile;
    }
}
