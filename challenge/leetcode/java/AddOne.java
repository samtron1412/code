public class AddOne {
    public static int[] addOne(int[] arr) {
        int carry = 1;
        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum = arr[i] + carry;
            carry = sum / 10;
            arr[i] = sum % 10;
            if (carry == 0)
                return arr;
        }
        int[] newArr = new int[arr.length + 1];
        newArr[0] = carry;
        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }

    public static int[] recurAddOne(int[] arr) {
        addOne(arr, arr.length - 1);
        if (arr[0] == 0) {
            int[] newArr = new int[arr.length + 1];
            newArr[0] = 1;
            for (int i = 0; i < arr.length; i++) {
                newArr[i + 1] = arr[i];
            }
            return newArr;
        }
        return arr;
    }

    private static void addOne(int[] arr, int index) {
        if (index < 0) {
            return;
        }
        if (arr[index] < 9) {
            arr[index] += 1;
            return;
        }
        arr[index] = 0;
        addOne(arr, index - 1);
    }

    public static void main(String[] args) {
        // int[] arr = new int[]{9};
        // int[] arr = new int[]{1, 2, 3};
        int[] arr = new int[]{9, 9, 9};
        // int[] newArr = addOne(arr);
        int[] newArr = recurAddOne(arr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + ", ");
        }
    }
}
