package com.kodilla.exception.test;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuite {

    @Test
    void testReadFile() {
        // given
        FileReader reader = new FileReader();

        // when, then
        assertDoesNotThrow(() -> reader.readFile());
    }

    @Test
    void whenFileDoesntExistReadFileShouldThrowException() {
        // given
        FileReader fileReader = new FileReader();
        String fileName = "nothing";

        // when, then
        assertThrows(FileReaderException.class, () -> fileReader.readFile(fileName));
    }

    @Test
    void testReadFileWithName() {
        // given
        FileReader fileReader = new FileReader();

        // when, then
        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile("nothing here")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(null)),
                () -> assertDoesNotThrow(() -> fileReader.readFile("names.txt"))
        );
    }
}
