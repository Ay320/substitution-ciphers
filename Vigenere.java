/**
 * A class representing the Vigenere cipher.
 * Each character in the plaintext is shifted according to a key consisting of multiple Caesar ciphers.
 * @author Aiham Ahmed
 */
public class Vigenere extends Substitution{
    private Caesar[] caesars;
    private int keyIndex;

    /**
     * Default constructor.
     * Initializes an empty array of Caesar ciphers.
     */
    public Vigenere() {
        caesars = new Caesar[0]; // Initialize an empty array of Caesars
    }

    /**
     * Constructor with a key argument.
     * Initializes the array of Caesar ciphers based on the provided key.
     * @param key The key for the Vigenere cipher.
     */
    public Vigenere(String key) {
        key = key.toUpperCase();         // key is assumed to be capitalized, but check anyway.
        caesars = new Caesar[key.length()];         // Initialize Caesars array
        for (int i = 0; i < key.length(); i++) {
            char currentChar = key.charAt(i);
            if (Character.isLetter(currentChar)) {
                int shift = currentChar - 'A'; 
                caesars[i] = new Caesar(shift-12224);       // -12224 bcz in Caesar class we added 12224 to shift.
            }
        }
        
    }

    
    
    /**
     * Encrypts a single character using the Vigenere cipher.
     * @param c The character to be encrypted.
     * @return The encrypted character.
     */
    @Override
    public char encrypt(char c) {
        if (Character.isLetter(c)) {
            // Get the Caesar cipher corresponding to the current position in key.
            Caesar currentCaesar = caesars[keyIndex % caesars.length];
            keyIndex++;
            return currentCaesar.encrypt(c);
       }   
    else {
        keyIndex++;
        // If it is not a character, return it unchanged.
        return c;
     }
 }

    /**
     * Decrypts a single character using the Vigenere cipher.
     * @param c The character to be decrypted.
     * @return The decrypted character.
     */
    @Override
    public char decrypt(char c) {
        if (Character.isLetter(c)) {
            Caesar currentCaesar = caesars[keyIndex % caesars.length];
            keyIndex++;
            return currentCaesar.decrypt(c);
             }
        else {
            keyIndex++;
            return c;
        }   
}

    /**
     * Main method.
     * 
     * @param args we expect three arguments only.
     *             args[0] should be the direction "encrypt" or "decrypt".
     *             args[1] should be the key.
     *             args[2] should be the message to be encrypted or decrypted.
     */
 public static void main(String[] args) {
    // store final message:
    String resultedMessage="";

    if (args.length == 3){
        // for readibility:
        String direction = args[0];
        String key = args[1];
        String text = args[2];

        Vigenere cipher = new Vigenere(key);
        if (direction.equals("encrypt")) {
            resultedMessage = cipher.encrypt(text);    // .encrypt(String) inherited from Substitution class.

        }
        else if (direction.equals("decrypt")) {
            resultedMessage = cipher.decrypt(text);   // .decrypt(String) inherited from Substitution class.

        }
        else{
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
            return;
        }
    }

    else if (args.length >3) {
        System.out.println("Too many parameters!");
        System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
    }
    else{
        System.out.println("Too few parameters!");
        System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
    }

    System.out.println(resultedMessage);
       }
}