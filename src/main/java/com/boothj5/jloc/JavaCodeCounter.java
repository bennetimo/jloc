package com.boothj5.jloc;

import com.boothj5.jloc.handlers.LangHandler;
import com.boothj5.jloc.languages.BlockComment;
import com.boothj5.jloc.languages.LangDef;

import java.util.ArrayList;
import java.util.List;

public class JavaCodeCounter {
    public static void main(String[] args) {
        List<String> lineComments = new ArrayList<>();
        lineComments.add("//");

        BlockComment blockComment = new BlockComment("/*", "*/");
        List<BlockComment> blockComments = new ArrayList<>();
        blockComments.add(blockComment);

        LangDef javaLang = new LangDef("Java", "java", lineComments, blockComments);

        LangHandler langHandler = new LangHandler("/home/boothj5/projects-git/jloc/src/test/resources/minions", javaLang);

        System.out.println("Files: 0");
        System.out.println("Code: 0");
        System.out.println("Comments: 0");
        System.out.println("Whitespace: 0");
    }
}