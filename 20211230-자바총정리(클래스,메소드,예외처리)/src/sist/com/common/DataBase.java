package sist.com.common;

/*
 *   1.��Ű�Ͻ� 
 *   2.�����÷���Ʈ (����)
 *   3.���� ���� (��� , �ڿ� , ȣ��)
 *   4.��ȭ => ����,���̹� => ����
 *   5.���� => ���� / ��� / MNET  
 *   ========================== ����Ŭ (SQL) , JSP => ȭ�� 
 *   
 *   => 1. ����Ŭ�� ������ ÷��
 *   => 2. ������ �б�
 *   => 3. �󼼺��� 
 */
import java.util.*;

public interface DataBase {
	public void dbInsert(Object obj) throws Exception;

	// Ŭ������ ���� => Object => ����ȯ
}