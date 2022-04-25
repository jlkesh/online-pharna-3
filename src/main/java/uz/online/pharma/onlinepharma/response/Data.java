package uz.online.pharma.onlinepharma.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data<T> {
    protected T data;
    protected int totalCount;
    protected boolean isSuccess;
    protected AppError error;

    public Data(T data) {
        this.data = data;
        this.isSuccess = true;
    }

    public Data(AppError error) {
        this.error = error;
        this.isSuccess = false;
    }

    public Data(T data, int totalCount) {
        this(data);
        this.totalCount = totalCount;
    }
}
