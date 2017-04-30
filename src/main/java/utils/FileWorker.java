package utils;

import java.io.*;

/**
 * Created by Lantiets on 29.03.2017.
 */


public class FileWorker {
    public static String read(File file) throws FileNotFoundException {
        //Специальный объект для построения строки
        StringBuilder sb = new StringBuilder();
        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Осуществляет закрытие файла
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        //Возвращаем полученный текст с файла
        return sb.toString();
    }
}
