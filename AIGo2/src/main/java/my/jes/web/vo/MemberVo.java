package my.jes.web.vo;

import my.jes.web.util.MyException;

public class MemberVo {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String gender;
	private int age;
	private float weight;
	private float height;

	public MemberVo(String id, String pw, String name, String email, int age, float weight, float height, String gender)
			throws MyException {
		this(id, pw);
		setName(name);
		setEmail(email);
		setAge(age);
		setWeight(weight);
		setHeight(height);
		setGender(gender);
	}

	public MemberVo(String id, String pw) throws MyException {
		super();
		setId(id);
		setPw(pw);
	}

	public MemberVo(int age, float weight, float height) {
		super();
	}

	public MemberVo() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) throws MyException {
		if (id != null) {
			this.id = id;
		} else {
			throw new MyException("id가 입력되지 않았습니다");
		}
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) throws MyException {
		if (pw != null) {
			this.pw = pw;
		} else {
			throw new MyException("pw가 입력되지 않았습니다");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws MyException {
		if (name != null) {
			this.name = name;
		} else {
			throw new MyException("name가 입력되지 않았습니다");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws MyException {
		if (email != null) {
			this.email = email;
		} else {
			throw new MyException("email가 입력되지 않았습니다");
		}
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) throws MyException {
		if (gender != null) {
			this.gender = gender;
		} else {
			throw new MyException("gender가 입력되지 않았습니다");
		}
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) throws MyException {
		if (age > 0) {
			this.age = age;
		} else {
			throw new MyException("올바른 나이를 입력해주세요");
		}
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) throws MyException {
		if (weight > 0) {
			this.weight = weight;
		} else {
			throw new MyException("올바른 몸무게를 입력해주세요");
		}
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) throws MyException {
		if (height > 0) {
			this.height = height;
		} else {
			throw new MyException("올바른 키를 입력해주세요");
		}
	}

	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", gender=" + gender
				+ ", age=" + age + ", weight=" + weight + ", height=" + height + "]";
	}

}
