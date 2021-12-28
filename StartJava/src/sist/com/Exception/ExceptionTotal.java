package sist.com.Exception;

/*
 *    ����ó�� : ������ ������ ���� 
 *      => ���� : ���α׷��� ����� �߻��� �� �ִ� ������ ���� ����� �ڵ� ���� 
 *                                        =============
 *      => ���� ������ ó�� : if������ ó�� ==> ó���� �Ұ����ϸ� ����ó���� �Ѵ�
 *    ����ó�� 
 *      => ���� ó�� : try~catch~finally
 *         (���ܸ� ��Ƽ� ����) => ���ܺ���(catch��)
 *         => catch�� ����ϴ� ���� 
 *      => ���� ó�� : throws (�޼ҵ� �ڿ� ����) => ������ ���� 
 *         (�ý��ۿ� �˷��� �ش�) => ����ȸ��
 *      => ���� �߻� : throw (���α׷��Ӱ� ���� �߻�) => �׽�Ʈ�� 
 *      => �������� �ʴ� ���� ó�� ���� (����� ���� ����ó��)
 *      
 *    1. ���� (��������)
 *            ��� Ŭ������ �ֻ��� Ŭ���� (����� ���� Ŭ����,���̺귯��)
 *                   Object
 *                     |
 *                  Throwable : Error,Exception
 *                     |
 *              ====================================
 *              |                                  |
 *            Error                            Exception
 *              OutOfMemory 
 *              (����,�ּҰ� ���� �� ���� ����)
 *              
 *                       Exception : ����ó���� �ֻ��� Ŭ����
 *                                   ���ܿ� ���� ������ ó���� �� �ִ� 
 *                           |
 *                      ==================
 *                      |                |
 *                    �����Ͽ���(javac)  ��Ÿ�� ����(java)
 *                    ======== ������   ======= ����������
 *                      => �ݵ�� ����ó���� �Ѵ�  => �ʿ�ÿ��� ����ó��
 *                      CheckException     UnCheckException
 *                         |
 *                       **���� ����� : ��θ� 
 *                         IOException
 *                       ��Ʈ��ũ : �����ּ� , URL
 *                         MalformedURLException
 *                       ������ : �浹 
 *                         InterruptedException
 *                       **����Ŭ : SQL (DML)
 *                         SQLException
 *                         
 *                       UnCheckException
 *                         RuntimeException 
 *                            |
 *                           �迭�� ���� �ʰ�
 *                           ArrayIndexOutOfBoundsException
 *                           ������ȯ ����
 *                           NumberFormatException (��)
 *                           �ּҰ��� ���� ��� 
 *                           NullPointerException 
 *                             null => ��ü�� �ּҰ� ���� ���� 
 *                             String s; ==> s=null
 *                             A a;  ==> a=null
 *                           0���� ���� ��� 
 *                           ArithmeticException
 *                           
 *                           ==> ����ڰ� ���� ������ �߻��ϴ� �κ� => 
 *                                ����ó���� �ϸ� ���� (��ȿ��)
 *                       
 *    2. ���� 
 *       try
 *       {
 *         ===================
 *          ���� ������ ������ �ҽ�
 *          => ������ �߻� 
 *             = ���α׷��� �Ǽ� 
 *             = ������� �Է°� 
 *         ===================
 *         ����Ǵ� ���ܰ� ���� ��� 
 *       }catch(����ó�� ����) ==> catch�� ������ ����� ���� 
 *       {
 *         =============================
 *          ������ ���Ḧ �����ϴ� ���α׷� �ҽ� 
 *          ���� Ȯ�� 
 *          ����=> ó������ �ٽ� ���ư��� ���� 
 *         =============================
 *       }
 *       finally => ������ ���� 
 *       {
 *          =========================
 *            �ݱ� 
 *            = ���� ����� 
 *            = ��Ʈ��ũ ���� => ���� ���� ���� 
 *            = ����Ŭ => ����Ŭ ���� ���� 
 *          =========================
 *       }
 *    
 *      
 *       *** catch ��� 
 *       ������ ���
 *       catch(IOException e){}
 *       catch(SQLException e){}
 *       catch(RuntimeException e)(} 
 *       �Ѱ� 
 *       catch(IOExeption | SQLException | RuntimeException e)
 *       �Ѱ� 
 *       catch(Exception e) => ���� ���� 
 *       
 *       *** catch�� ����ϴ� ������ ������ �ִ�
 *           ����Ŭ����(����� ������ Ŭ������ ���߿� ���)
 *       *** ��ü��뵵 ���� ������ �κ������� ��� �� �� �ִ� 
 *      
 */
import java.util.*;

public class ExceptionTotal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. ������ �ΰ��� �޾Ƽ� ������ => 0
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� �Է�:");
		int no1 = sc.nextInt();
		System.out.print("�ι�° ���� �Է�:");
		int no2 = sc.nextInt();
		try {
			System.out.printf("%d/%d=%d\n", no1, no2, no1 / no2);
		} catch (Exception e) {
			System.out.println("0���� ���� �� �����ϴ�!!");
		}
		/*
		 * if(no2==0) { System.out.println("0���� ���� �� �����ϴ�!!"); } else {
		 * System.out.printf("%d/%d=%d\n",no1,no2,no1/no2); }
		 */
	}

}