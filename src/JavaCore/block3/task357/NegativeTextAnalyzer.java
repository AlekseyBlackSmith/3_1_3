package JavaCore.block3.task357;

public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private String[] keywords = {":(", "=(", ":|"};


    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
