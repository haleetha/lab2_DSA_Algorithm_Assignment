import java.util.Scanner;

public class PayMoney {
	static Scanner sc = new Scanner(System.in);
	static int arr[];
	static int targetTrans;
	static int targetValue;
	static int size;
	static boolean flag = true;

	// fetching the user values and storing them
	static void getValues(int n, Scanner sc) {
		size = n;
		arr = new int[size];

		// Getting values of each transaction from user
		for (int i = 0; i < n; i++) {
			System.out.println(" Enter the value of transaction " + (i + 1));
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter the total no of targets that needs to be achieved");
		targetTrans = sc.nextInt();

		do {
			flag = calculateThreshold();

		} while (flag);

	}

	static boolean calculateThreshold() {
		System.out.println("\nEnter the Value of target");
		targetValue = sc.nextInt();

		int tempSum = 0;
		int i = 0;
		boolean flag = false;

		for (i = 0; i < size; i++) {

			tempSum += arr[i];

			if (tempSum > targetValue && i < targetTrans) {
				System.out.println("Target " + targetValue + " acheived in " + (i + 1) + " transactions");
				flag = true;
				break;
			}

		}
		if (!flag) { // for situation where the target is not achieved
			System.out.println("\nTarget " + targetValue + " is NOT acheived in " + targetTrans + " transactions");
		}

		return flag;

	}

	public static void main(String[] args) {

		int size;

		System.out.println("Enter the size of the transacation array");
		size = sc.nextInt();

		getValues(size, sc);

	}

}
