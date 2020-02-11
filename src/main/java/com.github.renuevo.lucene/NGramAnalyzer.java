package com.github.renuevo.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.ngram.NGramTokenFilter;
import org.apache.lucene.analysis.ngram.NGramTokenizer;

public class NGramAnalyzer extends Analyzer {


    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        NGramTokenizer nGramTokenizer = new NGramTokenizer(2, 100);
        NGramTokenFilter nGramTokenFilter = new NGramTokenFilter(nGramTokenizer, 2);
        return new TokenStreamComponents(nGramTokenizer, nGramTokenFilter);
    }
}