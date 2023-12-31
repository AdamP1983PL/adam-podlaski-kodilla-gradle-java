package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Statistics;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        // given
        Statistics statistics = new Statistics();
        MedianAdapter medianAdapter = new MedianAdapter(statistics);
        Set<Book> books = new HashSet<>();
        books.add(new Book("Author 1", "Title 1", 2000, "Signature 1"));
        books.add(new Book("Author 2", "Title 2", 1990, "Signature 2"));
        books.add(new Book("Author 3", "Title 3", 2010, "Signature 3"));

        // when
        int medianYear = medianAdapter.publicationYearMedian(books);

        // then
        assertEquals(2000, medianYear);

    }
}
