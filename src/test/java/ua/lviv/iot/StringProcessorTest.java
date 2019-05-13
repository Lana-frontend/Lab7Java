package ua.lviv.iot;


import org.junit.jupiter.api.Test;

import ua.lviv.iot.lab7.StringProcessor;

class StringProcessorTest {

    StringProcessor testStringProcessor = new StringProcessor("Hello? How are you? Listen: do you like music? Or you like tennis?");
    
    @Test
    void testFindAndReverseMiddleWordsInQuestionSentences() {
        
        testStringProcessor.findAndReverseMiddleWordsInQuestionSentences();

      
    }

}