import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String x = "c6";
        String[] result = x.split("");
        System.out.println(Arrays.toString(result));

        int s = Integer.parseInt(result[1]);
        s = s + 10;
        System.out.println(s);

    }
}
