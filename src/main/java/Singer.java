
public class Singer {
	private String name;
	private int member;
	
	public Singer() {
		
	}
	public Singer(String name, int member)
	{
		this.name=name;
		this.member=member;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMember() {
		return member;
	}
	public void setMember(int member) {
		this.member = member;
	}
}
