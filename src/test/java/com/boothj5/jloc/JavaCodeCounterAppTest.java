package com.boothj5.jloc;

import org.junit.Before;
import org.junit.Test;

import java.net.URL;

import static com.boothj5.jloc.TestUtil.MINIONS_DIR;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JavaCodeCounterAppTest {

    private SJavaCodeCounterApp appS;

    private String getResourcePath(String path) {
        URL url = getClass().getResource(path);
        return url.getFile();
    }

    @Before
    public void setup() {
        appS = new SJavaCodeCounterApp();
    }

    @Test
    public void testCountJavaFiles() {
        assertThat(appS.getFileCount(getResourcePath(MINIONS_DIR)), is(39l));
    }

    @Test
    public void testCountBlankLines() {
        assertThat(appS.getBlankLinesCount(getResourcePath(MINIONS_DIR)), is(436l));
    }

}
