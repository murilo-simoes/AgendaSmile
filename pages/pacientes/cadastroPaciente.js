async function cadastrarPaciente() {
  const user = JSON.parse(localStorage.getItem("user"));

  const nome = document.getElementById("nome").value;
  const sobrenome = document.getElementById("sobrenome").value;
  const email = document.getElementById("email").value;
  const data = document.getElementById("data").value;
  const cpf = document.getElementById("cpf").value;
  const numero = document.getElementById("numero").value;
  const genero = document.getElementById("genero").value;
  console.log(data);
  return;
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
    birth_date: birth_date.trim(),
  };

  try {
    await fetch(`http://localhost:8080/api/office/${user.office.id}/patient`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: body,
    });
  } catch (err) {
    alert("Não foi possivel incluir um novo paciente.");
  }
}
