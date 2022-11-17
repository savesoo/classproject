package org.example.di.service;

import java.util.Date;

import org.example.di.dao.Dao;
import org.example.di.domain.Member;
import org.example.di.domain.RegisterRequest;
import org.example.di.exception.AlreadyExistingMemberException;
import org.springframework.stereotype.Service;

@Service
public class MemberRegisterService {

	//@Autowired(required = true) // 같은 타입 찾아 자동 주입. 기본값은 ture
	//@Qualifier("member") // 사용할 객체 선택
	private final Dao dao; // final -> 무조건 생성자 생성

	public MemberRegisterService(Dao dao) {
		this.dao = dao;
	}

//	public MemberRegisterService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
//
//	public void  setMemberDao(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}

	public void regist(RegisterRequest req) throws AlreadyExistingMemberException {

		Member member = dao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		dao.insert(newMember);
	}

}
