# Documentação - AgendaSmile

## 1. Introdução

Este documento descreve o que foi implementado no projeto AgendaSmile, como executar o MVP e as instruções para testar as funcionalidades de cadastro de usuários e agendamentos.

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

1. **Clone o repositório** para a sua máquina:

   ```bash
   git clone <link-do-repositorio>
   ```

2. **Navegue até o diretório do projeto**:

   ```bash
   cd AgendaSmile-backend
   ```

3. **Crie o arquivo `.env`** com as variáveis de ambiente necessárias (se houver).

4. **Execute o Docker Compose** para subir os containers do back-end:

   ```bash
   docker-compose up --build
   ```

   Isso criará os containers e inicializará o servidor do back-end.

5. O back-end estará disponível na porta configurada (ex: `localhost:8080`).

## 4. Como Executar o Front-end

1. **Clone o repositório** para a sua máquina:

   ```bash
   git clone <link-do-repositorio>
   ```

2. **Navegue até o diretório do front-end**:

   ```bash
   cd AgendaSmile-frontend
   ```

3. **Abra o arquivo `index.html`** diretamente em seu navegador ou use uma ferramenta como o Live Server (VSCode) para testar a aplicação localmente.

## 5. Testando

Atualmente, o back-end e o front-end não estão integrados. Para testar o MVP:

- Utilize uma ferramenta como **Postman** ou **Insomnia** para enviar requisições para o back-end, simulando cadastros de usuários e agendamentos.
- Para testar a interface do front-end, abra o arquivo `index.html` e preencha os formulários, mas sem funcionalidade de envio, uma vez que a integração com o back-end ainda não foi concluída.

## 6. Próximos Passos

- Integração do front-end com o back-end via chamadas API para permitir que os dados de cadastro e agendamento sejam enviados diretamente para o back-end.



