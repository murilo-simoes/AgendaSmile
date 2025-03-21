function verificaSessaoLogada() {
  const user = localStorage.getItem("user");

  if (user) {
    window.location.href = "../../index.html";
  }
}

async function cadastrar() {
  const firstname = document.getElementById("firstname").value;
  const lastname = document.getElementById("lastname").value;
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;
  const confirmpassword = document.getElementById("confirmpassword").value;
  const office = document.getElementById("office").value;

  if (
    firstname.trim() === "" ||
    lastname.trim() === "" ||
    email.trim() === "" ||
    password.trim() === "" ||
    office.trim() === ""
  ) {
    alert("Preencha todos os campos corretamente!");
    return;
  }

  if (!validateEmail(email)) {
    alert("Email inválido!");
    return;
  }

  if (password != confirmpassword) {
    alert("As senhas não coincidem!");
    return;
  }

  const email_exist = await fetch(`http://localhost:8080/api/user/${email}`, {
    method: "POST",
  });

  if (await email_exist.json()) {
    alert("Já existe um usuário cadastrado com esse email!");
    return;
  }

  const body = {
    name: office.trim(),
    admin: {
      first_name: firstname.trim(),
      last_name: lastname.trim(),
      email: email.trim(),
      password: password.trim(),
    },
  };

  try {
    await fetch("http://localhost:8080/api/office", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    });
    alert("Usuário criado com sucesso!");

    window.location.href = "../login/index.html";
  } catch (err) {
    alert(err);
  }
}

verificaSessaoLogada();
