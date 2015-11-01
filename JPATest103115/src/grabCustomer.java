import javax.persistence.EntityManager;
import customTools.DBUtil;

public class grabCustomer {

	public grabCustomer() {
	}

	public static void main(String[] args) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			model.DemoCustomer cust = em.find(model.DemoCustomer.class,(long)2);
			System.out.println(cust.getCustFirstName());
		}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			finally {
				em.close();
				System.out.println("Bağlantı Kapalı!");
			}

	}

}
