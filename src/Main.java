import java.util.Arrays;
import java.util.Scanner;

public class Main { // BAEKJOON 27210
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] dolArr = new int[N];

        if(N>10){   // 제출용 코드는 아니지만, 다 입력하기 번거로워서 자동으로 생성해줌
            for (int i = 0; i < N; i++) {
                dolArr[i] = ((int)(Math.random()*N))%2==1 ? 1:2;
            }
        }else{
            for (int i = 0; i < N; i++) {
                int dir = new Scanner(System.in).nextInt();
                if(dir==1||dir==2){
                    dolArr[i] = dir;
                }
            }
        }
        System.out.println(Arrays.toString(dolArr));


        int first = dolArr[0];
        int second = first>1? 1:2;

        int result = getResult(dolArr, first);
        System.out.println("==================");
        int result2 = getResult(dolArr, second);

        System.out.print("|(result - result2)| = ");
        System.out.println(result-result2<0? -(result-result2):result-result2);

    }

    private static int getResult(int[] dolArr, int std) {
        int result = 0;
        int warp = 0;
        for (int i = 0; i < dolArr.length; i++) {
            if(i>0 && std == dolArr[i] && dolArr[i-1]== dolArr[i]){
                for (int j = i; j < dolArr.length; j++) {

                    if(dolArr[i]!= dolArr[j]){
                        warp = j;
                        break;
                    }else if(j== dolArr.length-1){
                        warp = dolArr.length;
                        break;
                    }
                }
                if(warp >0){
                    result += (warp -i+1);
                    i= warp -1; warp =0;
                }
            }
        }
        return result;
    }
}
