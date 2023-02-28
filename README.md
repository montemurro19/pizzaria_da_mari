# Pizzaria da Mari

    API da aplicação de gerenciamento dos pedidos da pizzaria da mari.

## Endpoints

    - Cliente
        - Cadastrar cliente

    - Perfil
        -Editar Perfil
    
    -Dashbord
        -Adicionar Produto


### Cadastrar cliente 👇

`POST` /pizzaria_da_mari/api/cadastro
| campo | tipo | obrigatório | descrição
|-------|------|:-----------:|------
| email | texto | sim | email do cliente
| senha | texto | sim | senha criada pelo usuário
| telefone | texto | sim | telefone do cliente
| CPF | texto | sim | cpf do cliente

### Corpo de requisição
```js
{
    "email":vitorio@uol.com.br ,
    "senha":Oito@ ,
    "telefone":11 9 74512645,
    "cpf"984.906.590-79, 
}
```

### Editar Perfil 👇

`POST` /pizzaria_da_mari/api/editarperfil

| campo | tipo | descrição
|-------|------|------
| email | texto| email do cliente
| senha | texto| senha criada pelo usuário
| telefone|texto| telefone do cliente
| CPF | texto | cpf do cliente

### Corpo de requisição
```js
{
    "email": ,
    "senha": ,
    "telefone":11 9 74512645 -> 11 9 85623756,
    "cpf", 
}
```
### Adicionar Produto 👇

| campo | tipo | obrigatório | descrição
|-------|------|:-----------:|------
|Produto| texto | sim | nome do produto
|Descricao| texto | sim | descrição do produto
|Preço  | texto | sim | preço do produto

### Corpo de requisição
```js
{
    "Produto": Pizza de Musssarela,
    "Descricao": pizza mussarela, com tomate, cebola,
    "Preco":80

}