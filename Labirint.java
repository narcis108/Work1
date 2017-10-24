import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Labirint extends JFrame {

    private int [][] maze =
            {       {1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,1,1,1,1,1,1,1,1,1,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,0,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,1,1,1,1,1,1,1,1,1,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,0,0,1},
                    {1,0,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,0,0,0,0,0,0,0,0,0,9,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}
            };

    int pathX = 1, pathY = 1;

    public Labirint() {
        setTitle("Labirint");
        setSize(750, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.translate(50, 50);
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Color color;
                switch (maze[row][col]) {
                    case 1 : color = Color.darkGray; break;
                    case 9 : color = Color.yellow; break;
                    default : color = Color.pink;
                }
                g.setColor(color);
                g.fillRect(50 * col, 50 * row, 50, 50);
                g.setColor(Color.BLACK);
                g.drawRect(50 * col, 50 * row, 50, 50);
            }
        }
        g.setColor(Color.white);
        g.fillOval(pathX * 50, pathY * 50, 50, 50);
//        Image  im = Toolkit.getDefaultToolkit().getImage(getClass().getResource("bee2.png"));
//        g.drawImage(im, pathX*50,pathY*50, 50,50, null);
    }

    @Override
    protected void processKeyEvent(KeyEvent ke) {
        switch (ke.getKeyCode()){
            case KeyEvent.VK_DOWN :  if(pathY+1 < 10 && maze[pathY+1][pathX]   == 0) pathY++; else if(pathY+1 < 10 && maze[pathY+1][pathX]   == 9) JOptionPane.showMessageDialog(this, "Win");break;
            case KeyEvent.VK_UP :    if(pathY-1 > 0  && maze[pathY-1][pathX]   == 0) pathY--; else if(pathY-1 > 0  && maze[pathY-1][pathX]   == 9) JOptionPane.showMessageDialog(this, "Win");break;
            case KeyEvent.VK_RIGHT:  if(pathX+1 < 12 && maze[pathY][pathX+1]   == 0) pathX++; else if(pathX+1 < 12 && maze[pathY][pathX+1]   == 9) JOptionPane.showMessageDialog(this, "Win");break;
            case KeyEvent.VK_LEFT:   if(pathX-1 > 0  && maze[pathY][pathX-1]   == 0) pathX--; else if(pathX-1 > 0  && maze[pathY][pathX-1]   == 9) JOptionPane.showMessageDialog(this, "Win");break;
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Labirint view = new Labirint();
                view.setVisible(true);
            }
        });
    }

}