/*
 * Abstract class with common methods to be used for Substitution ciphers.
 * Abstarct methods must be overridden by subclasses
 * 
 */
public abstract class Substitution implements Cipher{

    /**
     * Encrypts a single character.
     *
     * @param c the character to encrypt
     * @return the encrypted character
     */
    public abstract char encrypt(char c);

    /**
     * Decrypts a single character.
     *
     * @param c the character to decrypt
     * @return the decrypted character
     */
    public abstract char decrypt(char c);

    /**
     * Encrypts a plaintext string.
     * Calls the encrypt(char) mathod for each char in the text.
     *
     * @param plaintext the plaintext to encrypt
     * @return the encrypted ciphertext
     */
    public String encrypt(String plaintext){
        StringBuilder encryptedMessage = new StringBuilder();

        for(int i=0;i<plaintext.length();i++){
            char currentChar = plaintext.charAt(i);
            encryptedMessage.append(encrypt(currentChar));
        }
        return encryptedMessage.toString();
    }

    /**
     * Decrypts a ciphertext string.
     * 
     * Calls the decrypt(char) mathod for each char in the text.
     * @param cryptotext the ciphertext to decrypt
     * @return the decrypted plaintext
     */
    public String decrypt(String cryptotext){
        StringBuilder decryptedMessage = new StringBuilder();

        for(int i=0;i<cryptotext.length();i++){
            char currentChar = cryptotext.charAt(i);
            decryptedMessage.append(decrypt(currentChar));
        }
        return decryptedMessage.toString();

    }
}