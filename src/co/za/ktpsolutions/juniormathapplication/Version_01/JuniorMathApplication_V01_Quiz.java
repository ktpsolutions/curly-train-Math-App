package co.za.ktpsolutions.juniormathapplication.Version_01;
import java.awt.Component;
/**
 * Imports
 */
import java.util.Random;

import javax.swing.JOptionPane;

public class JuniorMathApplication_V01_Quiz {
	
	private static void newQuiz(Component c){
		int numberOfQuestions = 0;
		boolean validNumberOfTurns = false;
		while(!validNumberOfTurns){
			try{
				numberOfQuestions = Integer.parseInt(JOptionPane.showInputDialog(c, "Please enter the number of rounds you wish to play: ", "Number of questions to be played ?",JOptionPane.QUESTION_MESSAGE));
				
				if(numberOfQuestions < 1){
					throw new NumberFormatException();
				}
				validNumberOfTurns = true;
			}
			
			catch (NumberFormatException e){
				if(e.toString().equals("java.lang.NumberFormatException: null")){
					int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit ?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
					if(response == JOptionPane.YES_OPTION){
						System.exit(0);
					}
					else{
						continue;
					}
				}
				JOptionPane.showMessageDialog(c, "Please enter a valid number i.e. Any number greater than 0", "Error!", JOptionPane.ERROR_MESSAGE);
				continue;
			}
			
		}
		int[] userAnswers = new int[numberOfQuestions];
		java.util.Map<Integer,String> questions = new java.util.HashMap<Integer,String>();
		java.util.Map<String,Integer> modelAnswers = new java.util.HashMap<String,Integer>();
		Random randomGen = new Random();
		for(int j = 0; j < numberOfQuestions; j ++){
			boolean validUserAnswer = false;
			int firstElement = randomGen.nextInt(100);
			int secondElement = randomGen.nextInt(100);
			int operation = randomGen.nextInt(4);
			while (firstElement == 0 || secondElement == 0){
				firstElement = randomGen.nextInt(100);
				secondElement = randomGen.nextInt(100);
			}
			
			switch(operation){
			case 0: questions.put(j, firstElement + " + " + secondElement);
					modelAnswers.put(questions.get(j), firstElement + secondElement);
					break;
			case 1: questions.put(j, firstElement + " - " + secondElement);
					modelAnswers.put(questions.get(j), firstElement - secondElement);
					break;
			case 2: questions.put(j, firstElement + " * " + secondElement);
					modelAnswers.put(questions.get(j), firstElement * secondElement);
					break;
			case 3: questions.put(j, firstElement + " / " + secondElement);
					modelAnswers.put(questions.get(j), firstElement / secondElement);
					break;
			}
			
			while(!validUserAnswer){
				try{
					userAnswers[j] = Integer.parseInt(JOptionPane.showInputDialog(c, questions.get(j) + " = ?", "Question #" + j+1, JOptionPane.QUESTION_MESSAGE));
					validUserAnswer = true;
				}
				catch (NumberFormatException e){
					if(e.toString().equals("java.lang.NumberFormatException: null")){
						int response = JOptionPane.showConfirmDialog(c, "Are you sure you want to exit ?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
						if(response == JOptionPane.YES_OPTION){
							System.exit(0);
						}
					}
					else{
						JOptionPane.showMessageDialog(c, "Please enter a valid number i.e. Not an alphabet", "Error!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
			
			
		}
		
		evaluateQuiz(c,numberOfQuestions,userAnswers,questions,modelAnswers);
	}

	private static void evaluateQuiz(Component c,float numberOfQuestions,int[] userAnswers, java.util.Map<Integer,String> questions, java.util.Map<String,Integer> answers){
		StringBuilder result = new StringBuilder();
		float rightAnswerCount = 0;
		result.append("The Results of your quiz is: \n");
		for(int i = 0 ; i < numberOfQuestions; i++){
			if(userAnswers[i] == answers.get(questions.get(i))){
				result.append("Question #" + (i+1) +" :\t" + questions.get(i) + " = " + answers.get(questions.get(i)) + " : CORRECT\n");
				rightAnswerCount++;
			}
			else{
				result.append("Question #" + (i+1) +" :\t" + questions.get(i) + " = " + answers.get(questions.get(i)) + " : INCORRECT, your answer was; " + userAnswers[i]+"\n");
			}
		}
		int percentage = (int) ((rightAnswerCount/numberOfQuestions) * 100);
		result.append("Your score is :" + percentage + "%"); 
		
		JOptionPane.showMessageDialog(c, result.toString(), "Your Quiz Evaluation", JOptionPane.PLAIN_MESSAGE);
	}
	public static void HardQuiz (Component c){
		boolean playAgain = true;
		do{
		
			newQuiz(c);
			try{
				int response = JOptionPane.showConfirmDialog(c, "Do you want to play the quiz again?", "Play Again ?", JOptionPane.YES_NO_OPTION);
				if(response == JOptionPane.NO_OPTION){
					playAgain = false;
				}
			}
			catch(Exception e){
				if(e.toString().equals("java.lang.NumberFormatException: null")){
					int response = JOptionPane.showConfirmDialog(c, "Are you sure you want to exit ?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
					if(response == JOptionPane.YES_OPTION){
						System.exit(0);
					}
				}
			}
		}
		while(playAgain);
	}

}
