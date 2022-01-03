import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ConnectionTest {
	private SqlSession sqlSession;
	
	public ConnectionTest(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("mapper/bean.xml");
		ConnectionTest test=(ConnectionTest)ctx.getBean("ConnectionTest");
		System.out.println("연결 성공");
	}
}
