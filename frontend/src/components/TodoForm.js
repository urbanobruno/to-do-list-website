import React from "react";

function TodoForm() {
  return (
    <form className="TodoForm">
      <input
        type="text"
        className="todo-input"
        placeholder="Qual sua nova tarefa?"
      />
      <button type="submit" className="todo-btn">
        +
      </button>
    </form>
  );
}

export default TodoForm;
