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
    await fetch(`http://localhost:8080/api/office/${user.office.id}/patient`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    })
      .then((response) => {
        if (response.status === 200) {
          alert("Paciente criado com sucesso!");
        } else {
          alert("Erro ao criar o paciente.");
        }
      })
      .catch((err) => {
        alert("Erro ao criar o paciente.");
      });

    window.location = "../../index.html";
  } catch (err) {
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
nomeMenu();
