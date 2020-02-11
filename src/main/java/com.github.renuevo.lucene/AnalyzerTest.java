package com.github.renuevo.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.ngram.NGramTokenizer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;

import static java.lang.System.*;

public class AnalyzerTest {

    private static final String[] examples = {"테스트 입니다"};


    private static final Analyzer[] analyzers = new Analyzer[]{
            //  new WhitespaceAnalyzer(),
            //  new SimpleAnalyzer(),
            //  new StopAnalyzer(new CharArraySet(0,false)),
            //  new StandardAnalyzer(),
            //  new NGramAnalyzer(),
            new JamoAnalyzer()};

    public static void analyze(String text) throws IOException {

        out.println("result \"" + text + "\"");
        out.println("\n");
        for (Analyzer analyzer : analyzers) {
            String name = analyzer.getClass().getSimpleName();
            out.println("  " + name + "  ");
            out.print("    ");
            AnalyzerUtils.displayTokens(analyzer, text);
            out.println("\n");

        }

    }

    public static void main(String[] args) throws IOException {
        for (String text : examples) {
            analyze(text);
        }

    }

}