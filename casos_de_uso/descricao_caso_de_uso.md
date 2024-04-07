# DESCRIÇÃO DO CASO E USO

### Caso de Uso - 01: Listar Tarefas
Permite a visualização de todas as tarefas salvas no sistema, que pertencem ao usuário.

### Caso de Uso - 02: Criar Tarefa
Permite a criação de tarefas pelo usuário. Ao fornecer os dados necessários a tarefa é criada e armazenada no sistema.

### Caso de Uso – 03: Excluir Tarefa 
Permite ao usuário excluir uma tarefa. O sistema exclui a tarefa do banco de dados. 

### Caso de Uso – 04: Marcar Tarefa como Concluída 
Permite ao usuário alterar o status de uma tarefa ainda não concluída para “Concluída”

# FLUXOS PRINCIPAIS

### Caso de Uso 01 - Listar tarefas

ID   Passo

1    O caso de uso se inicia quando o usuário gostaria de visualizar suas tarefas
2    O usuário solicita suas tarefas;
3    O sistema mostra as tarefas do usuário
4    O caso de uso é encerrado

### Caso de Uso 02 - Criar Tarefa

ID   Passo
1    O caso de uso se inicia quando o usuário gostaria de criar uma tarefa
2    O usuário registra as informações da tarefa no sistema
3    O sistema verifica se há algum erro nos dados cadastrados
4    O sistema cadastra a tarefa no sistema
5    O sistema exibe a nova tarefa na tela
6    O caso de uso é encerrado

### Caso de Uso 03 - Excluir tarefas

ID   Passo

1    O caso de uso se inicia quando o usuário gostaria de excluir uma tarefa
2    O usuário, na tarefa que deseja excluir, marca a opção de “Excluir”
3    O sistema deleta a tarefa do sistema/banco de dados
4    O caso de uso é encerrado

### Caso de Uso 04 - Marcar tarefa como concluída

ID   Passo

1    O caso de uso se inicia quando o usuáriogostaria de concluir uma tarefa
2    O usuário, na tarefa que deseja excluir, marca a opção de “Concluir”
3    O sistema muda o status da tarefa
4    O caso de uso é encerrado


# FLUXOS ALTERNATIVOS E EXCEÇÕES 

Fluxo Alternativo - Tarefa sem nome

ID   Passo

1    O caso de uso se inicia quando o usuário no passo 3 do fluxo principal do caso de uso 02.
2    O sistema identifica que a tarefa sendo criada está sem nome
3    O sistema mostra um alerta alertando sobre o problema
4    O fluxo é encerrado

# PÓS-CONDIÇÃO OU RESULTADO ESPERADO

### Caso de Uso 01: 
Tarefas do usuário, armazenadas no banco de dados. são exibidas na lista de tarefas.

### Caso de Uso 02: 
Tarefas registradas estão no banco de dados.

### Caso de Uso 03: 
Tarefas excluídas não estão no banco de dados.

### Caso de Uso 04:
Status da tarefa selecionada alterado para “Concluída”.


