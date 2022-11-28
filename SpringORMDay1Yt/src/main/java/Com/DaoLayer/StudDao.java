package Com.DaoLayer;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import Com.Entity.Student;

public class StudDao {

	private HibernateTemplate hibernateTamplate;
	
	@Transactional
	public int Insert(Student stud) {

		Integer value = (Integer) this.hibernateTamplate.save(stud);
		return value;

	}

	public HibernateTemplate getHibernateTamplate() {
		return hibernateTamplate;
	}

	public void setHibernateTamplate(HibernateTemplate hibernateTamplate) {
		this.hibernateTamplate = hibernateTamplate;
	}

	
}
