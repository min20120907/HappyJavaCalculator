import java.util.Scanner;
import java.util.Arrays;

public class main {
	public static String[] remove(String[] StringArr, String elem) {
		for(int i = 0; i < StringArr.length; i++){
            if(StringArr[i] == elem){
                // shifting elements
                for(int j = i; j < StringArr.length - 1; j++){
                    StringArr[j] = StringArr[j+1];
                }
                break;
            }
        }
		return StringArr;
	}
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please input the math problem: ");
		String input = s.nextLine();
		String[] group = input.split("\\s+");
		int result = Integer.parseInt(group[0]);
		for (int a = 0; a < group.length; a++) {
			if (input.contains("*") || input.contains("/") || input.contains("%")) {
				if (group[a] instanceof String) {
					switch (group[a]) {
					case "*":
						result = Integer.parseInt(group[a - 1])*Integer.parseInt(group[a + 1]);
						group[a]=String.valueOf(result);
						remove(group,group[a-1]);
						remove(group,group[a+1]);
						result = Integer.parseInt(group[0]);
						System.out.println(a);
						a=0;
						break;
					case "/":
						result = Integer.parseInt(group[a - 1])/Integer.parseInt(group[a + 1]);
						remove(group,group[a-1]);
						remove(group,group[a+1]);
						group[a]=String.valueOf(result);
						result = Integer.parseInt(group[0]);
						a=0;
						break;
					case "%":
						result = Integer.parseInt(group[a - 1])%Integer.parseInt(group[a + 1]);
						remove(group,group[a-1]);
						remove(group,group[a+1]);
						group[a]=String.valueOf(result);
						result = Integer.parseInt(group[0]);
						a=0;
						break;
					case "+":
						result += Integer.parseInt(group[a + 1]);
						break;
					case "-":
						result -= Integer.parseInt(group[a + 1]);
						break;
					default:
						break;
					}
					
				}
				
			} 
			
		}
		System.out.println("The result is: " + result);
	}
}
