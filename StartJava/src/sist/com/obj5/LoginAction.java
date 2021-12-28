package sist.com.obj5;

public class LoginAction extends Action {

	private String path;
	private boolean redirect;
	private Dao dao;

	public LoginAction(Dao dao, String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
		this.dao = dao;
	}

	@Override
	// Action 클래스가 추상클래스 이므로 에러가 나지 않기 위해 오버라이드 해야 함
	public ActionForWard execute() {
		// TODO Auto-generated method stub
		System.out.println("LoginAction Process");
		dao.connectProcess();
		dao.select();
		return new ActionForWard(path, redirect);
	}

}
