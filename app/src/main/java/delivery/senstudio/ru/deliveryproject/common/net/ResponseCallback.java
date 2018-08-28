package delivery.senstudio.ru.deliveryproject.common.net;

public interface ResponseCallback<T> {
    void OnSuccess(T t);
    void OnSuccess(T[] t);
    void OnFail(int code);
}

