
public class Animate implements Runnable {
	
	BlockBrakerPanel breakerPanel;
	
	Animate (BlockBrakerPanel b){
		breakerPanel = b;
	}
	public void run() {
		while (true) {
			breakerPanel.update(); //running on a continues loop
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //10 ms, there for the application wont move so fast
		}
	}
	
}
