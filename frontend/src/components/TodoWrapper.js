import React from "react";
import TodoForm from "./TodoForm";
import { TodoList } from "./TodoList";

function TodoWrapper() {
  return (
    <div className="TodoWrapper">
      <TodoForm />
      <TodoList />
    </div>
  );
}

export default TodoWrapper;
