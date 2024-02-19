
public class Student {
	private String name;
	private String id;
	private String sex;
	
	public Student(String id,String name,String sex) {
		this.name = name;
		this.id = id;
		this.sex = sex;
	}
	
	public Student createCopy() {
		return new Student(this.id,this.name,this.sex);
	}
	public String toString() {
		return "["+id+","+name+ ", " + sex + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
