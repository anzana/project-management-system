package com.example.projectmanagementsystem.service;

import com.example.projectmanagementsystem.entity.Task;
import com.example.projectmanagementsystem.entity.User;
import com.example.projectmanagementsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImplementation implements TaskService{
    @Autowired
    private TaskRepository taskRepo;

    @Override
    public Task addTask(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        List<Task> tasks = taskRepo.findAll();
        return tasks;
    }

    @Override
    public Task updateTask(int id, Task task) {
        Optional<Task> taskFromDb = taskRepo.findById(id);

        taskFromDb.map(u -> {
            u.setTitle(task.getTitle());
            u.setDescription(task.getDescription());
            u.setAssignee(task.getAssignee());
            u.setCreatedBy(task.getCreatedBy());
            u.setDueDate(task.getDueDate());
            u.setCreatedDate(task.getCreatedDate());
            return taskRepo.save(u);

        }).orElseGet(() ->  { return taskRepo.save(task); }
        );

        return task;
    }

    @Override
    public void deleteUser(int id) {
        taskRepo.deleteById(id);
    }
}
