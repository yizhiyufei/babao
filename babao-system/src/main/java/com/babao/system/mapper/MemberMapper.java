package com.babao.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.babao.system.domain.Member;

/**
 * 成员信息数据层
 * @author yizhiyufei
 *
 */
public interface MemberMapper {
	public Member selectMemberByAccount(String memberAccount);
	
	@Insert({"INSERT INTO member(member_account,member_name,PASSWORD,salt) "
			+ "VALUE(#{memberAccount},#{memberName},#{password},#{salt})"})
	public int insertMember(Member member);

	public int updateMember(Member member);

	public Member selectMemberById(Integer memberId);

	public List<Member> selectMemberList(Member member);

	public int deleteMemberByIds(Integer[] memberIds);
}
