
# Projeto de API para barbearia decola tech 2025

Uma API de gerenciamento de clientes e seus agendamentos usanod java, spring boot, spring jpa e banco de dados local H2. \
O Projeto usa o CRUD básico com consultas personalizadas para poder cadastrar, atualizar e excluir clintes e fazer agendamentos com os dados dos clientes cadastrados.
## Documentação da API

A seguir está a lista de Endpoints que a API possui e uma breve descrição de suas funções e itens necessários para as requisições

### Endpoints de clientes

#### Retorna todos os clientes

```http
  GET /client
```

#### Retorna um cliente especifico

```http
  GET /client/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer |

#### Adiciona um cliente

```http
  POST /client
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome`      | `string` | **Obrigatório**. O nome do cliente |
| `email`      | `string` | **Obrigatório**. O email do cliente |
| `phone`      | `string` | **Obrigatório**. O numero de celular do cliente |

#### Atualiza as informações de um cliente

```http
  PUT /client/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do item que você quer |
| `nome`      | `string` | **Obrigatório**. O nome do cliente |
| `email`      | `string` | **Obrigatório**. O email do cliente |
| `phone`      | `string` | **Obrigatório**. O numero de celular do cliente |

#### exclui um cliente

```http
  DELETE /client/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer excluir |

### Endpoints de agendamento

#### Retorna todos os agendamentos naquele mês

```http
  GET /schedules/${year}/${month}
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `year`      | `int` | **Obrigatório**. O ano |
| `month`      | `int` | **Obrigatório**. O mês |

#### Adiciona um agendamento

```http
  POST /schedules
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `startAt`      | `Date` | **Obrigatório**. A data que começa a consulta (dia e horario) |
| `endAt`      | `Date` | **Obrigatório**. A data que a consulta termina (dia e horario) |
| `client`      | `client` | **Obrigatório**. Os dados do cliente |

#### exclui um agendamento

```http
  DELETE /schedules/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do agendamento que você quer excluir |
