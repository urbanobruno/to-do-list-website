package com.labdessoft.roteiro01.service;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;
import com.labdessoft.roteiro01.entity.Task;

import com.labdessoft.roteiro01.repository.TaskRepository;

import io.swagger.v3.oas.annotations.Operation;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    @Operation(summary = "Lista todas as tarefas da lista")
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Operation(summary = "Cria uma nova tarefa")
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Operation(summary = "Marca uma tarefa como concluída")
    public Task marcarTarefaComoConcluida(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o ID: " + id));
        task.setCompleted(true);
        return taskRepository.save(task);
    }

    // Metodo marcar como concluida

    @Operation(summary = "Deleta a tarefa de acordo com o ID passado")
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}