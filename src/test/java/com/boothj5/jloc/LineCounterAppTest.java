package com.boothj5.jloc;

import org.junit.Before;
import org.junit.Test;

import java.net.URL;

import static com.boothj5.jloc.TestUtil.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LineCounterAppTest {

    private LineCounterApp app;
    private SLineCounterApp appS;

    private String getResourcePath(String path) {
        URL url = getClass().getResource(path);
        return url.getFile();
    }

    @Before
    public void setup() {
        app = new LineCounterApp();
        appS = new SLineCounterApp();
    }

    @Test
      public void testMultiLineFile() {
        assertThat(app.getLineCount(getResourcePath(FILECOUNT_DIR + "/dir1/file1")), is(2l));
        assertThat(appS.getLineCount(getResourcePath(FILECOUNT_DIR + "/dir1/file1")), is(2l));
    }

    @Test
    public void testSingleLineFile() {
        assertThat(app.getLineCount(getResourcePath(FILECOUNT_DIR + "/dir1/file2")), is(1l));
        assertThat(appS.getLineCount(getResourcePath(FILECOUNT_DIR + "/dir1/file2")), is(1l));
    }

    @Test
    public void testSingleDirectory() {
        assertThat(app.getLineCount(getResourcePath(FILECOUNT_DIR + "/dir1")), is(3l));
        assertThat(appS.getLineCount(getResourcePath(FILECOUNT_DIR + "/dir1")), is(3l));
    }

    @Test
    public void testNestedDirectory() {
        assertThat(app.getLineCount(getResourcePath(FILECOUNT_DIR + "/dir2/dir21")), is(4l));
        assertThat(appS.getLineCount(getResourcePath(FILECOUNT_DIR + "/dir2/dir21")), is(4l));
    }

    @Test
    public void testFileCountDirectory() {
        assertThat(app.getLineCount(getResourcePath(FILECOUNT_DIR)), is(16l));
        assertThat(appS.getLineCount(getResourcePath(FILECOUNT_DIR)), is(16l));
    }

    @Test
    public void testMinionsDirectory() {
        assertThat(app.getLineCount(getResourcePath(MINIONS_DIR)), is(4044l));
        assertThat(appS.getLineCount(getResourcePath(MINIONS_DIR)), is(4044l));
    }


}
