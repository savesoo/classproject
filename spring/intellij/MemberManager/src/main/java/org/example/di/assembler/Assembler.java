package org.example.di.assembler;


import org.example.di.dao.MemberDao;
import org.example.di.service.ChangePasswordService;
import org.example.di.service.MemberRegisterService;

public class Assembler {

	// 스프림의 Assembler
	// 1. 객체 갖고 있다가 달라고 할 때 주는 역할
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;

	// 2. 필요한 객체 만들어서 메소드에 넣어주는 역할
	// 나중에 Dao가 바뀌어도 문제되지 않음!
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(null);
		pwdSvc = new ChangePasswordService();
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}

	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}

}
