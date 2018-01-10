package com.java.bilibili.utils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Eric.zhang on 2018/1/10.
 */

public class FileUtil {
    public static File getDirectory(String path) {
        File appDir = new File(path);
        if (!appDir.exists()) {
            appDir.mkdirs();
        }
        return appDir;
    }
    public static int writeFile(String path, String content) {
        try {
            File f = new File(path);
            if (f.exists()) {
                f.delete();
            }
            if (f.createNewFile()) {
                FileOutputStream utput = new FileOutputStream(f);
                utput.write(content.getBytes());
                utput.close();
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }
}
