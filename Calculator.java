package week12_assign;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
	private JTextField textField = new JTextField();
	private String num = ""; // 계산식의 숫자를 담을 변수
	//계산 기능을 구현하기 위해 ArrayList에 숫자와 연산 기호를 하나씩 구분해 담음
	private ArrayList<String> equation = new ArrayList<String>();
	
	public Calculator() {
		setTitle("계산기");
		new BorderLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램을 종료하도록 설정
		
		Container contentPane = getContentPane();
		// 패널 두개 생성 (텍스트필드, 버튼필드)
		JPanel textPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		// 각 패널에 배치관리자 할당
		textPanel.setLayout(new FlowLayout());
		buttonPanel.setLayout(new GridLayout(4, 4, 1, 1));
	
		// 텍스트필드 생성 및 사이즈 설정
		textField.setPreferredSize(new Dimension(390 ,95));
		textPanel.add(textField);
		
		// 폰트 적용안됨 현상 수정
		Font font = new Font("Arial", Font.BOLD, 55);
		textField.setFont(font);
		textField.setHorizontalAlignment(JTextField.RIGHT);
		
		String[] buttonName = {"c","÷","×","=","7","8","9","+","4","5","6","-","1","2","3","0"};
		JButton[] button = new JButton[16];
		
		for(int i=0; i<16; i++){
			 button[i]=new JButton(buttonName[i]);
			 buttonPanel.add(button[i]);
			 button[i].addActionListener(new PadActionListener());
		}
		button[0].setForeground(Color.RED);
//		button[0].setBackground(Color.RED);
//		button[0].setOpaque(true);
//		button[0].setBorderPainted(false);
		
		// 프레임에 각 패널 추가
		contentPane.add(textPanel, BorderLayout.NORTH);
		contentPane.add(buttonPanel, BorderLayout.CENTER);
        
		pack();
		setSize(400, 600);
		setVisible(true); // 화면에 프레임 출력
	}
	
	class PadActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//어떤 버튼이 눌렸는지를 알아냄
			String operation = e.getActionCommand();
			
			//C가 눌렸을 경우 위의 계산식 내용을 지워줌
			if (operation.equals("c")) {
				textField.setText("");
			//=이 눌렸을 경우 위에 입력된 식을 계산, 계산값이 나오도록 함
			} else if (operation.equals("=")) {
				//밑의 메소드들을 이용하여 계산, 계산식 화면에 값을 띄워줌
				String result = Integer.toString(calculate(textField.getText()));
				textField.setText("" + result);
				num = "";
			//나버지 버튼은 눌렀을 때 계산식에 추가됨
			} else {
				textField.setText(textField.getText() + e.getActionCommand());
			}
		}

		private void fullTextParsing(String inputText) {
			equation.clear();
			
			//계산식의 글자를 하나하나 거쳐감
			for (int i = 0; i < inputText.length(); i++) {
				char ch = inputText.charAt(i);
				
				//연산기호가 나오면 ArrayList에 추가되고 초기화
				if (ch == '-' || ch == '+' || ch == '×' || ch == '÷') {
					//연산기호를 만났다 : 앞은 숫자라는 것을 의미
					//숫자를 ArrayList에 추가
					equation.add(num);
					//num 초기화
					num = "";
					//연산기호를 ArrayList에 추가
					equation.add(ch + "");
				} else {
					//나머지는 그냥 숫자 처리
					num = num + ch;
				}
			}
			//반복문 끝나고 남아있는 숫자값 추가
			equation.add(num);
		}
		
		//계산 기능
		public int calculate(String inputText) {
			fullTextParsing(inputText);
			
			//위의 메소드를 실행하면 ArrayList에 숫자와 연산 기호가 담김
			int prev = 0;
			int current = 0;
			//연산 기호에 대한 처리를 위한 변수
			String mode = "";
			
			for (String s : equation) {
				if (s.equals("+")) {
					mode = "add";
				} else if (s.equals("-")) {
					mode = "sub";
				}  
				else if (s.equals("×")) {
					mode = "mul";
				}  
				else if (s.equals("÷")) {
					mode = "div";
				}  else {
					current = Integer.parseInt(s);
					
					//mode값에 따라 처리, prev는 계속 계산값이 갱신됨
					if (mode.equals("add")) {
						prev += current;
					} else if (mode.equals("sub")) {
						prev -= current;
					} 
					else if (mode.equals("mul")) {
						prev *= current;
					} 
					else if (mode.equals("div")) {
						prev /= current;
					} else {
						prev = current;
					}
				}
			}
			//계산값 prev 반환	
			return prev;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();
	}

}
