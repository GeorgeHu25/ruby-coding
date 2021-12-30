
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {38,27,43,3,9,82,10};
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(arr);
	}
	
	
	public static void mergeSort(int[] arr, int l, int r) {
		if (l<r) {
			int mid = (l+r)/2;
			System.out.println(mid);
			mergeSort(arr, l, mid);
			mergeSort(arr,mid+1,r);
			merge(arr, l,mid,r);
			
		}
		

	}
	
	public static void merge(int[] arr, int l, int m, int r) {
		int[] left = new int[m - l + 1];
		int[] right = new int[r-m];
		
		for (int i = 0; i < left.length; i++) {
			left[i] = arr[l + i];
		}
		for (int i = 0; i < right.length; i++) {
			right[i] = arr[m+1+ i];
		}
		
		int i = 0, j = 0;
		int idx = l;
		while (i < left.length && j < right.length) {
			if (left[i] <= right [j]) {
				arr[idx] = left[i];
				i++;
			} else {
				arr[idx] = right [j];
				j++;
			}
			idx++;
		}
		
		while (i < left.length) {
			arr[idx] = left[i];
			i++;
			idx++;
		}
		
		while(j < right.length) {
			arr[idx] = right[j];
			j++;
			idx++;
		}
	}
}
