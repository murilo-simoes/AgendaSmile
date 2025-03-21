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

  try {
    await fetch("http://localhost:8080/api/office", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        name: office,
        admin: {
          first_name: firstname,
          last_name: lastname,
          email: email,
          password: password,
        },
      }),
    });
    alert("Usuário criado com sucesso!");

    window.location.href = "../login/index.html";
  } catch (err) {
    alert(err);
  }
}

function validateEmail(email) {
  const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return re.test(String(email).toLowerCase());
}
