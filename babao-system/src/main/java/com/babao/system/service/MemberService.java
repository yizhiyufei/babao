package com.babao.system.service;

import com.babao.system.domain.pojo.Member;

import java.util.List;

/**
 * 成员信息 服务层
 * @author yizhiyufei
 *
 */
public interface MemberService {
	public Member selectMemberByAccount(String memberAccount);
	public int addMember(Member member);
	public int changeStatus(Member member);
	public Member selectMemberById(Integer memberId);
	public int UpdatePassword(Member member);
	public List<Member> selectMemberList(Member member);
	public int deleteMemberByIds(String memberId);
}
