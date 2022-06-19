package pro.sky.homework2_14.IntegerListClassHW16.data;

public class GenerateArray {
    GenerateArray generateArray;

    public GenerateArray(GenerateArray generateArray) {
        this.generateArray = generateArray;
    }

    public Integer[] getRandomArray(int size) {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000);
        }
        return arr;
    }
}
