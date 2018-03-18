package HackerRank.src.Tracks.Tutorials.ThirtyDaysOfCode.D12_Inheritance.Java;

import java.util.*;

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}

class Student extends Person{
    private int[] testScores;

    Student(String firstName, String lastName, int id, int[] scores){
        super(firstName, lastName, id);
        testScores = scores;
    }

    public char calculate(){
        int sum = 0;
        for (int i=0; i<testScores.length; i++){
            sum = sum + testScores[i];
        }
        double avg = sum/testScores.length;
        if (90 <= avg && avg <= 100){
            return 'O';
        }
        else if (80 <= avg && avg <= 90){
            return 'E';
        }
        else if (70 <= avg && avg <= 80){
            return 'A';
        }
        else if (55 <= avg && avg <= 70){
            return 'P';
        }
        else if (40 <= avg && avg <= 55){
            return 'D';
        }
        else if (avg <= 40){
            return 'T';
        }
        return 0;
    }
}

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate() );
	}
}
