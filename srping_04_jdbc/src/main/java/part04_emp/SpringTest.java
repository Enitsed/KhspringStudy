package part04_emp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {

		/*
		 * Employees 테이블에서 salary이 높은 5-10 랭크에 해당하는 employee_id, first_name, salary,
		 * hire_date을 출력하시오.
		 */

		ApplicationContext context = new ClassPathXmlApplicationContext("part04_emp/jdbc.xml");

		EmpDAO dao = (EmpDAO) context.getBean("dao");

		List<EmpDTO> list = dao.list();

		for (EmpDTO dto : list) {
			System.out.printf("%d %s %d %s \n", dto.getEmployee_id(), dto.getFirst_name(), dto.getSalary(),
					dto.getHire_date());
		}

	}// end main()
}// end class