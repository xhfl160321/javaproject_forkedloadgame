package javaproject_2016261021;

import java.util.Scanner;

//유저와 빵의 정보
class User {
	//빵의 디폴트 값은 10개
	int bread=10; 
	//빵을 뺏기는 갯수를 랜덤으로 돌림
	int random = (int)(Math.random()*10)+1;
	
	public void BreadNum(int bread, int random) {
		this.bread = bread;
		this.random = random;
	}
	
	//남은 빵의 갯수를 알리는 메소드
	void ChangeBread() {
		System.out.println("현재 남은 🍞빵의 갯수는 "+this.bread +"개 입니다.");
	}
	
	//스레드를 이용한 길 표시
	void Load() throws InterruptedException {
		for(int i=0; i<20; i++) {
			System.out.print("▷▶");
			Thread.sleep(300);
		}
		System.out.print("\n");
	}
}

//도착 인터페이스
interface arrival{
	//도착 알리는 메소드
	void show() throws InterruptedException; 
}

//User 클래스와 arrival 인터페이스를 상속받은 Game 클래스 - 게임이 실행되는 클래스
class Game extends User implements arrival {
	//길 선택을 입력 받는 변수
	int forked;
	
	Scanner scan = new Scanner(System.in);
	
	//User의 bread 필드를 상속받음
	public Game(int forked, int bread, int random) {
		super();  
		this.forked = forked;
	}
	
	//첫 번째 갈림길(나무숲/호숫가) 메소드
	public void step1() throws InterruptedException {  
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(" >> 첫 번째 갈림길 입니다. 어디로 갈까요?\n");
		System.out.println(" >> 1번. 나무가 울창한 숲 ");
		System.out.println(" >> 2번. 호숫가 ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print(">> ");
		this.forked = scan.nextInt();
		
		//유저가 첫 번째 갈림길에서 1번을 선택 했을 경우
		if(this.forked==1) {  
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println(" >> 1번. 나무가 울창한 숲으로 향합니다.");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
			Load();
			//1번의 두 번째 갈림길(메소드)로 이동
			step2_1();   
		}
		//유저가 첫 번째 갈림길에서 2번을 선택 했을 경우
		else if(this.forked==2) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println(" >> 2번. 호숫가로 향합니다.");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━┛\n");
			Load();
			//2번의 두 번째 갈림길(메소드)로 이동
			step2_2();  
		}
	}

	//첫 번째 갈림길에서 1번을 선택하고 두 번째 갈림길(나무숲에서) 메소드
	private void step2_1() throws InterruptedException {
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(" >> 두 번째 갈림길 입니다. 어디로 갈까요?\n");
		System.out.println(" >> 1번.새가 지저귀는 길");
		System.out.println(" >> 2번.개구리가 우는 길 ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print(">> ");
		
		this.forked = scan.nextInt();
		
		//유저가 두 번째 갈림길에서 1번을 선택 했을 경우
		if(this.forked==1) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println(" >> 1번. 새가 지저귀는 길로 향합니다.");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
			Load();
			
			//늑대를 만나는 이벤트
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("           !! 늑대가 나타났습니다");
			System.out.println("   !! 배고픈  늑대가  🍞빵을 훔쳐갔습니다.");
			System.out.println("                "+"[-"+this.random+"]");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
			System.out.println("┏ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ┓");
			System.out.println("  계속 하시겠습니까? 아니면 처음부터 다시 하시겠습니까?\n");
			System.out.println("   >> 계속");
			System.out.println("   >> 다시");
			System.out.println("┗ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ┛");
			
			System.out.print(">> ");
			String do_or_not = scan.next();
			System.out.println();
			//유저가 계속을 입력했을 경우
			if(do_or_not.contentEquals("계속")) {
				//빵의 갯수가 랜덤 수만큼 감소
				bread=bread-this.random;
				Load();
				//1번의 세 번째 갈림길(메소드)로 이동
				step3_1();
			}
			//유저가 다시를 입력했을 경우
			else if(do_or_not.contentEquals("다시")) {
				Load();
				//첫 단계로 돌아가기
				step1();
			}   
		}
		//유저가 두 번째 갈림길에서 2번을 선택 했을 경우
		else if(this.forked==2) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println(" >> 2번. 개구리가 우는 길로 향합니다.");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
			Load();
			//2번의 세 번째 갈림길(메소드)로 이동
			step3_2();   
		}
	}
	
	//첫 번째 갈림길에서 2번을 선택하고 두 번째 갈림길(호숫가>돌징검다리/흔들다리) 메소드
	private void step2_2() throws InterruptedException {
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(" >> 두 번째 갈림길 입니다. 어디로 갈까요?\n");
		System.out.println(" >> 1번.돌징검다리");
		System.out.println(" >> 2번.흔들다리");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print(">> ");
		this.forked = scan.nextInt();
		
		//유저가 두 번째 갈림길에서 1번을 선택 했을 경우
		if(this.forked==1) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println(" >> 1번. 돌징검다리를 건넙니다.");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
			Load();
			//1번의 마지막길(메소드)로 이동
			step3_3();   
		}
		//유저가 두 번째 갈림길에서 2번을 선택 했을 경우
		else if(this.forked==2) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println(" >> 2번. 흔들다리를 건넙니다.");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━┛\n");
			Load();
			//빵이 빠지는 이벤트
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("  !!이런!! 다리가 너무 흔들려서 그만 🍞빵을 물에 빠뜨렸습니다!");
			System.out.println("                     "+"[-"+this.random+"]");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
			System.out.println("┏ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ┓");
			System.out.println("  계속 하시겠습니까? 아니면 처음부터 다시 하시겠습니까?\n");
			System.out.println("   >> 계속");
			System.out.println("   >> 다시");
			System.out.println("┗ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ┛");
			System.out.print(">> ");
			String do_or_not = scan.next();
			System.out.println();
			//유저가 계속을 입력했을 경우
			if(do_or_not.contentEquals("계속")) {
				//빵의 갯수가 랜덤 수만큼 감소
				bread=bread-this.random;
				Load();
				//2번의 마지막길(메소드)로 이동
				step3_4();
			}
			//유저가 다시를 입력했을 경우
			else if(do_or_not.contentEquals("다시")) {
				Load();
				//첫 단계로 돌아가기
				step1();
			}
		}
	}
	
	//첫 번째 갈림길에서 1번을 선택하고 두 번째 갈림길에서 1번을 선택하고 세 번째 길(나무숲>새가 지저귀는 길>소나무 길) 메소드
	private void step3_1() throws InterruptedException {
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(" >> 세 번째 길은 갈림길이 없습니다!");
		System.out.println(" >> 소나무 숲길로 향합니다!");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
		//도착 메소드
		show();
	}
	
	//첫 번째 갈림길에서 1번을 선택하고 두 번째 갈김길에서 2번을 선택하고 세 번째 갈림길(나무숲>개구리가 우는 길>구름이 잘보이는 길/지름길) 메소드
	private void step3_2() throws InterruptedException {
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(" >> 세 번째 갈림길 입니다. 어디로 갈까요?\n");
		System.out.println(" >> 1번. 구름이 잘 보이는 길 ");
		System.out.println(" >> 2번. 지름길");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
		System.out.print(">> ");
		this.forked = scan.nextInt();
		
		
		//유저가 세 번째 갈림길에서 1번을 선택 했을 경우
		if(this.forked==1) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println(" >> 1번. 구름이 잘 보이는 길로 향합니다 .");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
			Load();
			
			//배고픈 여우 이벤트
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("   !! 배고픈 여우를 만났습니다. 빵을 나눠 줄까요\n?");
			System.out.println("   >> 네 ");
			System.out.println("   >> 아니요");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			
			System.out.print(">> ");
			String sharebread = scan.next();
			
			
			//빵을 나누어 줌
			if(sharebread.equals("네")) {
				System.out.println();
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.println("   !! 빵을 나눠 주었습니다");
				System.out.println("           [-4]");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━┛\n");
				//빵의 갯수가 줄어듦
				bread=bread-4;   
				show();
			}
			//빵을 나누어 주지 않음
			else if(sharebread.equals("아니요")){ 
				System.out.println();
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.println("  !! 빵을 나눠 주지 않아 화가 난 여우가 빵을 훔쳐갔습니다. ");
				System.out.println("                   "+"[-"+this.random+"]");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
				System.out.println("┏ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ┓");
				System.out.println("  계속 하시겠습니까? 아니면 처음부터 다시 하시겠습니까?\n");
				System.out.println("   >> 계속");
				System.out.println("   >> 다시");
				System.out.println("┗ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━ ┛");
				
				System.out.print(">> ");
				String do_or_not = scan.next();
				System.out.println();
				//유저가 계속을 입력했을 경우
				if(do_or_not.contentEquals("계속")) {
					//빵의 갯수가 랜덤 수 만큼 줄어듦
					bread=bread-this.random;
					//도착 메소드
					show();
				}
				//유저가 다시를 입력했을 경우
				else if(do_or_not.contentEquals("다시")) {
					Load();
					//첫 단계로 돌아가기
					step1();
				}
			}
		}
		//유저가 세 번째 갈림길에서 2번을 선택 했을 경우
		else if(this.forked==2) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println(" >> 2번. 지름길로 향합니다.");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━┛\n");
			//도착 메소드
			show();
		}
	}
	
	//첫 번째 갈림길에서 2번을 선택하고 두 번째 갈림길에서 1번을 선택하고 세 번째 갈림길(호숫가>돌징검다리>큰 느티나무가 있는 길/지름길) 메소드
	private void step3_3() throws InterruptedException {
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(" >> 세 번째 갈림길 입니다. 어디로 갈까요?\n");
		System.out.println(" >> 1번.큰 느티나무가 있는 길");
		System.out.println(" >> 2번.지름길 ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
		System.out.print(">> ");
		this.forked = scan.nextInt();
		
		
		//유저가 세 번째 갈림길에서 1번을 선택 했을 경우
		if(this.forked==1) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println(" >> 1번. 큰 느티나무로 향합니다.");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
			//도착 메소드
			show();
		}
		//유저가 세 번째 갈림길에서 2번을 선택 했을 경우
		else if(this.forked==2) {
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println(" >> 2번. 지름길로 향합니다.");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━┛\n");
			Load();
			
			//늑대를 만나는 이벤트
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("      !! 못된 늑대를 만났습니다.");   
			System.out.println("  !! 못된 늑대가 빵을 다 훔쳐갔습니다.");
			System.out.println("             [-10]");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
			//빵의 갯수가 줄어듦
			bread=bread-10;  
			//도착 메소드
			show();
		}
		
	}

	//첫 번째 갈림길에서 2번을 선택하고 두 번째 갈림길에서 2번을 선택하고 세 번째 갈림길(호숫가>흔들다리>장미꽃 길) 메소드
	private void step3_4() throws InterruptedException {
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println(" >> 세 번째 길은 갈림길이 없습니다!");
		System.out.println(" >> 장미꽃 길로 향합니다!");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
		//도착 메소드
		show();
		
	}

	//도착을 알리는 메소드 구현
	@Override
	public void show() throws InterruptedException {
		Load();
		System.out.println();
		System.out.println("                     oo");
		System.out.println("                  _o");
		System.out.println("          *******| |");
		System.out.println("        ********** |");
		System.out.println("      *************");
		System.out.println("    *****************");
		System.out.println("  *********************     §≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈§ ");
		System.out.println("     |  ■■      ┏━┓ |       § 🏡👵할머니 댁에 도착했습니다!  §");
		System.out.println("     |  ■■      ┃ ┃ |       §≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈§");
		System.out.print("  w  |==========┗━┛=|        ");ChangeBread();//남은 빵의 갯수를 출력
		System.out.println("       w      w/ / w        §≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈§");
		System.out.println("  w       w   / /       w");
		System.out.println();

		//다시 플레이 하는 코드
		System.out.println("\n");
		System.out.println("┏ ━ ━ ━ ━ ━ ━ ━ ━━ ━ ━ ━ ┓");
		System.out.println("  >> 다시 도전 하시겠습니까??\n");
		System.out.println("  >> 1. 네! 다른 길도 볼래요.");
		System.out.println("  >> 2. 아니요, 그만 할래요.");
		System.out.println("┗ ━ ━ ━ ━ ━ ━ ━ ━ ━ ━  ━ ┛");
		
		System.out.print(">> ");
		int replay = scan.nextInt();
		System.out.println();
		//1을 입력했을 때 다시 stpe1로 돌아감
		if(replay==1) {
			bread = 10;
			step1();
		}
		//2를 입력했을 때 게임이 종료됨
		else if(replay==2){
			System.out.println("\n");
			System.out.println("╋ ━ ━━ ━ ━━ ━ ━━ ━ ━━ ╋");
			System.out.println("    !!다음에 또 만나요!!");
			System.out.println("╋ ━ ━━ ━ ━━ ━ ━━ ━ ━━ ╋");
			System.out.println("   w     w┗━┛w\n\n");
			
		}
	}
}

//게임이 실행되는 메소드
public class ForkedLoadGame {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("┏━━━━ ━━━━━━━━━━━━━━━━━━━━ ━━━━━━━━━━━━━━━━━┓");
		System.out.println(" ┃     _ __    !!!안녕하세요!!!               ┃");
		System.out.println(" ┃ __        당신은 빨간 모자 입니다!    ___      ┃");
		System.out.println("┃ 늑대를 피해 🍞빵을 무사히 할머니 댁으로 전달해 주세요!  ┃");
		System.out.println("┃       ___         ...   _ __              ┃");
		System.out.println(" ┃           그럼 게임을 시작합니다!!  ___ _      ┃");
		System.out.println("┗━━━━━━━━━━━ ━━━━━━━━━━━ ━━━━━━━━━━━ ━━━━━━┛");
		System.out.println("                    ┃   ┃");
		System.out.println("                 w w┗━━━┛w\n\n");
		
		//User 클래스에 대한 user 객체 생성
		User user = new User();
		user.Load();
		//Game 클래스에 대한 game 객체 생성
		Game game = new Game(0, 10, 0);
		game.step1();
	}
}