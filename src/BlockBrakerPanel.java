import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BlockBrakerPanel extends JPanel implements KeyListener{
	
	ArrayList<Block> blocks = new ArrayList<Block>();
	ArrayList<Block> ball = new ArrayList<Block>();
	Block paddle;
	Thread thread;
	Animate animate;
	int size = 25;
	BlockBrakerPanel(){	
		paddle = new Block(175,480,150,25, "paddle.png");
		for (int i = 0; i < 8; i++) {
			blocks.add(new Block ((i*60+2),0,60,25,"blue.png"));
		}
		for(int i = 1; i<8; i++) {
			blocks.add(new Block ((i*60+2),25,60,25,"red.png"));
		}
		for(int i = 1; i<8; i++) {
			blocks.add(new Block ((i*60+2),50,60,25,"green.png"));
		}
		for(int i = 1; i<8; i++) {
			blocks.add(new Block ((i*60+2),75,60,25,"yellow.png"));
		}
		// ((i*60+2),0,60,25,"yellow.png" 0,60,25 - 0 stants for pixels in this case is moving them down by 25
		ball.add(new Block(237,435,25,25, "ball.png"));
		addKeyListener (this); //without this two lines we cant read the keys 
		setFocusable(true);
		
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g); //ereases the screen and than in the for loop it paints it again.
		for (Block b : blocks)
			b.draw(g, this);
		for(Block b : ball)
			b.draw(g, this);
		paddle.draw(g, this);
	}
	public void update() {
		for (Block ba : ball) {
			ba.x+=ba.dx;
			if(ba.x > (getWidth()-size)&& ba.dx > 0 || ba.x < 0)
				ba.dx*=-1;
			if(ba.y < 0 || ba.intersects(paddle))
				ba.dy*=-1;
			ba.y+=ba.dy;
			for(Block b : blocks) {
				if(ba.intersects(b) && !b.destroyerd) {
					b.destroyerd = true;
					ba.dy*=-1;
				}
			}
		}
			
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			animate = new Animate(this);
			thread = new Thread(animate);
			thread.start();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			paddle.x -=15; //-=15 subracksts 15 pixels form each keypress
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			paddle.x +=15;  //+=15 adds15 pixels form each keypress
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
