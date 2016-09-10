package com.example.praveenax.myapplication;

/**
 * Created by Praveenax on 9/11/2016.
 */
public class TaskItem {

    int _id;
    String _task_name;
    boolean _task_is_complete;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_task_name() {
        return _task_name;
    }

    public void set_task_name(String _task_name) {
        this._task_name = _task_name;
    }

    public boolean is_task_is_complete() {
        return _task_is_complete;
    }

    public void set_task_is_complete(boolean _task_is_complete) {
        this._task_is_complete = _task_is_complete;
    }
}
