package com.greatlearning.lab2.algorithm;

public class TravellerUtility {

	public static int[] payMinimumnotes(int arr[], int left, int right) {

		int resArr[] = null;

		if (left < right) {

			int mid = (left + right) / 2;
			
			payMinimumnotes(arr, left, mid);

			

			payMinimumnotes(arr, mid + 1, right);

			resArr = merge(arr, left, mid, right);

		}
		return resArr;

	}

	//merge part of merge sort
	static int[] merge(int arr[], int left, int mid, int right) {
		
		int l1 = mid - left + 1;
		int l2 = right - mid;
		int leftA[] = new int[l1];
		int rightA[] = new int[l2];

		for (int i = 0; i < l1; i++) {
			leftA[i] = arr[left + i];
		}
		for (int j = 0; j < l2; j++) {
			rightA[j] = arr[mid + j + 1];
		}

		int i, j, k;
		i = 0;
		j = 0;
		k = left;

		while (i < l1 && j < l2) {

			if (leftA[i] < rightA[j]) {
				arr[k] = leftA[i];
				i++;
			} else {
				arr[k] = rightA[j];
				j++;
			}
			k++;
		}

		while (i < l1) {
			arr[k] = leftA[i];
			i++;
			k++;
		}

		while (j < l2) {
			arr[k] = rightA[j];
			j++;
			k++;
		}
		return arr;

	}

	
	//denom Finder function to get the number of minimum notes required
	static int[] denomFinder(int arr[], int amount) {
		int count[] = new int[arr.length];
		
		
		if (amount == 0) {
			 System.out.println(" Enter valid amount!!");
			
		}

		//checking from the sorted array in reverse order to start from the maximum value notes 
		for (int i = arr.length - 1; i >= 0; i--) {
			//if the amount is greater than denominated value we find the number of notes using it
			if (amount >= arr[i]) {

				count[i] = amount / arr[i];
				amount = amount % arr[i]; 
			}
		}
		return count;
	}


}
