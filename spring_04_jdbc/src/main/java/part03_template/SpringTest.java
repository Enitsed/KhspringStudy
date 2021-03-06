package part03_template;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("part03_template/jdbc.xml");

		MemDAO dao = (MemDAO) context.getBean("dao");

		// dao.insertMethod(new MemDTO("조현지", 23, "면목동"));// DB추가
		// dao.updateMethod(new MemDTO(38,"황현정"));
		// dao.deleteMethod(30);

		// DB 리스트 출력
		// List<MemDTO> list = dao.list();
		// for (MemDTO dto : list)
		// System.out.printf("%d %s %d %s\n", dto.getNum(), dto.getName(), dto.getAge(),
		// dto.getLoc());

		// one 메소드 , 선택한 번호에 맞는 데이터 값 다 가져옴
		// MemDTO dto = dao.one(41);
		// System.out.printf("%d %s %d %s\n", dto.getNum(), dto.getName(), dto.getAge(),
		// dto.getLoc());

		System.out.println("count:" + dao.countMethod()); // 레코트 수 출력

	}// end main()
}// end class