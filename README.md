# Justificativa da Estrutura de Dados

## Introdução
Para o sistema de gerenciamento de pedidos da cafeteria, foi escolhido uma **fila baseada em arrays**, priorizando VIPs por ordem de chegada. Essa estrutura atende às necessidades de simplicidade, desempenho e controle de prioridade.

## Análise e Justificativa

### Vantagens
- **Simplicidade**: Arrays são diretos e fáceis de implementar, ideais para um número moderado de pedidos.
- **Controle de Prioridade**: A lógica do array permite regras claras para priorizar VIPs sem complexidade extra.
- **Eficiência**: Operações de inserção e remoção são rápidas e suficientes para o tamanho moderado da fila.

### Limitações
Embora seja necessário reordenar manualmente após algumas operações, a simplicidade e o controle direto tornam o array uma escolha eficaz para o cenário da cafeteria.
