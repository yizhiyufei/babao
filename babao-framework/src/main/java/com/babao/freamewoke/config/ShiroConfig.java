//package com.babao.freamewoke.config;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import org.apache.shiro.mgt.SecurityManager;
//import javax.servlet.Filter;
//import org.apache.shiro.cache.ehcache.EhCacheManager;
//import org.apache.shiro.codec.Base64;
//import org.apache.shiro.session.SessionListener;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.CookieRememberMeManager;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.servlet.Cookie;
//import org.apache.shiro.web.servlet.SimpleCookie;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.babao.common.utils.StringUtils;
//import com.babao.freamewoke.shiro.authc.credential.PasswordMatcher;
//import com.babao.freamewoke.shiro.realm.MemberRealm;
//import com.babao.freamewoke.shiro.session.StartSessionListener;
//import com.babao.freamewoke.shiro.session.mgt.OnlineSessionFactory;
//import com.babao.freamewoke.shiro.web.filter.KickoutSessionControlFilter;
//
//import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
//import net.sf.ehcache.CacheManager;
//
///**
// * 权限配置加载
// *
// * @author yizhiyufei
// */
//@Configuration
//public class ShiroConfig {
//	public static final String PREMISSION_STRING = "perms[\"{0}\"]";
//
//	// 登录地址
//	private String loginUrl = "/login";
//
//	/**
//	 * 自定义Realm
//	 */
//	@Bean
//	public MemberRealm memberRealm(PasswordMatcher passwordMatcher) {
//		MemberRealm userRealm = new MemberRealm();
//		userRealm.setCredentialsMatcher(passwordMatcher);
//		return userRealm;
//	}
//
//	/**
//	 * 密码匹配器
//	 * @return
//	 */
//	@Bean
//	public PasswordMatcher passwordMatcher() {
//		PasswordMatcher passwordMatcher = new PasswordMatcher();
//		passwordMatcher.setHashAlgorithmName("md5");
//		passwordMatcher.setHashIterations(2);
//		return passwordMatcher;
//	}
//
//	/**
//	 * 自定义会话工厂
//	 * @return
//	 */
//	@Bean
//	public OnlineSessionFactory onlineSessionFactory()
//	{
//		OnlineSessionFactory onlineSessionFactory = new OnlineSessionFactory();
//		return onlineSessionFactory;
//	}
//	/**
//     * cookie 属性设置
//     */
//	@Bean
//    public SimpleCookie simpleCookie()
//    {
//        SimpleCookie cookie = new SimpleCookie("rememberMe");
//        cookie.setDomain("");
//        cookie.setPath("/");
//        cookie.setHttpOnly(true);
//        cookie.setMaxAge(60 * 60);
//        return cookie;
//    }
//
//    /**
//     * 记住我管理器
//     */
//    @Bean
//    public CookieRememberMeManager cookieRememberMeManager(SimpleCookie simpleCookie)
//    {
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        cookieRememberMeManager.setCookie(simpleCookie);
//        cookieRememberMeManager.setCipherKey(Base64.decode("fCq+/xW488hMTCD+cmJ3aQ=="));
//        return cookieRememberMeManager;
//    }
//	/**
//	 * 会话管理器
//	 */
//	@Bean
//	@Qualifier("webSessionManager")
//	public DefaultWebSessionManager defaultWebSessionManager(OnlineSessionFactory sessionFactory,SimpleCookie simpleCookie)
//	{
//		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//		// 删除过期的session
//		sessionManager.setDeleteInvalidSessions(true);
//        // 设置全局session超时时间
//		sessionManager.setGlobalSessionTimeout(1800000);
//		// 去掉 JSESSIONID
//		sessionManager.setSessionIdUrlRewritingEnabled(false);
//		sessionManager.setSessionIdCookieEnabled(true);
//		sessionManager.getSessionIdCookie().setName("sid");
//		sessionManager.setSessionFactory(sessionFactory);
//		//加入监听器
//		List<SessionListener> list = new ArrayList<SessionListener>();
//		list.add(new StartSessionListener());
//		sessionManager.setSessionListeners(list);
//		return sessionManager;
//	}
//
//	/**
//	 * 安全管理器
//	 */
//	@Bean
//	public SecurityManager securityManager(MemberRealm memberRealm , DefaultWebSessionManager sessionManager,
//			CookieRememberMeManager rememberMeManager,EhCacheManager ehCacheManager) {
//		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//		// 设置realm.
//		securityManager.setRealm(memberRealm);
//		securityManager.setSessionManager(sessionManager);
//		securityManager.setRememberMeManager(rememberMeManager);
//		securityManager.setCacheManager(ehCacheManager);
//		return securityManager;
//	}
//
//	/**
//	 * 缓存管理器 使用Ehcache实现
//	 */
//	@Bean
//	public EhCacheManager getEhCacheManager(CacheManager cacheManager) {
//		EhCacheManager em = new EhCacheManager();
//        //将CacheManager转换成shiro包装后的ehcacheManager对象
//		em.setCacheManager(cacheManager);
//		return em;
//	}
//
//	/**
//	 * Shiro过滤器配置
//	 */
//	@Bean
//	public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager,KickoutSessionControlFilter kickout) {
//		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//		// Shiro的核心安全接口,这个属性是必须的
//		shiroFilterFactoryBean.setSecurityManager(securityManager);
//		// 身份认证失败，则跳转到登录页面的配置
//		shiroFilterFactoryBean.setLoginUrl(loginUrl);
//
//		//自定义过滤器
//		Map<String, Filter> filters = new LinkedHashMap<String, Filter>();
//		filters.put("kickout", kickout);
//		shiroFilterFactoryBean.setFilters(filters);
//
//		// Shiro连接约束配置，即过滤链的定义
//		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//
//		// 对静态资源设置匿名访问
//		filterChainDefinitionMap.put("/favicon.ico**", "anon");
//		filterChainDefinitionMap.put("/ruoyi.png**", "anon");
//		filterChainDefinitionMap.put("/css/**", "anon");
//		filterChainDefinitionMap.put("/docs/**", "anon");
//		filterChainDefinitionMap.put("/fonts/**", "anon");
//		filterChainDefinitionMap.put("/img/**", "anon");
//		filterChainDefinitionMap.put("/ajax/**", "anon");
//		filterChainDefinitionMap.put("/js/**", "anon");
//		filterChainDefinitionMap.put("/ruoyi/**", "anon");
//
//		// 退出 logout地址，shiro去清除session
//        filterChainDefinitionMap.put("/logout", "logout");
//
//		// 匿名访问(不需要登陆)
//		filterChainDefinitionMap.put("/system/user/add", "anon");
//		filterChainDefinitionMap.put("/login", "anon");
//		filterChainDefinitionMap.put("/register", "anon");
//
//		// 所有请求需要过滤
//		filterChainDefinitionMap.put("/**", "kickout,user");
//
//		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//		return shiroFilterFactoryBean;
//	}
//
//	/**
//	 * 踢出拦截器
//	 */
//	@Bean
//	public KickoutSessionControlFilter sessionControlFilter() {
//		KickoutSessionControlFilter sessionControlFilter = new KickoutSessionControlFilter();
//		sessionControlFilter.setLoginUrl(loginUrl);
//		sessionControlFilter.setKickoutUrl(loginUrl);
//		return sessionControlFilter;
//	}
//
//	/**
//	 * thymeleaf模板引擎和shiro框架的整合
//	 */
//	@Bean
//	public ShiroDialect shiroDialect() {
//		return new ShiroDialect();
//	}
//
//	/**
//	 * 开启Shiro注解通知器
//	 */
//	@Bean
//	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
//			@Qualifier("securityManager") SecurityManager securityManager) {
//		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//		return authorizationAttributeSourceAdvisor;
//	}
//}
