package cn.hms.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.Application;
import javax.servlet.http.HttpServletRequest;

import cn.hms.entity.Md5;
import cn.hms.entity.User;
import cn.hms.service.UserBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	ActionContext ac = ActionContext.getContext();
	Map<String, Object> session = ac.getSession();
	private String repwd;

	public String getRepwd() {
		return repwd;
	}

	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String parma;

	public String getParma() {
		return parma;
	}

	public void setParma(String parma) {
		this.parma = parma;
	}

	private UserBiz userBiz;
	private User user;
	private Md5 md5 = new Md5();
	private String flag;
	private int pageIndex;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Md5 getMd5() {
		return md5;
	}

	public void setMd5(Md5 md5) {
		this.md5 = md5;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	/**
	 * 登录5
	 * 
	 * @return
	 */
	public String login() {
		if (user.getUsername().equals("") || user.getPassword().equals("")) {
			return "input";
		} else {
			User users = this.userBiz.findUser(user.getUsername(),
					md5.md5(user.getPassword()));
			System.out.println(md5.md5(user.getPassword()) + "........");
			if (users != null) {
				ActionContext ac = ActionContext.getContext();
				Map<String, Object> session = ac.getSession();
				session.put("user", users);
				System.out.println(1111111111);
				return "success";
			} else {
				Map<String, Object> request = (Map<String, Object>) ac.get("request");
				request.put("error", "用户名或密码错误!");
				return "input";
			}

		}
	}

	/**
	 * 注册
	 */
	public String register() {
		if (user.getUsername().equals("") || user.getPassword().equals("")
				|| user.getName().equals("") || user.getPhone().equals("")
				|| user.getIdCard().equals("")) {
			return "error";
		} else {
			user.setPassword(md5.md5(user.getPassword()));
		//	System.out.println(user.getPassword());
			user.setRid(1);
			user.setUserId(2);
			// Date d = new Date();//创建Date对象
			// SimpleDateFormat sf = new
			// SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			// String f = sf.format(d);
			user.setRegtime(new Date());
			this.userBiz.register(user);
			return "register";
		}
	}

	/*
	 * 判断不能重复用户名
	 */
	public String getName() {
		User users = this.userBiz.findUserByUsername(user.getUsername());
		// System.out.println(1111);
		if (users != null) {
			flag = "true";
		} else {
			flag = "false";
		}
		return "success";
	}

	// 分页
	public String getUserList() {
		int pageindex = 1;
		if (this.pageIndex != 0) {
			pageindex = pageIndex;
		}
		int count = this.userBiz.findCount();
		int pageSize = 5;
		int pageCount = (count % pageSize == 0) ? (count / pageSize) : (count
				/ pageSize + 1);
		if (pageindex < 1) {
			pageindex = 1;
		} else if (pageindex > pageCount) {
			pageindex = pageCount;
		}
		List<User> userList = this.userBiz.findUserList(pageindex, pageSize);
		if (userList != null) {
			session.put("userList", userList);
			session.put("pageindex", pageindex);
			session.put("pageCount", pageCount);
			return "user";
		} else {
			return INPUT;
		}
	}

	// 模糊数据
	public String mohu() {
		int pageindexLike = 1;
		if (this.pageIndex != 0) {
			pageindexLike = pageIndex;
		}
		if (parma == null) {
			if (session.get("parma") != null) {
				parma = (String) session.get("parma");
			}
		}
		int countLike = this.userBiz.findCountByLike(parma);
		System.out.println(countLike + "///////");
		int pageSize = 1;
		if (parma == null || parma.equals("")) {
			pageSize = 5;
		} else {
			pageSize = 1;
		}
		int pageCountLike = (countLike % pageSize == 0) ? (countLike / pageSize)
				: (countLike / pageSize + 1);
		System.out.println(pageCountLike + "?????");
		if (pageindexLike < 1) {
			pageindexLike = 1;
		} else if (pageindexLike > pageCountLike) {
			pageindexLike = pageCountLike;
		}
		List<User> list = this.userBiz.findUserListByLike(parma, pageindexLike,
				pageSize);
		if (list != null) {
			int flag = 1;
			session.put("flag", flag);
			session.put("parma", parma);
			session.put("userlistLike", list);
			session.put("pageindex", pageindexLike);
			session.put("pageCount", pageCountLike);
			return "user";
		} else {
			return "input";
		}
	}

	// 通过ID查询数据
	public String getUserById() {
		if (id != 0) {
			User users = this.userBiz.findUserById(id);
			session.put("user", users);
		}
		return "user_2";
	}

	// 修改用户
	public String updateUser() {
		if (user != null) {
			this.userBiz.updateUser(user);
			getUserList();
		}
		return "user";
	}

	// 通过id和密码查询数据
	public String getUserPwd() {
		System.out.println(user.getPassword());
		User u = this.userBiz.selectUserByPwdandId(user.getId(),
				md5.md5(user.getPassword()));
		if (u != null) {
			flag = "true";
			System.out.println(flag + "1111111");
		} else {
			flag = "false";
		}
		return "success";
	}

	// 修改密码
	public String updatePwd() {
		System.out.println(user.getPassword() + "123456");
		System.out.println(user.getId() + "00000000000");
		if (repwd.equals(user.getPassword())) {
			User u = new User();
			u.setId(user.getId());
			u.setPassword(md5.md5(user.getPassword()));
			flag = "true";
			this.userBiz.updatePwd(u);
		} else {
			flag = "false";
		}
		return SUCCESS;
	}

	// 用户的假删除
	public String deleteUser() {
		if (id != 0) {
			this.userBiz.deleteUser(id);
			getUserList();
		}
		return "user";
	}

	// 清除session
	public String clear() {
		session.clear();
		System.out.println(session.isEmpty());
		return "input";
	}
}
