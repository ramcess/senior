
import java.util.ArrayList;
public class AddressBookManager {
private ArrayList<AddressBook> addressBooks = new ArrayList<AddressBook>();
	
	public AddressBookManager(){}

	//새로운 주소록을 등록한다.
	public void addAddressBook(AddressBook addressBook) {
		addressBooks.add(addressBook);
	}
	
	//주소록을 번호로 찾는다.
	public AddressBook findAddressBook(int no) {
		AddressBook addressBook = null;
		int total = addressBooks.size();
		for (int i = 0; i < total; i++) {
			if (no == addressBooks.get(i).getId()) {
				addressBook = addressBooks.get(i);
			}
		}
		return addressBook;
	}
		
	//주소록을 검색어로 찾는다.
	public ArrayList<AddressBook> findAddressBook(String keyword) {
		ArrayList<AddressBook> matchedAddressBooks = new ArrayList<AddressBook>();
		int total = addressBooks.size();
		for(int i = 0; i < total; i++) {
			AddressBook addressBook = addressBooks.get(i);
			if (addressBook.getName().indexOf(keyword) != -1 || 
					addressBook.getMobile().indexOf(keyword) != -1 || 
					addressBook.getEmail().indexOf(keyword) != -1 || 
					addressBook.getDepartment().indexOf(keyword) != -1) {
				matchedAddressBooks.add(addressBook);
			}
		}
		
		return matchedAddressBooks;
	}

	//주소록을 삭제한다.
	public void deleteAddressBook(int id) {
		AddressBook addressBook = findAddressBook(id);
		if (addressBook != null) {
			addressBooks.remove(addressBook);
		}
	}
	
	//모든 주소록 목록을 본다.
	public ArrayList<AddressBook> getAddressBooks() {
		return addressBooks;
	}
}
