package sist.com.obj;

//increment, 중복검사, 삭제, 업데이트 , [Score]평균, 랭크
import java.util.Scanner;

public class StudentMain {

	private Scanner sc;
	private Student[] stdArr;
	private StudentScore[] stdSco;
	private Student s;

	private int index;

	// 기본생성자에서 new scanner , stdArr 크기를 받아서 만들 수 있음
	public StudentMain() {
		sc = new Scanner(System.in);
		System.out.println("Student Count : ");
		stdArr = new Student[sc.nextInt()]; // 객체배열 선언
		stdSco = new StudentScore[stdArr.length];

		System.out.println(stdArr.length + "명 까지 입력 가능");
	}

	public boolean isFull() {
		return index == stdArr.length - 1; // 객체배열의 상태가 full 인지 확인
	}

	public boolean isEmpty() {
		return index == 0;
	}

	public void increment() {
		Student[] tmp = new Student[stdArr.length * 2];
		System.arraycopy(stdArr, 0, tmp, 0, stdArr.length);
		stdArr = tmp;
	}

	public void inputStudent() { // 이 메소드를 부를 때 마다 s 객체가 생성
		if (isFull()) {
			increment();
		}
		s = new Student(new StudentScore());
		System.out.println("Name : ");
		s.setName(sc.next());
		System.out.println("Age : ");
		s.setAge(sc.nextInt());
		String id = null;
		do {
			System.out.println("StdId : ");
			id = sc.next();
		} while (idCheck(id)); // 먼저 id를 입력 받은 후에 있는지 없는지 확인
		s.setStdID(id);

		System.out.println("SchoolName : ");
		s.setSchoolName(sc.next());
		stdArr[index++] = s; // 배열 index 위치에 객체배열의 주소를 넣어둠
	}

	public void rankScore() { // 평균으로 랭크 확인
		for (int i = 0; i < index; i++) {
			stdArr[i].getScore().setRank(1);
			for (int j = i + 1; j < index; j++) {
				if (stdArr[i].getScore().getAvg() < stdArr[j].getScore().getAvg()) {
					stdArr[i].getScore().setRank(stdArr[i].getScore().getRank() + 1);
				}
			}
		}
	}

	public boolean idCheck(String id) {
		for (int i = 0; i < index; i++) {
			if (stdArr[i].getStdID().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public void stdList() {
		for (int i = 0; i < index; i++) {
			// 배열의 주소를 가져와서 get 하여 출력
			System.out.println("Name : " + stdArr[i].getName());
			System.out.println("Age : " + stdArr[i].getAge());
			System.out.println("StdId : " + stdArr[i].getStdID());
			System.out.println("SchoolName : " + stdArr[i].getSchoolName());
			System.out.println("Kor : " + stdArr[i].getScore().getKor());
			System.out.println("Eng : " + stdArr[i].getScore().getEng());
			System.out.println("Math : " + stdArr[i].getScore().getMath());
		}
	}

	public void stdInfo() {
		System.out.println("StdID : ");
		int idx = search(sc.next());
		if (idx == -1) {
			return;
		}
		System.out.println(stdArr[idx].toString());
	}

	public int search(String id) {
		for (int i = 0; i < stdArr.length; i++) {
			if (stdArr[i].getStdID().equals(id)) {
				return i;
			}
		}
		return -1;
	}

	public void sort(int order) {	// 정렬 기준값을 정해서 그 정렬 대로 전체값들을 정렬하는 집단처리
		Student temp;
		for (int i = 0; i < index - 1; i++) {
			for (int j = i + 1; j < index; j++) {
				if (order == 1) { // 내림차순
					if (stdArr[i].getAge() < stdArr[j].getAge()) {
						temp = stdArr[i];
						stdArr[i] = stdArr[j];
						stdArr[j] = temp;
					}
				} else { // 오름차순
					if (stdArr[i].getAge() > stdArr[j].getAge()) {
						temp = stdArr[i];
						stdArr[i] = stdArr[j];
						stdArr[j] = temp;
					}
				}
			}
		}
	}

	public void update() {
		System.out.println("수정할 ID : ");
		int indx = search(sc.next());
		System.out.println("수정 후 ID : ");
		stdArr[indx].setStdID(sc.next());
	}

	public void delete() {
		System.out.println("Delete ID : ");
		int ix = search(sc.next());
		if (ix == -1) {
			return;
		}
		for (int i = ix; i < index; i++) {
			if (i == index - 1) {
				stdArr[i] = null;
				break;
			}
			stdArr[i] = stdArr[i + 1];
		}
		index--;
	}

	public void avg() {

	}

	public void rank() {

	}

	public void scoreAdd() {
		if (isEmpty()) {
			System.out.println(-1);
			return;
		}
		for (int i = 0; i < index; i++) {
			System.out.println(stdArr[i].getName());
			// 과목 수 3
			System.out.println("Kor : ");
			s.getScore().setKor(sc.nextInt());
			//stdArr[i].getScore().setKor(s);
			System.out.println("Eng : ");
			s.getScore().setEng(sc.nextInt());
			System.out.println("Math : ");
			s.getScore().setMath(sc.nextInt());
			stdArr[i] = s;
		}
	}

	public void menu() {
		while (true) {
			System.out.println(
					"1.Std Add  2.Std Info  3.Std List  4.Std Delete  5.Std Update  6.Score AVG   7.Score Add");
			switch (sc.nextInt()) {
			case 1:
				inputStudent();
				break;
			case 2:
				stdInfo();
				break;
			case 3:
				stdList();
				break;
			case 4:
				delete();
				break;
			case 5:
				update();
				break;
			case 6:
				avg();
				break;
			case 7:
				scoreAdd();
				break;
			default:
				rank();
				break;
			}
		}
	}

	public static void main(String[] args) {
		StudentMain st = new StudentMain();
		st.menu();
	}
}

// 강사님 코드
//package sist.com.basic.obj;
//
//import java.util.Scanner;
//
///*private String name;
//private int age;
//private String stdID;
//private String schoolName;
//*/
//public class StudentMain {
//   private Scanner scanner;
//   private Student []studArray;
//   private int index;
//   public StudentMain() {
//      scanner=new Scanner(System.in);
//      System.out.println("StudentCount:");
//      studArray=new Student[scanner.nextInt()];
//      System.out.println(studArray.length+"명 입력가능");
//   }
//   public boolean isFull() {
//      return index==studArray.length-1;
//   }
//   public boolean isEmpty() {
//      return index==0;
//   }
//   public void increment() {
//      Student []imsi=new Student[studArray.length*2];
//      System.arraycopy(studArray, 0, imsi, 0, studArray.length);
//      studArray=imsi;
//   }
//   
//   public void inputStudent() {
//      if(isFull()) {
//         increment();
//      }
//      Student s=new Student(new Score());
//      System.out.println("Name:");
//      s.setName(scanner.next());
//      System.out.println("Age:");
//      s.setAge(scanner.nextInt());
//      String id=null;
//      do {
//      System.out.println("StdId:");
//      id=scanner.next();      
//      }while(idCheck(id));
//      s.setStdID(id);      
//      System.out.println("SchoolName:");
//      s.setSchoolName(scanner.next());
//      System.out.print("Kor");
//      s.getScore().setKor(scanner.nextInt());
//      
//      System.out.print("Eng");
//      s.getScore().setEng(scanner.nextInt());
//      
//      
//      System.out.print("Mat");
//      s.getScore().setMat(scanner.nextInt());
//      s.getScore().averageProcess();
//      scoreRank();
//      studArray[index++]=s;
//   }
//   public void scoreRank() {
//      for (int i = 0; i < studArray.length; i++) {
//         studArray[i].getScore().setRank(1);
//         for (int j = 0; j < studArray.length; j++) {
//            if(studArray[i].getScore().getAvg() <studArray[j].getScore().getAvg()) {
//               studArray[i].getScore().setRank(studArray[i].getScore().getRank()+1);
//            }
//         }
//      }
//   }
//   public boolean idCheck(String id) {
//      for(int i=0;i<index;i++) {
//         if(studArray[i].getStdID().equals(id))return true;
//      }
//      return false;
//   }
//   public void studList() {
//      System.out.println("1. Age Desc 2.Age Asc");
//      sort(scanner.nextInt());
//      System.out.printf("%7s%7s%7s%10s%10s%10s\n","Name","Age","Sid","ScName","Avg","Rank");
//      for (int i = 0; i <index; i++) {
//         System.out.printf("%7s%7d%7s%10s%10.2f%10d\n",studArray[i].getName(),studArray[i].getAge(),studArray[i].getStdID(),studArray[i].getSchoolName(),studArray[i].getScore().getAvg(),studArray[i].getScore().getRank());
//         
//      }
//   }
//   public int search(String id) {
//      for (int i = 0; i < studArray.length; i++) {
//         if(studArray[i].getStdID().equals(id))return i;
//      }
//      return -1;
//   }
//   public void studentInfo() {
//      System.out.println("StudID:");
//      int index=search(scanner.next());
//      if(index==-1)return;
//      System.out.println(studArray[index].toString());
//   }
//   public void menu() {
//      while(true) {
//      System.out.println("1.StudAdd 2.StudInfo 3.StudList 4.StudDelete 5.StudUpdate");
//      switch (scanner.nextInt()) {
//      case 1:
//         inputStudent();
//         break;
//      case 2:
//         studentInfo();
//         break;
//      case 3:
//         studList();
//         break;
//      case 4:
//         deleteStudent();
//         break;
//      default:
//         break;
//         }
//      }
//   }
//   public void deleteStudent() {
//      System.out.println("SearchID:");
//      int ix=search(scanner.next());
//      if(ix==-1)return;
//      for (int i = ix; i < index; i++) {
//         if(i==index-1) {
//            studArray[i]=null;
//            break;
//         }
//         studArray[i]=studArray[i+1];
//      }
//      index--;
//   }
//   
//   public void swap(int i,int j) {
//      Student imsi;
//      imsi=studArray[i];
//      studArray[i]=studArray[j];
//      studArray[j]=imsi;
//   }
//   public void sort(int order) {
//      
//      for (int i = 0; i < index-1; i++) {
//         for (int j = i+1; j < index; j++) {
//            if(order==1) {
//               if(studArray[i].getAge() <studArray[j].getAge()) {
//                  swap(i,j); 
//               }
//            }else {
//               if(studArray[i].getAge() >studArray[j].getAge()) {
//                  swap(i,j); 
//               }
//            }
//         }
//      }      
//   }
//   public static void main(String[] args) {
//      StudentMain s=new StudentMain();
//      s.menu();
//      
//   }
//
//}
