package com.kodilla.patterns.prototype.libraty;

import com.kodilla.patterns.prototype.library.Book;
import com.kodilla.patterns.prototype.library.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    private Library library;

    @BeforeEach
    void initialize() {
        library = new Library("Library_1");
        IntStream.iterate(1, n -> n + 1)
                .limit(2)
                .forEach(n -> library.getBooks()
                        .add(new Book("Book_" + n, "Author_" + n, LocalDate.of(1983 + n, 10, 23))));
    }

    @Nested
    @DisplayName("Test shallow clone of the Library")
    class shallowClonedLibrary {

        @Test
        void testGetBooks() {
            // given
            Library clonedLibrary = null;
            try {
                clonedLibrary = library.shallowCopy();
                clonedLibrary.setName("Library_1 shallow copy");
            } catch (CloneNotSupportedException exception) {
                System.out.println(exception);
            }

            System.out.println(library);
            System.out.println(clonedLibrary);

            // when
            library.getBooks().add(new Book("New Book", "New Author", LocalDate.of(2023, 10, 5)));

            // then
            System.out.println(library);
            System.out.println(clonedLibrary);
            assert clonedLibrary != null;
            assertEquals(library.getBooks().size(), clonedLibrary.getBooks().size());
            assertEquals(3, library.getBooks().size());
            assertNotEquals(2, clonedLibrary.getBooks().size());
            assertEquals(3, clonedLibrary.getBooks().size());
        }
    }

    @Nested
    @DisplayName("Test deep clone of the Library")
    class deepClonedLibrary {

        @Test
        void testGetBooks() {
            // given
            Library deepClonedLibrary = null;
            try {
                deepClonedLibrary = library.deepCopy();
                deepClonedLibrary.setName("Library_1 deep copy");
            } catch (CloneNotSupportedException exception){
                System.out.println(exception);
            }
            System.out.println(library);
            System.out.println(deepClonedLibrary);

            // when
            library.getBooks().add(new Book("New Book", "New Author", LocalDate.of(2023, 10, 5)));

            // then
            System.out.println(library);
            System.out.println(deepClonedLibrary);

            assertEquals(3, library.getBooks().size());
            assert deepClonedLibrary != null;
            assertEquals(2, deepClonedLibrary.getBooks().size());
            assertNotEquals(library.getBooks().size(), deepClonedLibrary.getBooks().size());
        }
    }
}
