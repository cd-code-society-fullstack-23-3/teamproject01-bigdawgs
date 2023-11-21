package com.codedifferently.project;

public class User {
    private String firstName;
    private String lastName;
    private Integer cipherCode;

    public User(String firstName, String lastName, Integer cipherCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cipherCode = cipherCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCipherCode() {
        return cipherCode;
    }

    public void setCipherCode(Integer cipherCode) {
        this.cipherCode = cipherCode;
    }

    public String encodeMessage(String message){
        if (message == null) {
            return null;
        }

        StringBuilder encoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int offset = (c - base + cipherCode) % 26;
                encoded.append((char) (base + offset));
            } else {
                encoded.append(c); // Non-letter characters are not shifted
            }
        }

        return encoded.toString();
    }

    public String decodeMessage(String message){
        if (message == null) {
            return null;
        }

        StringBuilder decoded = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int offset = (c - base - cipherCode) % 26;
                if (offset < 0) {
                    offset += 26; // Adjust for negative offset
                }
                decoded.append((char) (base + offset));
            } else {
                decoded.append(c); // Non-letter characters are not shifted
            }
        }

        return decoded.toString();
    }


    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("User: %s %s, has code %d", firstName, lastName, cipherCode));
        return builder.toString();
    }
}
