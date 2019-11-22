import java.util.HashMap;
import java.util.Scanner;

public class Technolutions {
/*
Created by Dilwar Singh (dilwarsingh2706@gmail.com)
on 22-Nov-2019
* */
    private static HashMap<Integer, Integer> directionsVal = new HashMap<>();
    private static char[] directions = {'N', 'E', 'S', 'W',};

    public static void main(String[] args) {

        directionsVal.put((int) 'N', 1);
        directionsVal.put((int) 'E', 1);
        directionsVal.put((int) 'S', -1);
        directionsVal.put((int) 'W', -1);

        Scanner s = new Scanner(System.in);

        int X = s.nextInt();
        int Y = s.nextInt();
        while (s.hasNextInt()) {
            int x = s.nextInt();
            int y = s.nextInt();
            char c = s.next().toCharArray()[0];
            s.nextLine();
            char[] q = s.nextLine().toCharArray();

            System.out.println(solve(X, Y, x, y, c, q));
        }
    }

    private static String solve(int X, int Y, int x, int y, char c, char[] q) {
        int cPostion = 0;
        for (int i = 0; i < directions.length; i++) {
            if (directions[i] == c) {
                cPostion = i;
                break;
            }
        }

        for (int i = 0; i < q.length; i++) {
            //   System.err.println(x + " " + y + " " + c);
            char now = q[i];
            if (now == 'P') { //rotate left
                cPostion = (--cPostion + 4) % 4;
                c = directions[cPostion];
            } else if (now == 'R') { //rotate right
                cPostion = (++cPostion) % 4;
                c = directions[cPostion];
            } else {
                if (c == 'N' || c == 'S') {
                    y += directionsVal.get((int) c);
                } else {
                    x += directionsVal.get((int) c);
                }
            }
        }
        return x + " " + y + " " + c;
    }
}
