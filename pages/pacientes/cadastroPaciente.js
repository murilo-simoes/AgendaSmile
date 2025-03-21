async function cadastrarPaciente() {
  const user = localStorage.getItem("user");

  console.log(user.office_id);
  return;

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

  try {
    await fetch(`http://localhost:8080/api/office/${user.office_id}/patient`);
  } catch (err) {
    alert("Não foi possivel incluir um novo paciente.");
  }
}
