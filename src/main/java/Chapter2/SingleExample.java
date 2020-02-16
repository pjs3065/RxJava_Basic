package Chapter2;

import io.reactivex.Observable;
import io.reactivex.Single;

public class SingleExample {

    /**
     * Single 클래스의 just() 함수 활용 예
     */
    private void single(){
        Single<String> source = Single.just("Hello Single");
        source.subscribe(System.out::println);
    }

    /**
     * Observable 클래스에서 Single 클래스를 활용 하는 예
     */
    private void fromObservable(){

        //1. 기존 Observable에서 Single 객체로 변환하기.
        Observable<String> source = Observable.just("Hello Single");
        Single.fromObservable(source)
                .subscribe(System.out::println);

        //2. single() 함수를 호출해 Single 객체 생성하기
        Observable.just("Hello Single")
                .single("default item")
                .subscribe(System.out::println);

        //3. first() 함수를 호출해 Single 객체 생성하기
        String[] colors = {"Red", "Blue", "Gold"};
        Observable.fromArray(colors)
                .first("default value")
                .subscribe(System.out::println);

        //4. empty Observable에서 Single 객체 생성하기
        Observable.empty()
                .single("default value")
                .subscribe(System.out::println);

        //5. take() 함수에서 Single 객체 생성하기
        Observable.just(new Order("ORD-1"), new Order("ORD-2"))
                .take(1)
                .single(new Order("default order"))
                .subscribe(System.out::println);
    }

    private void errorCase(){
        Single<String> source = Observable
                .just("Hello Single", "Error")
                .single("default item");
        source.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        SingleExample obj = new SingleExample();
        obj.single();
        obj.fromObservable();
//        obj.errorCase();
    }
}
