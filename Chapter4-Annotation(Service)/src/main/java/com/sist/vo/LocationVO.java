package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

// ����� ���� ��������(���������� �޸� �Ҵ����� �ʴ´�)
//~VO , ~DTO => ����� ���� �������� (�޸��Ҵ� �ʿ�ø��� ���α׷��Ӱ� ���)
//Integer , Double , String (�����͸� ��Ƽ� �����ϴ� ����) => �Ѱ�,�Ѹ� 
@Getter
@Setter
public class LocationVO {
	private String title;
	private String address;
	private String msg;
	
}
