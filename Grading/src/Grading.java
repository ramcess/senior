
public class Grading{
public static void main(String[] args) {
       int[][] arr = {{ 1, 3, 2, 4, 3, 1, 4, 2, 2, 1 }, 
                             { 3, 2, 4, 2, 2, 1, 1, 3, 4, 1 }, 
                             { 2, 4, 3, 2, 1, 2, 1, 3, 3, 4 }, 
                             { 2, 3, 3, 1, 1, 3, 2, 2, 4, 4 }, 
                             { 3, 1, 1, 2, 4, 1, 2, 3, 1, 3 } };

        if ( args.length == 10 ) {
                int[] arrPoint = new int[arr.length]; // 각각 학생의 점수를 저장할 배열

                for (int i=0; i < arr.length; i++) {
                        for ( int j=0; j < arr[0].length; j++) {
                               // 정답이면
                                if ( arr[i][j] == Integer.parseInt(args[j]) ) {
                                       arrPoint[i]++; // 점수 증가 
                                }
                        }
                 }
                 
                 for ( int k=0; k < arrPoint.length; k++) {
                          System.out.print("학생"+k+"의 점수 : " + arrPoint[k]);
                 }
         } else {
                System.out.println("정답의 갯수가 맞지 않습니다.");
         }
     }
 }