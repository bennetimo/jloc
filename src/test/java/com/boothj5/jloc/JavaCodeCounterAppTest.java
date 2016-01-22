package com.boothj5.jloc;

import org.junit.Before;
import org.junit.Test;

import java.net.URL;

import static com.boothj5.jloc.TestUtil.MINIONS_DIR;
import static com.boothj5.jloc.TestUtil.getResourcePath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JavaCodeCounterAppTest {

    private SJavaCodeCounterApp appS;

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

    @Test
    public void testCountCommentLines() {
        assertThat(appS.getCommentLinesCount(getResourcePath(MINIONS_DIR)), is(265l));
    }

    @Test
    public void testCountCommentBothTypesLines() {
        assertThat(appS.getCommentLinesCount(getResourcePath(MINIONS_DIR + "/minions-core/src/main/java/com/boothj5/minions/MinionJar.java")), is(17l));
    }

    @Test
    public void testCountCodeLines() {
        assertThat(appS.getCodeLinesCount(getResourcePath(MINIONS_DIR)), is(1978l));
    }

    //CLOC gives a count of 18 for this file...but that seems wrong
    @Test
    public void testCountCommentLinesDefaultMessageHandler() {
        assertThat(appS.getCommentLinesCount(getResourcePath(MINIONS_DIR + "/minions-core/src/main/java/com/boothj5/minions/DefaultMessageHandler.java")), is(19l));
    }

}
