package com.sankdev.files.content.comparison;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FilesMismatchUnitTest {

  public static Path filePath1 = null;
  public static Path filePath2 = null;

  @BeforeAll
  public static void setup() throws IOException {
    filePath1 = Files.createTempFile("file1", ".txt");
    filePath2 = Files.createTempFile("file2", ".txt");
  }

  @Test
  public void givenIdenticalFiles_thenShouldFindMismatch() throws IOException {

    Files.writeString(filePath1, "Test file contents");
    Files.writeString(filePath2, "Test file contents");

    long mismatchIdx = Files.mismatch(filePath1, filePath2);

    Assertions.assertEquals(-1, mismatchIdx, "The files are not identical");
  }

  @Test
  public void givenDifferentFiles_thenShouldNotFindMismatch() throws IOException {

    Files.writeString(filePath1, "Test file 1 contents");
    Files.writeString(filePath2, "Test file 2 contents");

    long mismatchIdx = Files.mismatch(filePath1, filePath2);

    Assertions.assertEquals(10, mismatchIdx, "Should have found mismatch at position 10");
  }

  @AfterAll
  public static void cleanup() {
    filePath1.toFile().deleteOnExit();
    filePath2.toFile().deleteOnExit();
  }

}
