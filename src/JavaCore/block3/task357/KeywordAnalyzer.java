package JavaCore.block3.task357;

public abstract class KeywordAnalyzer implements TextAnalyzer{

    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    public Label processText(String text){
        String[] keywords = getKeywords();
        for (String keyword : keywords){
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }

}
