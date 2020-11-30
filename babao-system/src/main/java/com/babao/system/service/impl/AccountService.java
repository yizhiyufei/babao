package com.babao.system.service.impl;

import com.babao.common.croe.text.Convert;
import com.babao.freamewoke.shiro.accout.pojo.Account;
import com.babao.freamewoke.shiro.accout.mapper.AccountMapper;
import com.babao.system.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class AccountService {
	@Autowired
	private AccountMapper AccountMapper;

	public Account selectAccountByAccount(String account) {
		Account Account = AccountMapper.selectAccountByAccount(account);
		if(null == Account) {
			log.error("查询Account参数错误");
			return null;
		}
		log.info("查询返回Account状态："+Account.getStatusEnum().toString());
		return Account;
	}

	public int addAccount(Account Account) {
		int i = AccountMapper.insertAccount(Account);
		if(i > 0) {
			log.info("插入成功");
		}else {
			log.error("插入失败");
		}
		return i;
	}

	public int changeStatus(Account Account) {
		int row = AccountMapper.updateAccount(Account);
		if(row > 0) {
			log.info("修改用户状态"+Account.getStatusEnum().toString());
		}
		return row;
	}

	public Account selectAccountById(Integer AccountId) {

		return AccountMapper.selectAccountById(AccountId);
	}

	public int UpdatePassword(Account Account) {
		int row = AccountMapper.updateAccount(Account);
		if(row > 0) {
			log.info("修改状态成功");
		}
		return row;
	}

	 public List<Account> selectAccountList(Account Account){
		return AccountMapper.selectAccountList(Account);

	 }

	public int deleteAccountByIds(String AccountId) {
		Integer[] ids = Convert.toIntArray(AccountId);
		int row = AccountMapper.deleteAccountByIds(ids);
		if(row > 0) {
			log.info("删除成功");
		}
		return row;
	}
}
