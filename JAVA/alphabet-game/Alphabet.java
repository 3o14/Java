package week12_assign;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


class Alphabet extends JFrame {
	private int c=0;
    private JLabel[] alphabets = new JLabel[25];
    
    public Alphabet() {
        this.setTitle("알파벳 순서대로 없애기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        for( int i = 0, num = 65; i < alphabets.length; i++, num++ ) {

        	alphabets[i]= new JLabel("");	// 하나씩 JLabel 생성
        	String str = String.valueOf((char)num);
        	// JLabel에 아스키코드를 이용한 알파벳을 삽입하기 위해
        	// 숫자 -> char -> String -> setText를 이용해 JLabel 에 삽입한다.
            alphabets[i].setText(str);

            alphabets[i].setSize(20,20);
            
            // 랜덤한 장소에 알파벳 배치
            int x=(int)(Math.random()*350);
            int y=(int)(Math.random()*350);
            alphabets[i].setLocation(x, y);
            
            // 마우스이벤트 설정
            alphabets[i].addMouseListener(new MyMouseListener());
            this.add(alphabets[i]);
        }
        this.setSize(400,400);
        this.setVisible(true);
    }
	class MyMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            JLabel a =(JLabel)e.getSource();
            if(alphabets[c]==a){
                a.setVisible(false);
                c++;
            }
            if(c == 25) {
            	JOptionPaneEx();
            }
        }
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
	public void JOptionPaneEx(){
		int answer = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?", "알파벳을 모두 없앴습니다!", JOptionPane.DEFAULT_OPTION);
		if(answer == 0){  //사용자가 yes를 눌렀을 경우
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}
}
}