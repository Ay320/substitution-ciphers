# substitution-ciphers project
This project implements various types of substitution ciphers, including the Caesar cipher and the Vigenère cipher. 
The implementation utilizes Object-Oriented Programming (OOP) principles, such as inheritance and polymorphism, through the use of interfaces and abstract classes.
## Overview
The project consists of the following components:
1. **Cipher Interface**: Declares methods for encrypting and decrypting strings.
2. **Substitution Abstract Class**: Implements the `Cipher` interface with abstract methods for character encryption/decryption.
3. **MonoAlphaSubstitution Class**: A concrete subclass that implements monoalphabetical substitution ciphers.
4. **Caesar Class**: A subclass of `MonoAlphaSubstitution` for Caesar cipher encryption and decryption.
5. **Vigenère Class**: A subclass of `Substitution` that implements the Vigenère cipher, using a keyword for encryption and decryption.

## File Descriptions

### 1. Cipher.java
- **Description**: An interface that defines methods for encrypting and decrypting strings.
- **Key Methods**:
  - `String encrypt(String plainText)`
  - `String decrypt(String cipherText)`

### 2. Substitution.java
- **Description**: An abstract class with common methods to be used for Substitution ciphers.
- **Key Features**:
  - Abstract methods:
    - `public abstract char encrypt(char c)`
    - `public abstract char decrypt(char c)`
  - Concrete methods that translate strings:
    - `public String encrypt(String plaintext)`
    - `public String decrypt(String cryptotext)`

### 3. MonoAlphaSubstitution.java
- **Description**: A concrete subclass of `Substitution` that implements monoalphabetical substitution ciphers. Each character in the plaintext is replaced by a corresponding character in the substitution table.
- **Key Features**:
  - Two public constructors:
    - Default constructor for identity substitution.
    - Constructor that takes a string mapping for substitutions.

### 4. Caesar.java
- **Description**: A subclass of `MonoAlphaSubstitution` that provides methods for encrypting/decrypting messages using the Caesar cipher.
- **Key Features**:
  - Default constructor for default shift.
  - Constructor that takes an integer shift value for encryption.
- **Example Usage**:
  java Caesar encrypt 3 "My name is Ayham."

### 5. Vigenere.java
- **Description**: A subclass of Substitution that implements the Vigenère cipher. Each character in the plaintext is shifted according to a key consisting of multiple Caesar ciphers.
- **Key Features**:
  - Default constructor for identity substitution.
  - Constructor that takes a keyword for the cipher. It initializes the array of Caesar ciphers based on the provided key.
- **Example Usage**:
  java Vigenere encrypt COMPONETWOTWO "fun fun fun"
