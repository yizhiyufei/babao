//package com.babao.freamewoke.shiro.session.mgt.eis;
//
//import java.io.Serializable;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.babao.system.service.OnlineService;
//
///**
// * 在线会话DB存储
// * @author yizhiyufei
// *
// */
//public class OnlineSessionDAO extends EnterpriseCacheSessionDAO{
//
//	@Autowired
//	OnlineService onlineService;
//
//	@Override
//	protected Serializable doCreate(Session session) {
//		Serializable sessionId = generateSessionId(session);
//		assignSessionId(session, sessionId);
//		return super.doCreate(session);
//	}
//	@Override
//	protected void doUpdate(Session session) {
//		// TODO Auto-generated method stub
//		super.doUpdate(session);
//	}
//	@Override
//	protected void doDelete(Session session) {
//		// TODO Auto-generated method stub
//		super.doDelete(session);
//	}
//	@Override
//	protected Session doReadSession(Serializable sessionId) {
//		// TODO Auto-generated method stub
//		return super.doReadSession(sessionId);
//	}
//}
