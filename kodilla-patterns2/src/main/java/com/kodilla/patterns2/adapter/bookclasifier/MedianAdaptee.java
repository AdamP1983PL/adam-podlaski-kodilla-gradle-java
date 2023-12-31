package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookStatistics;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {

    Statistics statistics;

    @Override
    public int averagePublicationYear(Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> books) {
        return statistics.averagePublicationYear(books);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> books) {
        return statistics.medianPublicationYear(books);
    }
}
