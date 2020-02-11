package com.github.renuevo.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.ngram.EdgeNGramTokenizer;

public class JamoAnalyzer extends Analyzer {

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        EdgeNGramTokenizer edgeNGramTokenizer = new EdgeNGramTokenizer(1, 100);
        return new TokenStreamComponents(edgeNGramTokenizer, new JamoTokenFilter(edgeNGramTokenizer, new JamoParser()));
    }


}
