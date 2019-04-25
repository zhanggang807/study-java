package arithmetic;

/**
 * 数学解法
 * Creted by Dean on 2019-04-24.
 */
public class JosephusCircle {

    public static void main(String[] args) {
        //数数儿数到20
        int m = 20;
        //6个人组成一个人环来数数儿
        int n = 6;

        int s = 0;

        for (int i = 2; i <= n; i++) {
            s = (s + m) % i;
        }

        System.out.println("最后胜利者的序号是:" + (s + 1));

    }

}
