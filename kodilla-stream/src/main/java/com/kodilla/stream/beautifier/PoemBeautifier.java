package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String str, PoemDecorator poemDecorator){

        String beautifyText = poemDecorator.decorate(str);
        System.out.println(beautifyText);

    }
}
