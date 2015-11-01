 package software; 



import java.util.ArrayList;

import java.util.List;




public class TestAdd{

private String name;

private String number;




public TestAdd() {

super();

}




public TestAdd(String name, String number) {

super();

this.name = name;

this.number = number;

}




public String getName() {

return name;

}




public void setName(String name) {

this.name = name;

}




public String getNumber() {

return number;

}




public void setNumber(String number) {

this.number = number;

}




@Override

public String toString() {

return "TestAdd [name=" + name + ", number=" + number + "]";

}




}




class AddControl {

List<TestAdd> addList;




public AddControl() {

super();

addList = new ArrayList<>();

}




public void addPerson(String name, String number) {  //사람추가

addList.add(new TestAdd(name, number));

}




public void searchNumber(String name) { //이름찾기

int cnt = 0;

for (TestAdd a : addList) {

if (a.getName().equals(name)) {

System.out.println(a.toString());

cnt++;

}

}

if (cnt == 0) {

System.out.println("찾는 이름이 없습니다.");

} else {

System.out.println("총" + cnt + "개의 데이터 검색 완료");

}

}




public void namePrint() {  //이름출력

for (TestAdd a : addList) {

System.out.println(a.getName());

}

}




public void numberPrint() {  //번호출력

for (TestAdd a : addList) {

System.out.println(a.getNumber());

}

}




public void allPrint() {  //전부출력

for (TestAdd a : addList) {

System.out.println(a);

}

}




public void deleteData(String name) {  //이름제거




for (int loop1 = 0; loop1 < addList.size(); loop1++) {

if (addList.get(loop1).getName().equals(name)) {

addList.remove(loop1);

}

}




}




public static void main(String[] args) {

new AddControl();

//new AddControl().사용할 메소드

}




}