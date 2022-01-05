package sist.com.dao;

//�������� 
/*
*   ��ü���� ���α׷� : ���� 
*   ���� => ������ �ִ� ��� , �߰� , ���� , ������ ����
*   ============================================
*   ��ü������ 3�� ��� 
*   ���� : *���(����,�߰�)=> is-a , *����(���� ������ ���� ���) => has-a
*   class A
*   {
*   }
*   class B extends A
*   {
*      AŬ������ Ȯ���ؼ� ���ο� Ŭ������ ���� ���
*      =====================================
*      1. �߰� (�����ε�)
*      2. A�� �����ؼ� ��� (�������̵�)
*      
*      => ***�����ε� / �������̵� => ������ (��� ����=100%)
*             new      modify
*   } 
*   
*   class A
*   {
*   }
*   class B
*   {
*       A a=new A(); ==> ���� Ŭ���� ==> �������̵��� �����ϴ� 
*       A a=new A(){
*          AŬ������ ������ �ִ� �޼ҵ� ������(�������̵�)
*          �߰� 
*       };
*       ==> ����� ���� �������̵� ==> �͸��� Ŭ���� 
*   }
*   
*   ������ ���� : �������� ���� ����ǰų� ������ �����ϱ� ���ؼ� 
*              => �����͸� ���߰� �ܺ� �޼ҵ带 ���ؼ� ������ �����ϰ� ����� ��� 
*              => ===========     =====================
*                    ����ȭ             ĸ��ȭ 
*              => ����ȭ => ������� : private , �޼ҵ� : public 
*   ====== ��ü������ ���� ���� : �������� 
*          ��) ���� => 8����~1��  ==> SI 
*             �������� => 5~15�� ==> SM
*      ���� => �迭 => ����ü => Ŭ���� (�������� + �޼ҵ�)
*      ===   =====   =====
*      �Ѱ��� ����  |     => �ٸ� �������� ��Ƽ� �Ѱ��� �̸����� ���� (X)
*                      
*               �����͸� ��Ƽ� �Ѱ��� �̸����� �������� ������ ���� 
*                => ������ , ���� ���������� ��Ƽ� ���� 
*   1) Ŭ���� 
*      = ����� ���� �������� (�����͸� ������ ��� �ѹ��� ����) => ������ ���� 
*        = �ٸ� ���������� ���� �� �ִ� 
*      = ���� + �޼ҵ� : �׼�Ŭ���� 
*      
*      Ŭ������ ���� ��� 
*      ==============
*      Ŭ������ {
*         =====================================
*          ������ ���� (�������) => ������ ���� �� �ִ�
*            => �ν��Ͻ�����  ===> new�� ��������� ��ü���� ���� ����Ǵ� ����
*            => ��������(��������)==> �����Ͻ� �Ѱ� �޸𸮸� ����� ����
*               static ==> �౸�� , �߱���   
*         =====================================
*           �ʱ�ȭ(����) => �ʱ�ȭ��� / ������ 
*         =====================================
*          ����Ȱ�� �ϴ� ��� => �޼ҵ� 
*         =====================================
*      }
*      =====> �ʿ�ø��� ���� ==> ��� , ���� 
*/
//��������(VO,DTO) , �޼ҵ��̿��ؼ� ���� => ����Ŭ , �� 
/*
*   NO         NUMBER      ==> int   
	TITLE      VARCHAR2(500)  ==> String
	POSTER     VARCHAR2(260)  
	CONTENT    VARCHAR2(4000) 
	AUTHOR     VARCHAR2(50)   
	PRICE      VARCHAR2(20)   
	REGDATE    VARCHAR2(30)   
	ISBN       VARCHAR2(20)   
	TAGS       VARCHAR2(4000) 
	
	int a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p
	int[] arr=new int[16]
	
	Books b=new Books() => ���õ� ������ 
	
*/
//å �ѱǿ� ���� ������ ���� ==> Ŭ���� (�Ѱ�,�Ѹ�)
//ĸ��ȭ ==> ��ť���ڵ� 
public class Books {
	private int no;
	private String title;
	private String poster;
	private String content;
	private String author;
	private String price;
	private String regdate;
	private String isbn;
	private String tags;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}
