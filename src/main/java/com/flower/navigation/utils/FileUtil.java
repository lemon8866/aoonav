package com.flower.navigation.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

	
	/**
     * 复制文件夹
     * @param oldDir 原来的目录
     * @param newDir 复制到哪个目录
     */
    public static void copyDir(String oldDir, String newDir) {
            File srcDir = new File(oldDir);
            // 判断文件是否不存在或是否不是文件夹
            if (!srcDir.exists() || !srcDir.isDirectory()) {
                throw new IllegalArgumentException("参数错误");
            }
            File destDir = new File(newDir);
            if (!destDir.exists()) {
                // 不存在就创建目录
                if(destDir.mkdirs()){
                    // 列出目录中的文件
                    File[] files = srcDir.listFiles();
                    for (File f : files) {
                        // 是文件就调用复制文件方法 是目录就继续调用复制目录方法
                        if (f.isFile()) {
                            copyFile(f, new File(newDir, f.getName()));
                        } else if (f.isDirectory()) {
                            copyDir(oldDir + File.separator + f.getName(),
                                    newDir + File.separator + f.getName());
                        }
                    }
                }
            }
        }
	/**
     * 复制文件
     * @param oldDir 原来的文件
     * @param newDir 复制到的文件
     */
    public static void copyFile(File oldDir, File newDir) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        byte[] b = new byte[1024];
        try {
            // 将要复制文件输入到缓冲输入流
            bufferedInputStream = new BufferedInputStream(new FileInputStream(oldDir));
            // 将复制的文件定义为缓冲输出流
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(newDir));
            // 定义字节数
            int len;
            while ((len = bufferedInputStream.read(b)) > -1) {
                // 写入文件
                bufferedOutputStream.write(b, 0, len);
            }
            //刷新此缓冲输出流
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    // 关闭流
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
