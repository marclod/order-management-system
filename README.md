# Escolha da Estrutura de Dados para o Sistema de Gerenciamento de Pedidos

## Introdução
O sistema de gerenciamento de pedidos de uma cafeteria deve ser capaz de lidar com diferentes tipos de pedidos, atribuir prioridades, cancelar e visualizar pedidos, mantendo a ordem de processamento correta. Para garantir um desempenho eficiente e atender às regras de negócio, a escolha adequada da estrutura de dados é crucial.

## Requisitos do Problema
Os requisitos principais que o sistema precisa atender são:

- Adicionar novos pedidos em tempo real.
- Processar pedidos na ordem de chegada, exceto para clientes VIP, que têm prioridade.
- Permitir a visualização dos pedidos em espera, sem removê-los.
- Cancelar pedidos quando necessário.
- Atualizar a prioridade de pedidos já inseridos.

## Estruturas de Dados Consideradas

### Lista Simplesmente Encadeada (LinkedList)
- **Prós**: Fácil inserção e remoção de elementos em qualquer posição.
- **Contras**: Não suporta prioridade nativa; busca e remoção são lineares, resultando em baixa eficiência ao lidar com prioridades.

### Fila (Queue)
- **Prós**: Ideal para processamento em ordem de chegada (FIFO).
- **Contras**: Não oferece suporte a prioridade diretamente, sendo ineficaz para pedidos VIP.

### Fila de Prioridade (PriorityQueue)
- **Prós**: Suporta diretamente o conceito de prioridade, processando pedidos VIP antes dos normais. Mantém os elementos ordenados de acordo com sua prioridade e, dentro da mesma prioridade, mantém a ordem de inserção.
- **Contras**: Não permite fácil atualização de elementos já inseridos, sendo necessário remover e reinserir o elemento ao atualizar sua prioridade.

### Mapa (HashMap)
- **Prós**: Ideal para armazenamento e recuperação rápida de pedidos por ID, o que facilita operações como cancelamento e atualização de prioridade.
- **Contras**: Não mantém a ordem de inserção nem oferece suporte direto à prioridade. Deve ser combinado com outra estrutura.

## Estrutura Escolhida: PriorityQueue + HashMap
Optou-se por uma combinação de **PriorityQueue** e **HashMap** para implementar o sistema, com base nos seguintes motivos:

### Gerenciamento de Prioridade
A estrutura de dados principal usada para organizar os pedidos é a `PriorityQueue`, que permite o processamento de pedidos VIP com prioridade, seguido pela ordem de chegada dos pedidos não VIP. Ela garante que o pedido com maior prioridade (VIP) sempre seja processado antes dos outros, e os pedidos com a mesma prioridade (não VIP) são processados em ordem de chegada.

### Cancelamento e Atualização Rápida
O `HashMap` é usado para armazenar os pedidos associados aos seus respectivos IDs, permitindo acesso rápido para cancelamento ou atualização da prioridade. Embora a `PriorityQueue` não ofereça um método direto para atualizar um elemento, o uso do `HashMap` permite localizar e remover um pedido específico para então reinseri-lo na fila com a nova prioridade.

### Eficiência
A `PriorityQueue` tem complexidade de inserção e remoção de **O(log n)**, o que é aceitável para este cenário onde pedidos estão constantemente sendo adicionados e processados. O `HashMap`, por outro lado, oferece acesso, inserção e remoção em tempo constante **O(1)** para operações baseadas no ID do pedido.

## Justificativa de Escolha
A combinação de **PriorityQueue** e **HashMap** foi escolhida por atender a todos os requisitos do sistema de forma eficiente:

- **Inserção de pedidos**: A `PriorityQueue` permite a inserção dos pedidos respeitando a prioridade de clientes VIP, enquanto a inserção no `HashMap` garante acesso rápido ao pedido via seu ID.

- **Processamento de pedidos**: A `PriorityQueue` sempre retorna o pedido de maior prioridade (VIP) ou o pedido mais antigo entre os que têm a mesma prioridade, mantendo a lógica de processamento correta.

- **Visualização de pedidos**: Como a fila é mantida na `PriorityQueue`, é fácil visualizar os pedidos em espera, sem precisar removê-los, através de uma simples cópia da fila.

- **Cancelamento e atualização de prioridade**: O uso do `HashMap` garante que os pedidos possam ser localizados de maneira eficiente, permitindo remover ou atualizar a prioridade de um pedido sem comprometer a performance.

## Conclusão
A estrutura de dados escolhida (combinação de **PriorityQueue** e **HashMap**) oferece um equilíbrio eficiente entre complexidade de inserção, remoção, busca e priorização de pedidos. Ela atende de maneira robusta às regras de negócio da cafeteria, garantindo que os pedidos VIP sejam processados primeiro, mantendo a ordem de chegada dos pedidos regulares, além de permitir operações como cancelamento e atualização de forma eficiente.
