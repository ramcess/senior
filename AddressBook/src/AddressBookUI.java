import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class AddressBookUI {


	private AddressBookManager mgr = new AddressBookManager();
	private static final String ADDRESS_FILE = "/home/kim/java/주소록관리/google.csv";
	private static final String ENTER = System.getProperty("line.separator");
	
	private void readCSV() throws IOException {
		FileReader fr = null;
		try {
			fr = new FileReader(ADDRESS_FILE);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("CSV 파일이 없습니다.");
		}
		BufferedReader br = new BufferedReader(fr);
		String addrStr = null;

		
		try {
			br.readLine(); 
			while ((addrStr = br.readLine()) != null) {
				
				String[] addrArray = addrStr.split(",", -1);
				String name = addrArray[0];
				String mobile = addrArray[30];
				String email = addrArray[28];
				String department = addrArray[34];
				AddressBook addressBook = new AddressBook(name,mobile,email,department);
				mgr.addAddressBook(addressBook);
			}
		} catch (IOException e) {
			throw new IOException("CSV 파일을 읽는데 실패했습니다.");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void startWork() {
		try {
			readCSV();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("파일로부터 주소록을 로딩하는데 실패했지만 프로그램을 진행합니다.");
		}
		
		String menu = null;
		
		do {
			System.out.println(" ** 메뉴를 선택하세요 ** ");
			System.out.println(" 1. 등록   ");
			System.out.println(" 2. 목록   ");
			System.out.println(" 3.  찾기(키워드)   ");
			System.out.println(" 4.  수정   ");
			System.out.println(" 5. 삭제   ");
			System.out.println(" q. 종료   ");
			System.out.println(" ********************** ");
			System.out.print(">>");
			
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				menu = br.readLine();

				if (menu.equals("1")) {
					// register
					System.out.print("이름을 입력하세요>>");
					String name = br.readLine();
					System.out.print("전화번호를 입력하세요>>");
					String mobile = br.readLine();
					System.out.print("이메일을 입력하세요>>");
					String email = br.readLine();
					System.out.print("학과를 입력하세요>>");
					String department = br.readLine();
					AddressBook addressBook = new AddressBook(name, mobile, email, department);
					mgr.addAddressBook(addressBook);
				} else if ( menu.equals("2") ) {
					// list
					ArrayList<AddressBook> addressBooks = mgr.getAddressBooks();
					int total = addressBooks.size();
					for (int i = 0; i < total; i++) {
						System.out.println(addressBooks.get(i));
					}
				} else if ( menu.equals("3") ) {
					// search(keyword)
					System.out.print("키워드를 입력하세요>>");
					String keyword = br.readLine();
					ArrayList<AddressBook> matchedAddressBooks = mgr.findAddressBook(keyword);
					int total = matchedAddressBooks.size();
					for (int i = 0; i < total;i++) {
						System.out.println(matchedAddressBooks.get(i));
					}
				} else if (menu.equals("4")) {
					//수정
					System.out.print("번호를 입력하세요>>");
					int no = Integer.parseInt(br.readLine());
					AddressBook addressBook = mgr.findAddressBook(no);
					if (addressBook != null) {
						System.out.print("변경하려는 이름을 입력하세요.[변경하지 않으려면 그냥 엔터]>>");
						String name = br.readLine();
						if (!name.equals("")) {
							addressBook.setName(name);
						}
						System.out.print("변경하려는 손전화를 입력하세요.[변경하지 않으려면 그냥 엔터]>>");
						String mobile = br.readLine();
						if (!mobile.equals(mobile)) {
							addressBook.setMobile(mobile);
						}
						System.out.print("변경하려는 이메일을 입력하세요.[변경하지 않으려면 그냥 엔터]>>");
						String email = br.readLine();
						if (!email.equals("")) {
							addressBook.setEmail(email);
						}
						System.out.print("변경하려는 회사를 입력하세요.[변경하지 않으려면 그냥 엔터]>>");
						String department = br.readLine();
						if (!department.equals("")) {
							addressBook.setDepartment(department);
						}
					} else {
						System.out.println("번호를 잘못입력하셨습니다.");
					}
				} else if (menu.equals("5")) {
					// 삭제
					System.out.print("삭제할 주소록 번호를 입력하세요>>");
					int no = Integer.parseInt(br.readLine());
					AddressBook addressBook = mgr.findAddressBook(no);
					if (addressBook != null) {
						System.out.print("정말로 삭제하려면 1을 입력하세요>>");
						int chk = Integer.parseInt(br.readLine());
						if (chk == 1) {
							mgr.deleteAddressBook(no);
						}
					} else {
						System.out.println("번호를 잘못 입력하셨습니다.");
					}
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!menu.equals("q"));
		
	}
	
	public void endWork() {
		StringBuilder sb = new StringBuilder();
		ArrayList<AddressBook> addressBooks = mgr.getAddressBooks();
		int total = addressBooks.size();
		sb.append("Name,Mobile Phone,E-mail Address,Company");
		sb.append(ENTER);
		for (int i = 0; i < total; i++) {
			sb.append(addressBooks.get(i).toCSV());
			sb.append(ENTER);
		}
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(ADDRESS_FILE, false);
			bw = new BufferedWriter(fw);
			bw.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		AddressBookUI ui = null;
		try {
			ui = new AddressBookUI();
			ui.startWork();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ui.endWork();
		}
		System.out.println("프로그램이 정상적으로 종료되었습니다.");
	}
}
