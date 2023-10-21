package org.example.httpdownload;

import org.example.httpcheck.HttpStatusChecker;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    private static final String DOWNLOAD_PATH = "./%d.jpg";
    private final HttpStatusChecker httpChecker = new HttpStatusChecker();
    public void downloadStatusImage(int code) throws Exception{
        String url = httpChecker.getStatusImage(code);
        try(InputStream in = new URL(url).openStream()){
            Files.copy(in, Paths.get(String.format(DOWNLOAD_PATH,code)));
        }
    }
}
