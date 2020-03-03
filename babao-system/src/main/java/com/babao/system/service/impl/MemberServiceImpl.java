package com.babao.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babao.common.croe.text.Convert;
import com.babao.common.enums.StatusEnum;
import com.babao.system.domain.Member;
import com.babao.system.mapper.MemberMapper;
import com.babao.system.service.MemberService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public Member selectMemberByAccount(String account) {
		Member member = memberMapper.selectMemberByAccount(account);
		if(null == member) {
			log.error("查询member参数错误");
			return null;
		}
		log.info("查询返回member状态："+member.getStatusEnum().toString());
		return member;
	}

	@Override
	public int addMember(Member member) {
		int i = memberMapper.insertMember(member);
		if(i > 0) {
			log.info("插入成功");
		}else {
			log.error("插入失败");
		}
		return i;
	}

	@Override
	public int changeStatus(Member member) {
		int row = memberMapper.updateMember(member);
		if(row > 0) {
			log.info("修改用户状态"+member.getStatusEnum().toString());
		}
		return row;
	}

	@Override
	public Member selectMemberById(Integer memberId) {
		
		return memberMapper.selectMemberById(memberId);
	}

	@Override
	public int UpdatePassword(Member member) {
		int row = memberMapper.updateMember(member);
		if(row > 0) {
			log.info("修改状态成功");
		}
		return row;
	}
	
	 public List<Member> selectMemberList(Member member){
		return memberMapper.selectMemberList(member);
		 
	 }

	@Override
	public int deleteMemberByIds(String memberId) {
		Integer[] ids = Convert.toIntArray(memberId);
		int row = memberMapper.deleteMemberByIds(ids);
		if(row > 0) {
			log.info("删除成功");
		}
		return row;
	}
}
