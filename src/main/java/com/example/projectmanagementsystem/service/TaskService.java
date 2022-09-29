package com.example.projectmanagementsystem.service;

import com.example.projectmanagementsystem.entity.Task;
import com.example.projectmanagementsystem.entity.User;

import java.util.List;

public interface TaskService {
    Task addTask(Task task);
    List<Task> getAllTask();
    Task updateTask(int id, Task task);
    void deleteUser(int id);
}
