import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

import java.io.IOException;
import java.io.StringReader;

class AnalyzerUtils{

    public static void displayTokens(Analyzer analyzer, String text) throws IOException {
        displayTokens(analyzer.tokenStream("content", new StringReader(text)));

    }

    public static void displayTokens(TokenStream stream) throws IOException {

        //텀 속성 확인
        CharTermAttribute cattr = stream.addAttribute(CharTermAttribute.class);

        //위치 증가값 속성 확인
        PositionIncrementAttribute postAtrr = stream.addAttribute(PositionIncrementAttribute.class);

        //오프셋 위치 확인
        OffsetAttribute offsetAttr = stream.addAttribute(OffsetAttribute.class);

        //텀타입 속성 확인
        TypeAttribute typeAttr = stream.addAttribute(TypeAttribute.class);

        stream.reset();
        int position = 0;



        while (stream.incrementToken()) {

            int increment = postAtrr.getPositionIncrement();
            position = position + increment;
            System.out.println();
            System.out.print(position + ": ");
            System.out.print("[ "+cattr.toString()+" : " + offsetAttr.startOffset()+"->"+offsetAttr.endOffset()+" : "+typeAttr.type()+" ]");

        }

        stream.end();

        stream.close();

    }

}
