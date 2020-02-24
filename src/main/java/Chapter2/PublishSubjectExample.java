package Chapter2;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;

public class PublishSubjectExample {

    public void marbleDiagram(){
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data ));
        subject.onNext("red");
        subject.onNext("green");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data ));
        subject.onNext("blue");
        subject.onComplete();
    }

    public static void main(String[] args) {
        PublishSubjectExample obj = new PublishSubjectExample();
        obj.marbleDiagram();
    }
}
