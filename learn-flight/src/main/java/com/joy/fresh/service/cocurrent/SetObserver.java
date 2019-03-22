package com.joy.fresh.service.cocurrent;

/**
 * Created by jianyuanhao on 18-4-6.
 */
public interface SetObserver<E> {
    //Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}
