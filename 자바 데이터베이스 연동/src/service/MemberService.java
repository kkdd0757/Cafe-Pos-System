package service;

import java.util.ArrayList;
import java.util.List;

import model.Member;
import repository.MemberRepository;

public class MemberService {
	final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public void save(Member mem) {
		memberRepository.join(mem);
	}
	
	public ArrayList<Member> getList() {
		return memberRepository.getList();
	}
	
	public Member getMember(int id) {
		return memberRepository.getMember(id);
	}

}
