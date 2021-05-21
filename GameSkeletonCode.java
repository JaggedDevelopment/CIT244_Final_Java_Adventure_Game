//Nicolas Shelley Assignment 7 Java 244

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GameSkeletonCode {

	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int playerHP, monsterHP;
	String weapon, position;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	//Title screen handler is responsible for the title screen button
	ChoiceHandler choiceHandler = new ChoiceHandler();
	//Choice handler listens for which choice button is pressed.
	//Also runs the switch method at the bottom of the code under ChoiceHandler()

	public static void main(String[] args) {
		
		new GameSkeletonCode();
		//Starts the game and begins the method loops.

	}
	
	public GameSkeletonCode(){
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
		//Main Window Bounds 
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
		//Title screen main text
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		startButtonPanel.add(startButton);
		//Title screen button
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
	}
	
	public void createGameScreen(){
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		//Removes title Screen
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);		
		mainTextArea = new JTextArea("This is the main text are. This game is going to be great. I'm sure of it!!!!!!!");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		//Adds main dialogue box on the adventure game screen
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		//If more choices are added. (vertical choices, horizontal choices)
		con.add(choiceButtonPanel);
		//Sets up Grid Layout for choice buttons
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		/* 		choiceN = new JButton("Choice N");
				choiceN.setBackground(Color.black);
				choiceN.setForeground(Color.white);
				choiceN.setFont(normalFont);
				choiceN.setFocusPainted(false);
				choiceN.addActionListener(choiceHandler);
				choiceN.setActionCommand("cN");
				choiceButtonPanel.add(choiceN); 
				
				To add a new choice this must be copied and N changed to next number.
				A new J button must be defined as well.
		 */
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		//panel for the players information
		
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);//Just HP text
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);//HP amount
		//Holds information for Player Health
		
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);//Just Weapon Text
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);//Weapon type variable
		//Holds Weapon information

		playerSetup();//switches scene to player setup function

	}

	public void playerSetup(){
		playerHP = 15;//player health
		monsterHP = 20;//monster health
		weapon = "Sword";//defines weapon type
		weaponLabelName.setText(weapon);//defines the weapon of the player
		hpLabelNumber.setText("" + playerHP);//Sets up the player health
		
		townGate();//switches scene to town gate opening screen
	}
	
	public void townGate(){
		position = "townGate";
		//position variable allows the switch function in the Choice Handler to know where the player is in the game.
		monsterHP = 20;//This is here for demo purposes to reset the monster health to refresh after leaving fight.
		mainTextArea.setText("You are at the gate of the town. \nWhat function would you like to try?");
		//Changes the dialogue text on the screen		
		choice1.setText("Talk to the guard");
		//Sets Choice 1 button text
		choice2.setText("Fight a monster");
		//Sets Choice 2 button text
		choice3.setText("Obtain New Weapon");
		//Sets Choice 3 button text
		choice4.setText("Leave the Area");
		//Sets Choice 4 button text
	}
	public void talkGuard(){
		position = "talkGuard";
		mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \nI'm sorry but we cannot let a stranger enter our town.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void fight(){
		position = "fight";
		mainTextArea.setText("Goblin's ready to fight! \nHP:" + monsterHP);
		choice1.setText("Attack Monster");
		choice2.setText("Run Away");
		choice3.setText("");
		choice4.setText("");
	}
	public void newWeapon(){
		position = "newWeapon";
		mainTextArea.setText("You are at a crossroad.\nYou see an Axe.");
		choice1.setText("Take the Axe");
		choice2.setText("Return to Town");
		choice3.setText("");
		choice4.setText("");
	}
	public void axePickup(){
		position = "axe";
		mainTextArea.setText("You take the Axe!");
		
		weapon = "Axe";
		//Changes the player weapon to a predetermined weapon
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void PlayerAttack(){
		position = "PlayerAttack";
		
		int playerDamage = 0;//Resets player damage from last turn
		
		if(weapon.equals("Sword")){
			playerDamage = new java.util.Random().nextInt(8);
			//makes player damage a random integer up to the amount in parentheses
		}
		else if(weapon.equals("Axe")){
			playerDamage = new java.util.Random().nextInt(12); 
		}
		
		mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
		
		monsterHP = monsterHP - playerDamage;
		//takes player damage away from the monsters health
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void MonsterAttack(){
		position = "MonsterAttack";
		
		int monsterDamage = 0;
		
		monsterDamage = new java.util.Random().nextInt(6); 
		
		mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");
		
		playerHP = playerHP - monsterDamage;
		hpLabelNumber.setText(""+playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");	
	}
	public void win(){
		position = "win";
		
		mainTextArea.setText("You defeated the monster!");
		
		choice1.setText("Return to Town Gate");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void lose(){
		position = "lose";
		
		mainTextArea.setText("You are dead!\n\n");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();//Starts new game screen
		}
	}
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
			
			switch(position){
			case "townGate"://text must match corresponding function (townGate() position = townGate)
				switch(yourChoice){
				case "c1": //Choice 1 button gets clicked
					talkGuard();
					break;
				case "c2": //Choice 2 button gets clicked
					fight();
					break;
				case "c3": //Choice 3 button gets clicked
					newWeapon();
					break;
				case "c4": //Choice 4 button gets clicked
					System.exit(0);
					break;
				}
				break;
			case "fight":
				switch(yourChoice){
				case "c1": 
					PlayerAttack();
					break;
				case "c2":
					townGate();
					break;
				}
				break;
			case "PlayerAttack":
				switch(yourChoice){
				case "c1": 
					if(monsterHP<1){
						win();
					}
					else{
						MonsterAttack();
					}
					break;
				}
				break;
			case "MonsterAttack":
				switch(yourChoice){
				case "c1": 
					if(playerHP<1){
						lose();
					}
					else{
						fight();
					}
					break;
				}
				break;
			case "talkGuard":
				switch(yourChoice){
				case "c1":
					townGate();
					break;
				}
				break;
			case "win":
				switch(yourChoice){
				case "c1":
					townGate();
					break;
				}
				break;
			case "newWeapon":
				switch(yourChoice){
				case "c1":
					axePickup();
					break;
				case "c2":
					townGate();
					break;
				}
				break;
			case "axe":
				switch(yourChoice){
				case "c1":
					townGate();
					break;
				}
				break;
				
			}
			
		}
	}
}
