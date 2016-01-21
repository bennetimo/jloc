package com.boothj5.jloc;

import java.net.URL;

public class TestUtil {

    protected static final String FILECOUNT_DIR = "/filecount";
    protected static final String MINIONS_DIR = "/minions";

    protected static String getResourcePath(String path) {
        URL url = TestUtil.class.getResource(path);
        return url.getFile();
    }

}
