package com.kodilla.good.patterns;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> titles = movieStore.getMovies();

        String text = titles.entrySet().stream()
                .flatMap(books -> books.getValue().stream())
                .collect(Collectors.joining(" ! "));

        String text2 = titles.entrySet().stream()
                .flatMap(books -> books.getValue().stream())
                .map(s -> s.replace(" ", ""))
                .collect(Collectors.joining("!"));

        System.out.println(text);
        System.out.println(text2);
    }
}
