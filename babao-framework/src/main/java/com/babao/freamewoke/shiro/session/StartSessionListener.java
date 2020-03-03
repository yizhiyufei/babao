package com.babao.freamewoke.shiro.session;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;
import org.springframework.beans.BeanUtils;

import com.babao.freamewoke.shiro.session.mgt.OnlineSession;
import com.babao.system.domain.Member;

public class StartSessionListener extends SessionListenerAdapter {
	@Override
	public void onStart(Session session) {
		OnlineSession onlineSession = (OnlineSession) session;
		System.out.println("浏览器名称"+onlineSession.getBrowser());
		
		
	}
	@Override
	public void onStop(Session session)
	{
		System.out.println("会话关闭：" + session.getId());
	}
}
