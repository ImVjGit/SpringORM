package Com.DaoLayer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import Com.Entity.Student;

public class StudDao {

	private HibernateTemplate hibernateTamplate;
	
	//insert data
	@Transactional
	public int Insert(Student stud) {

		Integer value = (Integer)hibernateTamplate.save(stud);
		return value;

	}
	
	//get only one data
	public Student getStudent(int studId)
	{
		Student student = hibernateTamplate.get(Student.class,studId);
		return student;
	}
	
	//get all data from table
	public List<Student> getAllStudent()
	{
		List<Student> list = hibernateTamplate.loadAll(Student.class);
	
		return list;
	}
	
	//delete one data
	@Transactional
	public void deleteStudent(int studId)
	{
			try {
				Student student = hibernateTamplate.get( Student.class,studId);
				hibernateTamplate.delete(student);
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//updating data of student
	@Transactional
	public void updateStudnet(Student student)
	{
		try {
			hibernateTamplate.update(student);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public HibernateTemplate getHibernateTamplate() {
		return hibernateTamplate;
	}

	public void setHibernateTamplate(HibernateTemplate hibernateTamplate) {
		this.hibernateTamplate = hibernateTamplate;
	}
	
	public boolean checkStudent(int studId)
	{
		Student student = hibernateTamplate.get(Student.class,studId);
		return true;
	}

	
}
