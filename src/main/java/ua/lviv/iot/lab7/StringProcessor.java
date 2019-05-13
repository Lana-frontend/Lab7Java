package ua.lviv.iot.lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class StringProcessor {

    private String userText;

    private List<String> resultsList = new ArrayList<String>();

    public StringProcessor() {
    }

    public StringProcessor(final String userText) {
        this.setUserText(userText);
    }

    public String getUserText() {
        return userText;
    }

    public final void setUserText(final String userText) {
        this.userText = userText;
    }

    public final List<String> getResultsList() {
        return resultsList;
    }

    public final void findAndReverseMiddleWordsInQuestionSentences() {

        Pattern questionSentencePattern = Pattern.compile("-(\\d+)?+(\\d+)?");
        Pattern wordPattern = Pattern.compile("\\b\\d+\\b");

        Matcher questionSentenceMatcher = questionSentencePattern.matcher(this.getUserText());

        while (questionSentenceMatcher.find()) {

            String questionString = questionSentenceMatcher.group();

            Matcher wordMatcher = wordPattern.matcher(questionString);

            int wordNumber = 0;

            ArrayList<String> words = new ArrayList<String>();

            while (wordMatcher.find()) {

                words.add(wordMatcher.group());
                wordNumber++;
            }
            String s = "S";
            s.concat("Ss");
            if (wordNumber != 0) {

                StringBuffer wordToReverse = new StringBuffer(words.get(wordNumber / 2));
                String reversedString = wordToReverse.reverse().toString();
                this.resultsList.add(reversedString);
            }
        }
    }

    public static String readInputText() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the text you want to filter : ");
        String userText = br.readLine();
        br.close();
        return userText;
    }

    public void showResults() {

        System.out.println(
                "\n------------------------------------------------------------------------------------------------\n");
        System.out.println("\tText processing results:");
        if (this.resultsList.size() != 0) {
            for (String result : this.resultsList) {
                System.out.println(" " + result);
            }
        } else {
            System.out.println("Sorry, but there are no results for you.");
        }
        
        
    }
    public static void main(String[] args) throws IOException {

        String userInput = StringProcessor.readInputText();
        StringProcessor stringProcessor = new StringProcessor(userInput);
        stringProcessor.findAndReverseMiddleWordsInQuestionSentences();
        stringProcessor.showResults();
    }

}


    
   

       



