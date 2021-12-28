package sist.com.obj5;

public class DeleteAction extends Action {
	private String path;
	private boolean redirect;
	private Dao dao;

	public DeleteAction(Dao dao, String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
		this.dao = dao;
	}

	@Override
	public ActionForWard execute() {
		// TODO Auto-generated method stub
		System.out.println("Delete Action");
		dao.connectProcess();
		dao.select();
		return new ActionForWard(path, redirect);
	}

}
