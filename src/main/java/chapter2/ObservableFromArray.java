package chapter2;

import io.reactivex.Observable;

import java.util.stream.IntStream;

public class ObservableFromArray {
    /**
     *  fromArray()함수를 이용해서 배열에 들어 있는 데이터를 처리하기
     */
    private void integerArray() {
        Integer[] arr = {100, 200, 300};
        Observable<Integer> source = Observable.fromArray(arr);
        source.subscribe(System.out::println);
    }

    /**
     * fromArray()함수에서 int[]타입을 사용한다면?
     */
    private void intArrayWrong(){
        int[] intArray = {400, 500, 600};
        Observable.fromArray(intArray).subscribe(System.out::println);
    }

    /**
     * int[]배열 값을 Integer[]값으로 변환한다.
     *
     * @param intArray int[] 배열값
     * @return 변환한 Integer[] 배열 값
     */
    private static Integer[] toIntegerArray(int[] intArray){
        return IntStream.of(intArray).boxed().toArray(Integer[]::new);
    }

    /**
     * int[] 배열 값을 Integer[]값으로 변환후 fromArray()를 통해 데이터 처리하기
     */
    private void intArray(){
        int[] intArray = {400, 500, 600};
        Observable<Integer> source = Observable.fromArray(toIntegerArray(intArray));
        source.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        ObservableFromArray obj = new ObservableFromArray();
        obj.integerArray();
        obj.intArrayWrong();
        obj.intArray();
    }
}
