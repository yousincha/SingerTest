import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test1 {
	private SqlSession sqlSession;
	
	public Test1(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	public void insert(Singer singer) {
		sqlSession.insert("exam.test.SingerMapper.insertSinger",singer);
		System.out.println("레코드 삽입");
	}
	
	public void selectOne() {
		int count=sqlSession.selectOne("exam.test.SingerMapper.getSingerCount");
		System.out.println("그룹수: "+ count);
	}

	public void selectOne1(String name) {
		int count=sqlSession.selectOne("exam.test.SingerMapper.getSingerMember", name);
		System.out.println("그룹멤버수: "+ count);
	}
	public void selectList(int member) {
		List<Singer> singers=sqlSession.selectList("exam.test.SingerMapper.getSingers", member);
		for(Singer singer:singers)
			System.out.println("그룹 이름:"+singer.getName());
	}
	public void update(Singer singer) {
		sqlSession.update("exam.test.SingerMapper.updateSinger", singer);
		System.out.println("레코드 업데이트");
	}
	public void delete(String name) {
		sqlSession.delete("exam.test.SingerMapper.deleteSinger", name);
		System.out.println("레코드 삭제");
	}
	
	public void selectOne2(String name, int member) {
		Map<String,Object> paramMap=new HashMap<String, Object>();
		paramMap.put("name", name);
		paramMap.put("member",member);
		String rname=sqlSession.selectOne("exam.test.SingerMapper.getSinger1", paramMap);
		System.out.println(rname);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("Mapper/bean.xml");
		Test1 test1=(Test1)ctx.getBean("test1");
		test1.insert(new Singer("DH",1015));
		test1.insert(new Singer("EH",4));
		test1.insert(new Singer("슈주",1106));
		test1.insert(new Singer("zgroup",8));
		test1.selectOne();
		test1.selectOne1("슈주");
		test1.selectList(8);
		test1.update(new Singer("zgroup",9));
		test1.delete("EH");
		test1.selectOne2("zgroup",9);
	}
}
