import java.util.Scanner;
import java.util.Arrays;

public class main {
	static String[] removeAt(int k, String[] arr) {	//remove element from array function
		final int L = arr.length;
		String[] ret = new String[L - 1];
		System.arraycopy(arr, 0, ret, 0, k);
		System.arraycopy(arr, k + 1, ret, k, L - k - 1);
		return ret;
	}

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);	//proclaim the input
		System.out.println("Please input the math problem: ");	//input hint
		String input = s.nextLine();	//get input data
		String[] group = input.split("\\s+"); // split input data as space key
		int result = Integer.parseInt(group[0]); // initializing the result data
		for (int a = 0; a < group.length; a++) { //making steps to calculating the datas
			if (input.contains("*") || input.contains("/") || input.contains("%")) {	//multiplication ,divide, and % first
				if (group[a] instanceof String) {	//check the validity of parameters
					switch (group[a]) {	//check the operation symbol
					case "*":		//in the circumstance of multiplication
						result = Integer.parseInt(group[a - 1]) * Integer.parseInt(group[a + 1]);	//multiplication the first and second number
						group = removeAt(a - 1, group);		//remove the exist numbers
						group = removeAt(a, group);			//remove the exist numbers 
						group[a - 1] = String.valueOf(result);	//update number
						result = Integer.parseInt(group[0]);	//update result
						System.out.println(Arrays.toString(group));	//progress output
						a = 0;	//doing the simpler tasks
						break;
					case "/":
						result = Integer.parseInt(group[a - 1]) / Integer.parseInt(group[a + 1]);
						group = removeAt(a - 1, group);
						group = removeAt(a, group);
						group[a - 1] = String.valueOf(result);
						result = Integer.parseInt(group[0]);
						System.out.println(Arrays.toString(group));
						a = 0;
						break;
					case "%":
						result = Integer.parseInt(group[a - 1]) % Integer.parseInt(group[a + 1]);
						group = removeAt(a - 1, group);
						group = removeAt(a, group);
						group[a - 1] = String.valueOf(result);
						result = Integer.parseInt(group[0]);
						System.out.println(Arrays.toString(group));
						a = 0;
						break;
					case "+":
						result += Integer.parseInt(group[a + 1]);	//keep adding
						break;
					case "-":
						result -= Integer.parseInt(group[a + 1]);	//keep minusing
						break;
					default:
						break;
					}

				} else {
					System.out.println("Syntax Error!");
				}

			} else {
				if (group[a] instanceof String) {
					switch (group[a]) {
					case "+":
						result += Integer.parseInt(group[a + 1]);
						break;
					case "-":
						result -= Integer.parseInt(group[a + 1]);
						break;
					default:
						break;
					}
				} else {
					System.out.println("Syntax Error!");
				}
			}

		}
		System.out.println("The result is: " + result);
	}
}
