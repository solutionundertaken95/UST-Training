import java.util.Scanner;

public class QuestionService {

    Question[] questions = new Question[2];
    String selection[] = new String[2];

    public QuestionService() {
        questions[0] = new Question(1, "What is your Name?", "Gokul", "Ashwin", "Alen", "Aravind", "Gokul");
        questions[1] = new Question(2, "Where do I live?", "Uganda", "California", "Kerala", "Dubai", "Kerala");
    }

    public void display() {
        int i = 0;
        int correct = 0;
        int incorrect = 0;
        Scanner sc = new Scanner(System.in); // Open scanner outside the loop
    
        for (Question q : questions) {
            System.out.println("Question No. " + q.getId());
            System.out.println("Question: " + q.getQuestion());
            System.out.println("Options:");
            System.out.println(" 1. " + q.getOpt1());
            System.out.println(" 2. " + q.getOpt2());
            System.out.println(" 3. " + q.getOpt3());
            System.out.println(" 4. " + q.getOpt4());
            System.out.print("Enter your answer: ");
            
            selection[i] = sc.nextLine().trim(); // Trim spaces for user input
            
            // Print user input and correct answer for troubleshooting
            System.out.println("You entered: " + selection[i]);
            System.out.println("Correct answer: " + q.getAnswer());
    
            if (selection[i].equalsIgnoreCase(q.getAnswer().trim())) { // Ignore case and spaces
                System.out.println("Correct Answer");
                correct++;
            } else {
                System.out.println("Incorrect Answer");
                incorrect++;
            }
            i++;
        }
        
        sc.close(); // Close scanner after use
        System.out.println("You scored " + correct + " out of " + questions.length);
    }
    
}
