import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTrash } from "@fortawesome/free-solid-svg-icons";
// import { faTrash, faPenToSquare } from "@fortawesome/free-solid-svg-icons";
import './TodoList.css'; 

export const TodoList = ({ tarefas, setTarefas }) => {
  const handleExcluirTarefa = async (id) => {
    try {
      const response = await fetch(`http://localhost:8080/api/task/${id}`, {
        method: "DELETE",
      });
      if (response.ok) {
        console.log("Tarefa deletada");
        setTarefas(tarefas.filter((tarefa) => tarefa.id !== id));
      } else {
        console.error("Erro ao deletar a tarefa:", response.statusText);
      }
    } catch (error) {
      console.error("Erro ao deletar a tarefa:", error);
    }
  };

  // const handleMarcarConcluidaTarefa = async (id) => {
  //   try {
  //     const response = await fetch(`http://localhost:8080/api/task/${id}`, {
  //       method: "PATCH",
  //     });
  //     if (response.ok) {
  //       const updatedTask = await response.json();
  //       setTarefas(tarefas.map((tarefa) => 
  //         tarefa.id === id ? { ...tarefa, completed: updatedTask.completed } : tarefa
  //       ));
  //     } else {
  //       console.error("Erro ao marcar a tarefa como concluída:", response.statusText);
  //     }
  //   } catch (error) {
  //     console.error("Erro ao marcar a tarefa como concluída:", error);
  //   }
  // };

  return (
    <div className="tarefa-list-card">
      <h2>Suas Tarefas</h2>
      <ul>
        {tarefas.map((tarefa) => (
          <li key={tarefa.id} className="tarefa-item margin-fix ${tarefa.completed ? 'completed' : ''}">
            <span >{tarefa.description}</span>
{/* 
            <button onClick={() => handleMarcarConcluidaTarefa(tarefa.id)}>
                <FontAwesomeIcon className="edit-icon" icon={faPenToSquare} />
            </button>
 */}


            <button onClick={() => handleExcluirTarefa(tarefa.id)}>
              <FontAwesomeIcon icon={faTrash} />
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
};
