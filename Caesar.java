/**
 * The Caesar class provides methods for encrypting/decrypting messages using the Caesar cipher..
 * It shifts each letter in the plaintext by a fixed number of positions in the alphabet.
 * @author Aiham Ahmed
 */
public class Caesar extends MonoAlphaSubstitution{
    private int shift;

     /**
      * Default constructor.
     * sets the default shift to 0.
     */
    public Caesar(){
        this.shift = 0;
    }

     /**
     * Constructor with a specified shift value.
     *
     * @param shift the shift value for the Caesar cipher
     */
     public Caesar(int shift) {
        this.shift = (shift + 12224) % 26;
    }


     /**
     * Encrypts the given character using the Caesar cipher.
     *
     * @param c the character to encrypt
     * @return the encrypted character
     */
     @Override
     public char encrypt(char c) {
         if (Character.isLowerCase(c)) {
             return (char) ('a' + (c - 'a' + this.shift) % 26);
         } else if (Character.isUpperCase(c)) {
             return (char) ('A' + (c - 'A' + this.shift) % 26);
         } else {
             return c; // Return the character itself for non-alphabetic characters
         }
     }


     /**
     * Decrypts the given character using the Caesar cipher.
     *
     * @param c the character to decrypt
     * @return the decrypted character
     */
    @Override
    public char decrypt(char c) {
        if (Character.isLowerCase(c)) {
            return (char) ('a' + (c - 'a' - this.shift + 26) % 26);
        } else if (Character.isUpperCase(c)) {
            return (char) ('A' + (c - 'A' - this.shift + 26) % 26);
        } else {
            return c; // Return the character itself for non-alphabetic characters
        }
    }
    
    /**
     * Main method.
     * @param args we expect three arguments only.
     *             args[0] should be the direction "encrypt" or "decrypt".
     *             args[1] should be the shift.
     *             args[2] should be the message to be encrypted or decrypted.
     */
    public static void main(String[] args) {
        // store final message:
        String resultedMessage="";

        if (args.length == 3){
            // for readibility:
            String direction = args[0];
            int shift = Integer.parseInt(args[1]);
            String text = args[2];

            Caesar cipher = new Caesar(shift);
            if (direction.equals("encrypt")) {
                resultedMessage = cipher.encrypt(text);

            }
            else if (direction.equals("decrypt")) {
                resultedMessage = cipher.decrypt(text);

            }
            else{
                System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
                System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
                return;
            }
        }

        
        else if (args.length >3) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
        }
        else{
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
        }

        System.out.println(resultedMessage);

    }
  
}