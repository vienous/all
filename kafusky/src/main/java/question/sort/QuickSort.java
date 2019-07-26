package question.sort;

public class QuickSort {

	public static void quickSort(int[] arr, int startIndex, int endIndex) {
		// 递归结束条件：startIndex大等于endIndex的时候
		if (startIndex >= endIndex) {
			return;
		}
		// 得到基准元素位置
		int pivotIndex = partition(arr, startIndex, endIndex);
		// 用分治法递归数列的两部分
		quickSort(arr, startIndex, pivotIndex - 1);
		quickSort(arr, pivotIndex + 1, endIndex);
	}

	private static int partition(int[] arr, int startIndex, int endIndex) {
		int pivot = arr[startIndex];
		int left = startIndex;
		int right = endIndex;
		int index = startIndex;
		while (right >= left) {
			//right指针从右向左进行比较
			while (right >= left) {
				if (arr[right] < pivot) {
					arr[left] = arr[right];
					index = right;
					left++;
					break;
				}
				right--;
			}
			//left指针从左向右进行比较
			while (right >= left) {
				if (arr[left] > pivot) {
					arr[right] = arr[left];
					index = left;
					right--;
					break;
				}
				left++;
			}
		}
		arr[index] = pivot;
		return index;
	}

//	public static void main(String[] args) {
//		int[] arr = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
//		quickSort(arr, 0, arr.length - 1);
//		System.out.println(Arrays.toString(arr));
//	}

	public static void main(String[] args) {
		double a = 3.42309838424234;
		double b = 43242.24234234;
		System.out.println(a / b);
	}
}
