package my.jes.web.vo;

import my.jes.web.util.MyException;

public class ContactVO {

	private String name;
	private String email;
	private String comment;

	public ContactVO(String name, String email, String comment) {
		super();
		this.name = name;
		this.email = email;
		this.comment = comment;
	}

	public ContactVO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws MyException {
		if (name != null) {
			this.name = name;
		} else {
			throw new MyException("이름을 입력해주세요.");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws MyException {
		if (email != null) {
			this.email = email;
		} else {
			throw new MyException("이메일을 입력해주세요.");
		}
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) throws MyException {
		if (comment != null) {
			this.comment = comment;
		} else {
			throw new MyException("내용이 입력되지않았습니다.");
		}
	}

	@Override
	public String toString() {
		return "ContactVO [name=" + name + ", email=" + email + ", comment=" + comment + "]";
	}

}
