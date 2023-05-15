package jardin;

import java.util.Scanner;

public class InputReader {
    private Scanner sc;

    public InputReader() {
        this.sc = new Scanner(System.in);
    }

    public int readIntValue() {
        return sc.nextInt();
    }
}
