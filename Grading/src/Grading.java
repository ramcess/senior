
public class Grading{
public static void main(String[] args) {
       int[][] arr = {{ 1, 3, 2, 4, 3, 1, 4, 2, 2, 1 }, 
                             { 3, 2, 4, 2, 2, 1, 1, 3, 4, 1 }, 
                             { 2, 4, 3, 2, 1, 2, 1, 3, 3, 4 }, 
                             { 2, 3, 3, 1, 1, 3, 2, 2, 4, 4 }, 
                             { 3, 1, 1, 2, 4, 1, 2, 3, 1, 3 } };

        if ( args.length == 10 ) {
                int[] arrPoint = new int[arr.length]; // ���� �л��� ������ ������ �迭

                for (int i=0; i < arr.length; i++) {
                        for ( int j=0; j < arr[0].length; j++) {
                               // �����̸�
                                if ( arr[i][j] == Integer.parseInt(args[j]) ) {
                                       arrPoint[i]++; // ���� ���� 
                                }
                        }
                 }
                 
                 for ( int k=0; k < arrPoint.length; k++) {
                          System.out.print("�л�"+k+"�� ���� : " + arrPoint[k]);
                 }
         } else {
                System.out.println("������ ������ ���� �ʽ��ϴ�.");
         }
     }
 }