package com.boothj5.jloc;

import com.boothj5.jloc.FileCounterApp;
import com.boothj5.jloc.LineCounterApp;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LineCounterAppTest {

    private LineCounterApp app;
    private final String FILECOUNT_DIR = "/filecount";
    private final String MINIONS_DIR = "/minions";

    private String getResourcePath(String path) {
        URL url = getClass().getResource(path);
        return url.getFile();
    }

    @Before
    public void setup() {
        app = new FileCounterApp();
    }

    @Test
    public void testTopLevelDirectory() {
        assertThat(app.getFileCount(getResourcePath(FILECOUNT_DIR + "/dir1")), is(2));
    }

    @Test
    public void testNestedLeafDirectory() {
        assertThat(app.getFileCount(getResourcePath(FILECOUNT_DIR + "/dir2/dir21/dir211")), is(1));
    }

    @Test
    public void testNestedDirectory() {
        assertThat(app.getFileCount(getResourcePath(FILECOUNT_DIR + "/dir2/dir21")), is(3));
    }

    @Test
    public void testFileCountDirectory() {
        assertThat(app.getFileCount(getResourcePath(FILECOUNT_DIR)), is(12));
    }

    @Test
    public void testMinionsDirectory() {
        assertThat(app.getFileCount(getResourcePath(MINIONS_DIR)), is(62));
    }

}
