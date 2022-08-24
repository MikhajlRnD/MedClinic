package service;

import model.LogOperation;

public interface LogService<T> {

    void log(LogOperation operation, T card);


}
