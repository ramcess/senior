import java.io.*;
import java.util.*;
public class Student {
       public static void main(String[] args) throws IOException   {
        
       List n_list = new ArrayList();
       List d_list = new ArrayList();
       List p_list = new ArrayList();
       List i_list = new ArrayList();
       
for(;;)  { 
        System.out.println("무엇을 실행할지 선택해주세요");
        System.out.print("[1] 주소록 입력  [2] 주소록 전체 출력 : ");
        BufferedReader first = new BufferedReader(new InputStreamReader(System.in));
        int se;
        se = Integer.parseInt(first.readLine()); 
 
        switch (se) {
case 1: 
        System.out.print("이름을 입력하세요 : ");
        BufferedReader person = new BufferedReader(new InputStreamReader(System.in));
        String name;
        name = person.readLine();
        n_list.add(name);
        System.out.print("ID를 입력하세요 : ");
        String id;
        id  = person.readLine();
        i_list.add(id);
        System.out.print("학과 입력하세요 : ");
        String department;
        department = person.readLine();
        d_list.add(department);
        System.out.print("전화번호를 입력하세요 : ");
        String phone;
        phone = person.readLine();
        p_list.add(phone);
        
        System.out.println("-----------------------------------------------------------");
        System.out.println(name + "\t" + id + "\t" + department + "\t" + phone);
        System.out.println("항목이 추가되었습니다.");
        System.out.println("-----------------------------------------------------------");
             break;
      
case 2: 
        System.out.printf("\tID\t\t이름\t\t\t전공\t\t\t전화번호\n");
        System.out.println("-----------------------------------------------------------------------------");
         for(int i = 0 ; i < n_list.size() ; i++)
            System.out.printf("%d\t%s\t%s\t\t%s\t\t%s\n", i + 1, i_list.get(i), n_list.get(i), d_list.get(i), p_list.get(i));
              break;
      
 default: 
            System.out.print("다시 입력하세요");
            break;
        }
       }
      }
 
}
