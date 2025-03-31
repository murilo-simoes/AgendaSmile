async function cadastrarPaciente() {
  const user = JSON.parse(localStorage.getItem("user"));

  const nome = document.getElementById("nome").value;
  const sobrenome = document.getElementById("sobrenome").value;
  const email = document.getElementById("email").value;
  const data = document.getElementById("data").value;
  const cpf = document.getElementById("cpf").value;
  const numero = document.getElementById("numero").value;
  const genero = document.getElementById("genero").value;

  if (
    nome === "" ||
    sobrenome === "" ||
    email === "" ||
    data === "" ||
    cpf === "" ||
    numero === "" ||
    genero === ""
  ) {
    alert("Preencha todos os campos corretamente.");
    return;
  }

  if (!validateEmail(email)) {
    alert("Email inválido!");
    return;
  }

  if (!validarCPF(cpf)) {
    alert("CPF inválido!");
    return;
  }

  const body = {
    first_name: nome.trim(),
    last_name: sobrenome.trim(),
    cpf: cpf.trim(),
    birth_date: data.trim(),
    gender: genero.trim(),
    phone_number: numero.trim(),
    email: email.trim(),
    obs: "Sem observações",
  };

  try {
    await fetch(`${API_BASE_URL}/api/office/${user.office.id}/patient`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    })
      .then(({ status }) => {
        if (status >= 200 && status < 300) {
          alert("Usuário criado com sucesso!");
          window.location = "../../index.html";
          return;
        }
        alert("Erro ao criar o paciente");
        return;
      })
      .catch((err) => {
        console.log(err);
        alert("Erro ao criar o paciente.");
        return;
      });
  } catch (err) {
    console.log(err);
    alert("Não foi possivel incluir um novo paciente.");
  }
}

function nomeMenu() {
  const user = JSON.parse(localStorage.getItem("user"));

  if (user) {
    document.getElementById("name_menu").innerText = user.first_name;
    document.getElementById("last_name_menu").innerText = user.last_name;
  }
}

function validarCPF(cpf) {
  // Remove caracteres especiais (pontos e traços)
  cpf = cpf.replace(/[^\d]+/g, "");

  // Verifica se o CPF tem 11 dígitos
  if (cpf.length !== 11) return false;

  // Verifica se todos os dígitos são iguais (ex: "111.111.111-11")
  if (/^(\d)\1+$/.test(cpf)) return false;

  // Validação do primeiro dígito verificador
  let soma = 0;
  for (let i = 0; i < 9; i++) {
    soma += parseInt(cpf.charAt(i)) * (10 - i);
  }
  let resto = (soma * 10) % 11;
  if (resto === 10 || resto === 11) resto = 0;
  if (resto !== parseInt(cpf.charAt(9))) return false;

  // Validação do segundo dígito verificador
  soma = 0;
  for (let i = 0; i < 10; i++) {
    soma += parseInt(cpf.charAt(i)) * (11 - i);
  }
  resto = (soma * 10) % 11;
  if (resto === 10 || resto === 11) resto = 0;
  if (resto !== parseInt(cpf.charAt(10))) return false;

  return true;
}
nomeMenu();
