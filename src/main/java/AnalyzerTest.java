import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

import java.io.IOException;

public class AnalyzerTest {

    private static final String[] examples = {"This is Test"};

    private static final Analyzer[] analyzers = new Analyzer[] {new WhitespaceAnalyzer(),new SimpleAnalyzer(),new StandardAnalyzer()};

    public static void analyze(String text) throws IOException {
        System.out.println("result \"" +text+ "\"");
        System.out.println("\n");
        for(Analyzer analyzer : analyzers) {

            String name = analyzer.getClass().getSimpleName();
            System.out.println("  "+name+"  ");
            System.out.print("    ");
            AnalyzerUtils.displayTokens(analyzer,text);
            System.out.println("\n");

        }

    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        String[] strings = examples;
        for(String text:strings) {
            analyze(text);
        }

    }

}