
public class Sorting {
	public static void main(String[] args) {
		int toFind = 1;
		int[] users = {2,3, 23,12,32,43,44,54,56,62,64,75,75,85};
		print(users);
		bubbleSort(users);
		print(users);
	}
////		if (users[users.length - 1] < toFind || users[0] > toFind) {
//			System.out.println("User not found");
//			return;
//		}
//		for (int i = 0; i < users.length; i++) {
//			if (users[i] == toFind) {
//				System.out.println("User found.");
//				return;
//			}
//		} 
//		System.out.println("User not found.");
//	}
//	
	public static void bubbleSort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
//					
					swap(arr, j, j + 1);
				
				}
			}
		}
	}
	// 1, 4, 5, 6, 23, 45
		public static void selectionSort(int[] arr) {
			for (int i = 0; i < arr.length - 1; i++) {
				int min_idx = i;
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] < arr[min_idx]) {
						min_idx = j;
					}
				}
				swap(arr, i, min_idx);
				
			}
		}
	
		public static void swap(int[] arr,int a, int b ) {
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
		public static void print(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i] + " ");
			}
			System.out.println();
		}
	}

