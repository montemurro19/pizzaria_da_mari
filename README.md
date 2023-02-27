# Pizzaria da Mari

    API da aplicação de gerenciamento dos pedidos da pizzaria da mari.

## Endpoints

    - Pedidos
        - Fazer pedido
        - Filtros
            - Concluido, Em andamento, Saiu p/ Entrega
    - Cliente
        - [Cadastrar cliente](#cadastrar-cliente)
        - Alterar dados do cliente


    - Login
    - Gerenciamento pizzaria
        - Informaçoes do Pedido
            - Status de Preparação
    


### Cadastrar cliente

`POST` /pizzaria_da_mari/api/cadastro
| campo | tipo | obrigatório | descrição
|-------|------|:-----------:|------
| email | texto | sim | email do cliente
| senha | texto | sim | senha criada pelo usuário
| telefone | texto | sim | telefone do cliente 