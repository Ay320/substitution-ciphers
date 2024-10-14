import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a monoalphabetic substitution cipher,
 *  Each character in the plaintext is replaced by a corresponding character in the substitution table.
 * @author Aiham Ahmed
 */
public class MonoAlphaSubstitution extends Substitution {
    private Map<Character, Character> substitutionTable;   // to store the mapping 


    /**
     * Default constructor
     * Constructs an identity substitution table.
     */
    public MonoAlphaSubstitution() {
        this.substitutionTable = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            substitutionTable.put(c, c);
        }
    }

    /**
     * Constructor with String argument.
     *
     * @param key the substitution key used to create the substitution table.
     */
    public MonoAlphaSubstitution(String key) {
        this.substitutionTable = new HashMap<>();   // create new hashmap to store the table.
        for (int i = 0; i < key.length(); i += 2) {
            char plaintextChar = key.charAt(i);
            char ciphertextChar = key.charAt(i + 1);
            substitutionTable.put(plaintextChar, ciphertextChar);   //add the key and its value to the map.
        }
    }

    /**
     * Encrypts the given character using the substitution table.
     *
     * @param c the character to encrypt
     * @return the encrypted character
     */
    @Override
    public char encrypt(char c) {
        return substitutionTable.getOrDefault(c, c);     // get value associated with that key, if not found return c.
    }

    /**
     * Decrypts the given character using the substitution table.
     *
     * @param c the character to decrypt
     * @return the decrypted character
     */
    @Override
    public char decrypt(char c) {
        // Iterate over the entries in the substitution table to find the corresponding plaintext character.
    for (Map.Entry<Character, Character> entry : substitutionTable.entrySet()) {
        if (entry.getValue() == c) {
            return entry.getKey(); // Return the plaintext character
        }
    }

        return c;  // If the ciphertext character is not found in the substitution table, return the character itself.
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
            
            MonoAlphaSubstitution cipher = new MonoAlphaSubstitution(key);
            if (direction.equals("encrypt")) {
                 resultedMessage = cipher.encrypt(text);
                }
            else if (direction.equals("decrypt")) {
                 resultedMessage = cipher.decrypt(text);
            }
            else{
                System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
                System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
                return;
               }
            }
  
        else if (args.length >3) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }
        else{
            System.out.println("Too few parameters!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }

        System.out.println(resultedMessage);

    }

}
