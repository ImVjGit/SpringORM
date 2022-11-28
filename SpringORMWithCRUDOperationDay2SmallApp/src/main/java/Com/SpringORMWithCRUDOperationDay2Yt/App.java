package Com.SpringORMWithCRUDOperationDay2Yt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

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
		Scanner scanner = new Scanner(System.in);
		ApplicationContext cont = new ClassPathXmlApplicationContext("config.xml");

		StudDao std = (StudDao) cont.getBean("StudDao");

		Student s = new Student();

		int id = 0;
		String sname = null;
		String Scity = null;

		int choice = 0;
		while (choice != 6) {
			System.out.println("******Welcome*****");
			System.out.println("Enter your Choice");
			System.out.println("1.Adding New  Student");
			System.out.println("2.Update information");
			System.out.println("3.Display All Student ");
			System.out.println("4.Search Student Information By Id");
			System.out.println("5.Delete Student Information ");
			System.out.println("6.Exit");
			System.out.println("*************************");
			System.out.println("Enter your choice:  ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("Adding New Student Information ");
				System.out.println("Enter Id: ");
				id = scanner.nextInt();
				System.out.println("Enter Name: ");
				sname = scanner.nextLine();
				System.out.println("Enter City: ");
				Scity = scanner.nextLine();
				s.setStudentId(id);
				s.setStudentCity(Scity);
				s.setStudentName(sname);
				std.Insert(s);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("Data Insert ");
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
				break;
			case 2:
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("Enter Id: ");
				id = scanner.nextInt();
				try {
					boolean checkStudent = std.checkStudent(id);
					if (checkStudent == true) {
						System.out.println("Old Information");
						Student student = std.getStudent(id);
						System.out.println(student);
						System.out.println("******* Update Data Now ************");
						System.out.println("Enter Name: ");
						sname = scanner.next();
						System.out.println("Enter City: ");
						Scity = scanner.next();
						s.setStudentId(id);
						s.setStudentCity(Scity);
						s.setStudentName(sname);
						std.updateStudnet(s);
						System.out.println("Information Update scuccessfully");
					} else {
						System.out.println("Id is invalid !");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
				break;
			case 3:
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
				List<Student> listp = std.getAllStudent();
				for (Student str : listp) {
					System.out.println(str);
				}
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
				break;
			case 4:
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("One Student Information");
				System.out.println("Enter Id: ");
				id = scanner.nextInt();
				Student student = std.getStudent(id);
				System.out.println(student);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
				break;
			case 5:
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("Enter Id: ");
				id = scanner.nextInt();
				std.deleteStudent(id);
				System.out.println("Delete Student Id :" + id);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
				break;
			case 6:
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("Exit");
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
				break;

			default:
				System.out.println(" Invalid Input ");
				break;
			}

		}

	}
}
