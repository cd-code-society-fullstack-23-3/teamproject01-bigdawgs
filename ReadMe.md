# Caesar Cipher Communication System

### Overview:

In this lab, you will create a Java program that uses a Caesar cipher to encode and decode messages. Your program will also manage user data, associating each user with a unique Caesar cipher shift value.

### Objectives:

1. **Understand the Caesar Cipher**: Research the Caesar cipher to understand how it encrypts and decrypts messages by shifting letters in the alphabet.

2. **Create a User Class**: Design a `User` class in Java. Each user should have a first name, last name, and a unique cipher code (an integer representing the shift value for the Caesar cipher).
3. **Store Users in an Array**: Implement functionality in your program to store multiple `User` objects in an array.

4. **Encrypt and Decrypt Messages**: Write methods for encrypting and decrypting messages using the Caesar cipher. The encryption and decryption should be based on the user's unique cipher code.

5. **User Lookup**: Allow your program to search for a user by their first and last name in the array of `User` objects.

6. **Process Messages**: Once the user is found, the program should be able to decrypt messages intended for that user using their specific cipher code.

### Requirements:

- **Research**: Begin by researching the Caesar cipher. Understand how it shifts letters and how encryption and decryption work.

- **Design the User Class**: Your `User` class should store the first name, last name, and cipher code of a user. Think about what methods you might need for this class.

- **Manage User Data**: Figure out how to add and retrieve `User` objects from an array. Consider how you will handle cases where a user is not found.

- **Implement the Cipher**: Write the logic to shift letters in a message to encrypt or decrypt it according to the Caesar cipher method. Remember to handle the wrapping of letters (e.g., 'z' shifts to 'a').

- **User Interaction**: Your program should prompt the user to enter a name and a message. Based on this input, it should find the relevant user and display the decrypted message.

### Tips:

- **Test as You Go**: Regularly test your program with different inputs to ensure each part works correctly before moving on to the next.

- **Error Handling**: Think about what your program should do if a user is not found or if the input format is incorrect.

- **Keep It Simple**: Start with the basics and get those working before adding more advanced features.

- **Comment Your Code**: Write comments to explain your logic, which will help you debug and help others understand your code.


## User Stories

1. **As a user, I want to add a new user to the system, so that I can encode and decode messages for that person.**
    - The app should allow adding a user with their first name, last name, and unique cipher code.

2. **As a user, I want to search for a specific user by name, so that I can use their unique cipher code for message encryption or decryption.**
    - Implement a feature to search and select a user based on their first and last name.

3. **As a user, I need to encrypt a message using the Caesar Cipher, so that I can send a secure message.**
    - The app should provide a way to input a message and encrypt it using the cipher code of the selected user.

4. **As a user, I need to decrypt a received message using the Caesar Cipher, so that I can read its contents.**
    - The app should allow the input of an encrypted message and decrypt it using the cipher code of the relevant user.

5. **As a user, I want the application to handle invalid inputs or errors gracefully, so that I can understand and correct my actions.**
    - Ensure the app provides helpful error messages for invalid inputs or when a user is not found.

6. **As a user, I want to view a list of all users, so that I can choose whom to send or receive messages from.**
    - The app should have the functionality to display all users currently stored in the system.

7. **As a user, I want clear instructions and prompts in the application, so that I can easily navigate and use its features.**
    - Design the user interface to be intuitive with straightforward prompts and instructions.

8. **As a user, I want the ability to update a user’s information, so that I can correct mistakes or change the cipher code.**
    - Include functionality for editing the details of an existing user in the system.

9. **As a user, I want the option to remove a user from the system, so that I can keep the user list current and accurate.**
    - Implement a feature to delete a user from the array of users.

10. **As a user, I want the program to remember users even after it's closed, so that I don’t have to re-enter user information every time.**
    - Consider implementing file I/O to save and load user data from a file.
