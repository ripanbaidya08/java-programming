package in.pwskills.nitin.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.pwskills.nitin.bean.PersonInfo;
import in.pwskills.nitin.util.HibernateUtil;

public class LoadApp {

	public static void main(String[] args) {

		Session session = null;
		int id = 1;

		try {
			session = HibernateUtil.getSession();
			PersonInfo person = session.get(PersonInfo.class, id);
			if (person != null) {
				System.out.println(person);
			} else {
				System.out.println("Record not availalbe for the id :: " + id);
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}
	}
}
