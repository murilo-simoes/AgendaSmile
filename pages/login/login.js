function verificaSessaoLogada() {
  const user = localStorage.getItem("user");

  if (user) {
    window.location.href = "../../index.html";
  }
}

function exibirSenha() {
  const exibir_senha = document.getElementById("exibir_senha").checked;
  const password = document.getElementById("password");

  password.type = exibir_senha ? "text" : "password";
}

async function login() {
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  if (email.trim() == "" || password.trim() == "") {
    alert("Preencha todos os campos corretamente!");
    return;
  }

  if (!validateEmail(email)) {
    alert("Email inválido!");
    return;
  }

  const body = {
    email: email.trim(),
    password: password.trim(),
  };

  try {
    let response = await fetch(`${API_BASE_URL}/api/user/login`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    });

    const user = await response.json();

    alert("Login realizado com sucesso.");

    localStorage.setItem("user", JSON.stringify(user));

    window.location = "../../index.html";

    return;
  } catch (err) {
    alert(
      "Erro ao realizar o login, verefique as credenciais e tente novamente."
    );
    return;
  }
}

verificaSessaoLogada();
