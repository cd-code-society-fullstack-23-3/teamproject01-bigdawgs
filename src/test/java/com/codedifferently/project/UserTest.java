package com.codedifferently.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testConstructorWithValidData() {
        // Given
        String firstName = "Tariq";
        String lastName = "CodeGoat";
        Integer cipherCode = 123;

        // When
        User user = new User(firstName, lastName, cipherCode);

        String expected = "User: Tariq CodeGoat, has code 123";
        String actual = user.toString();
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void testSetAndGetFirstName() {
        // Given
        User user = new User("Tariq", "CodeGoat", 123);
        String newFirstName = "Jane";

        // When
        user.setFirstName(newFirstName);

        // Then
        assertEquals(newFirstName, user.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        // Given
        User user = new User("Tariq", "CodeGoat", 123);
        String newLastName = "Smith";

        // When
        user.setLastName(newLastName);

        // Then
        assertEquals(newLastName, user.getLastName());
    }

    @Test
    public void testSetAndGetCipherCode() {
        // Given
        User user = new User("Tariq", "CodeGoat", 123);
        Integer newCipherCode = 456;

        // When
        user.setCipherCode(newCipherCode);

        // Then
        assertEquals(newCipherCode, user.getCipherCode());
    }

    @Test
    public void testEncodeMessageWithMixedLetters() {
        User user = new User("Tariq", "CodeGoat", 10);
        String result = user.encodeMessage("HelloWorld");
        assertEquals("RovvyGybvn", result);
    }

    @Test
    public void testEncodeMessageWithNonLetterCharacters() {
        User user = new User("Tariq", "CodeGoat", 10);
        String result = user.encodeMessage("Hello, World!");
        assertEquals("Rovvy, Gybvn!", result);
    }

    @Test
    public void testEncodeMessageWithWrapAround() {
        User user = new User("Tariq", "CodeGoat", 10);
        String result = user.encodeMessage("xyzXYZ");
        assertEquals("hijHIJ", result);
    }

    @Test
    public void testDecodeMessageWithMixedLetters() {
        User user = new User("Tariq", "CodeGoat", 10);
        String result = user.decodeMessage("RovvyGybvn");
        assertEquals("HelloWorld", result);
    }

    @Test
    public void testDecodeMessageWithNonLetterCharacters() {
        User user = new User("Tariq", "CodeGoat", 10);
        String result = user.decodeMessage("Rovvy, Gybvn!");
        assertEquals("Hello, World!", result);
    }
}
