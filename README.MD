# Documentação - AgendaSmile

## 1. Introdução

Este documento descreve o que foi implementado no projeto AgendaSmile, como executar o software e as instruções para testar as funcionalidades de cadastro de usuários e agendamentos.

## 2. Implementações

### 2.1. Back-end

- **Tecnologia**: Java/SpringBoot com Docker
- **Funcionalidades Implementadas**:
  - Cadastro de usuários (clínicas odontológicas, dentistas e pacientes);
  - Agendamento de consultas.

O back-end foi containerizado usando Docker para facilitar a execução e a portabilidade entre ambientes. No momento, as funcionalidades de cadastro e agendamento estão operacionais via API.

### 2.2. Front-end

- **Tecnologia**: HTML, CSS e JavaScript
- **Funcionalidades Implementadas**:
  - Formulário para cadastro de usuários;
  - Formulário para agendamento de consultas.

O front-end foi desenvolvido como uma interface simples, responsiva e fácil de usar, permitindo que o usuário preencha as informações necessárias para realizar o cadastro e o agendamento de consultas.

## 3. Como Executar o Back-end (Java com Docker)

Caso queira simplicidade, apenas entre no link do deploy da aplicação e use normalmente.

Caso queria executar localmente, siga os seguintes passos:

1. **Clone o repositório** para a sua máquina:

   ```bash
   git clone https://github.com/murilo-simoes/AgendaSmile.git
   ```

2. **Execute o Docker Compose** para subir os containers do back-end:

   ```bash
   docker-compose up --build
   ```
3. Verifique se ambos os containers estão rodando corretamente no Docker

  - mysql 
  - spring_app 

   Isso criará os containers e inicializará o servidor do back-end.

4. O back-end estará disponível na porta configurada (ex: `localhost:8080`).

## 4. Como Executar o Front-end

1. **Abra o arquivo `index.html`** diretamente em seu navegador ou use uma ferramenta como o Live Server (VSCode) para testar a aplicação localmente.
