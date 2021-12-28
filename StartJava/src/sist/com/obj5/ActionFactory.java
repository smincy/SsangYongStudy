package sist.com.obj5;

public class ActionFactory {
	// Action�� ��ɿ� ���� �����ϴ� Ŭ����

	// �̱���
	private static final ActionFactory ACTION_FACTORY;
	static {
		ACTION_FACTORY = new ActionFactory();
	}

	public static ActionFactory getInstance() {
		return ACTION_FACTORY;
	}

	public Action getAction(String command) {
		if (command.equals("login")) {
			return new LoginAction(new MySqlDao(), "loginView", true);
		} else if (command.equals("delete")) {
			return new DeleteAction(new MsSqlDao(), "deleteView", false);
		} else if (command.equals("update")) {
			return new UpdateAction(new OracleDao(), "updateView", false);
		} else if (command.equals("info")) {
			return new InfoAction(new MySqlDao(), "infoView", true);
		}
		return null;
	}
}
