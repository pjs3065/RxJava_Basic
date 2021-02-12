package chapter2;

import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubjectExample {

    public void marbleDiagram(){
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("pink");
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data ));
        subject.onNext("red");
        subject.onNext("green");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data ));
        subject.onNext("blue");
        subject.onComplete();
    }

    public static void main(String[] args) {
        BehaviorSubjectExample obj = new BehaviorSubjectExample();
        obj.marbleDiagram();
    }
}
