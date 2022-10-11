package chapter13;

public class MyThread2 implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {

			try {
				Thread.sleep(500); // 현재 스레드의 상태를 block 상태로 변경
				// 시행 대상에서 해당 ms 동안 빠지게 해줌
				System.out.println("Runnable 인터페이스를 이용한 스레드 생성 및 작업 진행");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
