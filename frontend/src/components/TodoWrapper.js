import React from "react";
import TodoForm from "./TodoForm";
import { TodoList } from "./TodoList";

function TodoWrapper() {
  return (
    <div className="TodoWrapper">
      <h1>Lista de Tarefas</h1>
      <TodoForm />
      <TodoList />
    </div>
  );
}

export default TodoWrapper;
