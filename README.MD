## Endpoints criados

Abaixo há todos os endpoints criados até o momento.

## POST ```/api/office```
Cria um consultório e usuário administrador do respectivo consultório. É preciso enviar no body da requisição o seguinte JSON:

```json
{
  "name": "<nome_consultório>",
  "admin": {
    "first_name": "<nome_admin>",
    "last_name": "<sobrenome_admin>",
    "email": "<email_admin>",
    "password": "<senha_admin>"
  }
}
```
