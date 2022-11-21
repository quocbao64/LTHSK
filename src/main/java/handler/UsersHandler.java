package handler;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.List;

import entity.Users;
import entity.UsersList;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class UsersHandler extends XmlAdapter<String, LocalDate> {
	public void writeUsersXML(List<Users> users, String xmlFile) {
		try {
			JAXBContext context = JAXBContext.newInstance(UsersList.class);
			
			UsersList usersList = new UsersList();
			usersList.setUsersList(users);
			
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(usersList, new FileWriter(new File(xmlFile)));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public LocalDate unmarshal(String v) throws Exception {
		 return LocalDate.parse(v);
	}

	@Override
	public String marshal(LocalDate v) throws Exception {
		 return v.toString();
	}
}
