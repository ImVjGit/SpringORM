package Com.SpringORMDay1Yt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Com.DaoLayer.StudDao;
import Com.Entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext cont = new ClassPathXmlApplicationContext("config.xml");
	
				 StudDao std = (StudDao) cont.getBean("StudDao");
				 
				 Student s = new Student(12,"unika Patil ","Pune");
				 
				 
				 int i = std.Insert(s);
				 System.out.println("data Save "+i);
	
	}
}
