## Endpoints criados

Abaixo há todos os endpoints criados até o momento.

<h2><span style="color:green">POST</span> ```/api/office```</h2>
Cria um consultório e usuário administrador do respectivo consultório. É preciso enviar no body da requisição o seguinte JSON:

```json
{
  "name": <nome_consultório>,
  "admin": {
    "first_name": <nome_admin>,
    "last_name": <sobrenome_admin>,
    "email": <email_admin>,
    "password": <senha_admin>
  }
}
```
