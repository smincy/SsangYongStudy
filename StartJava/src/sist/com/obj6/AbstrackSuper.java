package sist.com.obj6;

// �߻�Ŭ����
public abstract class AbstrackSuper {
	// �߻�Ŭ������ ��ü�� ������ �� ����
	// Ȯ���� �������� ��������� Ŭ���� = �߻�Ŭ����
	// �����ڴ� ����

	private int abstractSuper;

	public AbstrackSuper() {

	}

	public AbstrackSuper(int superValue) {
		// Ȯ���� �������� ������� Ŭ���� �̹Ƿ� �ļտ��� Ÿ�� ���� ��츦 ���� ������ ����
		super();
		this.abstractSuper = superValue;
	}

	public abstract void abstrackSuperMethod();
	// �߻�Ŭ�������� final �� �� �� ����

	public void superinstanceMethod() {
		// �Ϲ� �޼ҵ� >> �������̵� ����
	}

	@Override
	public String toString() {
		return "AbstrackSuper [abstractSuper=" + abstractSuper + "]";
	}

}
