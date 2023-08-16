package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Test
    void testListBooksWithConditionsReturnList() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);                  // [3]
        List<Book> resultListOfBooks = new ArrayList<>();                                // [4]
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);                   // [5]
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);    // [6]
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);    // [7]
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);                 // [8]
        resultListOfBooks.add(book1);                                                    // [9]
        resultListOfBooks.add(book2);                                                    // [10]
        resultListOfBooks.add(book3);                                                    // [11]
        resultListOfBooks.add(book4);                                                    // [12]
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);// [13]

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");        // [14]

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    void testListBooksWithConditionMoreThan20() {
        //given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();                           // [2]
        List<Book> resultListOf15Books = generateListOfNBooks(15);                       // [3]
        List<Book> resultListOf40Books = generateListOfNBooks(40);

        when(libraryDatabaseMock.listBooksWithCondition(anyString()))                    // [5]
                .thenReturn(resultListOf15Books);                                             // [6]
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))                    // [7]
                .thenReturn(resultListOf0Books);                                              // [8]
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))                   // [9]
                .thenReturn(resultListOf40Books);

        //when
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");    // [11]
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");   // [12]
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        //then
        assertEquals(0, theListOfBooks0.size());                                         // [14]
        assertEquals(15, theListOfBooks15.size());                                       // [15]
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);            // [2]
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);               // [3]

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");       // [4]

        // Then
        assertEquals(0, theListOfBooks10.size());                                     // [5]
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    private List<Book> generateListOfNBooks(int booksQuantity){
        List<Book> resultList = new ArrayList<>();
        for (int i = 0; i < booksQuantity; i++) {
            Book theBook = new Book("Title_" + i, "Author_" + i, 1970 + i);
            resultList.add(theBook);
        }
        return resultList;
    }


    /*
    * Zaimplementuj kolejną metodę klasy BookLibrary – listBooksInHandsOf(LibraryUser libraryUser).
    * Zauważ, że metoda o takiej samej nazwie znajduje się w interfejsie LibraryDatabase.
    * Miej na uwadze, że są to dwie różne metody.
    * Przetestuj metodę listBooksInHandsOf(LibraryUser libraryUser) z klasy BookLibrary w różnych scenariuszach:

    gdy użytkownik nie ma wypożyczonych żadnych książek,
    gdy ma wypożyczoną jedną książkę,
    gdy ma wypożyczonych 5 książek.
    Zadanie zrealizuj w podejściu TDD.
    * Przed zaimplementowaniem metody, stworzone testy prześlij do Mentora za pośrednictwem czatu
    * (aby przesłać długi tekst, umieść go najpierw w pliku tekstowym i prześlij ten plik.
    * Komunikator nie pozwoli na przesłanie zbyt długich wiadomości).*/

    @Test
    void listBooksInHandsOf(){
        //given

        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf1Book = generateListOfNBooks(1);
        List<Book> resultListOf5Books = generateListOfNBooks(5);
        LibraryUser libraryUser = new LibraryUser("Tomasz", "Kowalski", "83102325786" );
        LibraryUser libraryUser2 = new LibraryUser("Konrad", "Luczyński", "83102325782" );
        LibraryUser libraryUser3 = new LibraryUser("Damian", "Laskowski", "83102325783" );

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser2)).thenReturn(resultListOf1Book);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser3)).thenReturn(resultListOf5Books);

        //when
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> temp = bookLibrary.getBooksInHandsOf(libraryUser);
        List<Book> temp1 = bookLibrary.getBooksInHandsOf(libraryUser2);
        List<Book> temp2 = bookLibrary.getBooksInHandsOf(libraryUser3);

        //then
        assertEquals(temp, resultListOf0Books);
        assertEquals(temp1, resultListOf1Book);
        assertEquals(temp2, resultListOf5Books);
    }
}
