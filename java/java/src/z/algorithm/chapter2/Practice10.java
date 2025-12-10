package z.algorithm.chapter2;
//2-10. 봉우리
/*
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2
 */
import java.util.Scanner;

public class Practice10 {
    public int solution(int[][] arr, int n){
        int answer = 0;
        int[] dx = {-1,0,1,0}; // 상, 우, 하, 좌
        int[] dy = {0,1,0,-1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for(int k=0;k<4;k++){
                    int index1 = i+dx[k];
                    int index2 = j+dy[k];
                    if(index1>=0 && index2>=0 && index1<n && index2<n && arr[i][j] <= arr[index1][index2]){
                        flag = false;
                        break;
                    }
                }
                if(flag){answer++;}
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        Practice10 p = new Practice10();
        System.out.println(p.solution(arr,n));
    }
}
