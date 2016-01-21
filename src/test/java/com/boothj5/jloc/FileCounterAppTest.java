package com.boothj5.jloc;

import org.junit.Before;
import org.junit.Test;

import static com.boothj5.jloc.TestUtil.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FileCounterAppTest {

    private FileCounterApp app;

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
