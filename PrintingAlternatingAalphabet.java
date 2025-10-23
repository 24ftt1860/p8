public class  PrintingAlternatingAlphabet {
    public static void main(String[] args) {
              String[] letters = {
            "a","b","c","d","e","f","g","h","i","j","k","l","m",
            "n","o","p","q","r","s","t","u","v","w","x","y","z"
        };

        for (int i = 0, j = letters.length - 1; i < letters.length; i++, j--) {
            System.out.print(letters[i] + " " + letters[j]);
            if (i != letters.length - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
