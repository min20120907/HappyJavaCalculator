import java.util.Scanner;
import java.util.Arrays;

public class main {
	static String[] removeAt(int k, String[] arr) {
		final int L = arr.length;
		String[] ret = new String[L - 1];
		System.arraycopy(arr, 0, ret, 0, k);
		System.arraycopy(arr, k + 1, ret, k, L - k - 1);
		return ret;
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
						result = Integer.parseInt(group[a - 1]) * Integer.parseInt(group[a + 1]);
						group = removeAt(a - 1, group);
						group = removeAt(a, group);
						group[a - 1] = String.valueOf(result);
						result = Integer.parseInt(group[0]);
						System.out.println(Arrays.toString(group));
						a = 0;
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
