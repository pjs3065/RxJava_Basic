package chapter2;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;

public class AsyncSubjectExample {

    /**
     * AsyncSubject 클래스의 마블 다이어그램 예제
     */
    public void marbleDiagram(){
        AsyncSubject<String> subject = AsyncSubject.create();

        //구독 시작
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));

        subject.onNext("red");
        subject.onNext("green");

        //두번째 구독 시작
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.onNext("blue");
        subject.onComplete();
    }

    /**
     * AsyncSubject 클래스가 Observable의 구독자로 동작하는 예제
     */
    public void asSubscriber(){
        Float[] temperature = {10.1f, 13.4f, 12.5f};
        Observable<Float> source = Observable.fromArray(temperature);

        AsyncSubject<Float> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));

        source.subscribe(subject);
    }

    /**
     * onComplete() 함수 호출 후 AsyncSubject 반응 보기
     */
    public void afterComplete(){
        AsyncSubject<Integer> subject = AsyncSubject.create();
        subject.onNext(10);
        subject.onNext(11);
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data ));
        subject.onNext(12);
        subject.onComplete();
        subject.onNext(13);
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data ));
        subject.subscribe(data -> System.out.println("Subscriber #3 => " + data ));
    }

    public static void main(String[] args) {
        AsyncSubjectExample obj = new AsyncSubjectExample();
        obj.marbleDiagram();
        obj.asSubscriber();
        obj.afterComplete();
    }
}
