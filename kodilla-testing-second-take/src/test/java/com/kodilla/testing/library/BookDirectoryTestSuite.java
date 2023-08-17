package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Test
    void testListBooksWithConditionsReturnList() {
        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);                   // [5]
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);    // [6]
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);    // [7]
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);                 // [8]
        resultListOfBooks.add(book1);                                                    // [9]
        resultListOfBooks.add(book2);                                                    // [10]
        resultListOfBooks.add(book3);                                                    // [11]
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        //when
        List<Book> theListOfBooks = bookLibrary.listBookWithCondition("Secret");

        //then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    void testListBooksWithConditionMoteThan20() {
        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        //when
        List<Book> theListOfBooks0 = bookLibrary.listBookWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBookWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBookWithCondition("FortyBooks");

        //then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    void testListBooksWithConditionFragmentShorterThan3() {
        //given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        //when
        List<Book> theListOfBooks10 = bookLibrary.listBookWithCondition("An");

        //then
        assertEquals(0, theListOfBooks10.size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    void testListBooksInHandOfLibraryUserZeroBooks() {
        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser johnCode = new LibraryUser("John", "Code", "111333");
        List<Book> zeroBooks = new ArrayList<>();
        when(libraryDatabaseMock.getBookInHandOf(johnCode)).thenReturn(zeroBooks);

        //when
        List<Book> resultListOf0Books = bookLibrary.getBookInHandOf(johnCode);

        //then
        assertEquals(0, resultListOf0Books.size());
    }

    @Test
    void testListBooksInHandOfLibraryUserOneBook() {
        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser johnCode2 = new LibraryUser("John", "Code2", "222444");
        List<Book> oneBookList = generateListOfNBooks(1);
        when(libraryDatabaseMock.getBookInHandOf(johnCode2)).thenReturn(oneBookList);

        //when
        List<Book> resultListOfOneBook = bookLibrary.getBookInHandOf(johnCode2);

        //then
        assertEquals(1, resultListOfOneBook.size());

    }

    @Test
    void testListBooksInHandsOfLibraryUserFiveBooks() {
        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser johnCode3 = new LibraryUser("John", "Code3", "111444");
        List<Book> fiveBookList = generateListOfNBooks(5);
        when(libraryDatabaseMock.getBookInHandOf(johnCode3)).thenReturn(fiveBookList);

        //when
        List<Book> resultListOfFiveBooks = bookLibrary.getBookInHandOf(johnCode3);

        //then
        assertEquals(5, resultListOfFiveBooks.size());

    }

}
