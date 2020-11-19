package com.babao.system.mapper;

import com.babao.system.domain.pojo.Account;
import org.apache.ibatis.annotations.Insert;
import java.util.List;


/**
 * 成员信息数据层
 * @author yizhiyufei
 *
 */
public interface AccountMapper {
	public Account selectAccountByAccount(String memberAccount);

	@Insert({"INSERT INTO member(member_account,member_name,PASSWORD,salt) "
			+ "VALUE(#{memberAccount},#{memberName},#{password},#{salt})"})
	public int insertAccount(Account member);

	public int updateAccount(Account member);

	public Account selectAccountById(Integer memberId);

	public List<Account> selectAccountList(Account member);

	public int deleteAccountByIds(Integer[] memberIds);
}
