function verificaSessao() {
  const user = JSON.parse(localStorage.getItem("user"));

  if (!user) {
    window.location = "/pages/login/index.html";
  }
}

async function criarAgendamento() {
  let user = JSON.parse(localStorage.getItem("user"));

  const email_paciente = document.getElementById("email").value;
  const data_consulta = document.getElementById("idate").value;
  const hora_consulta = document.getElementById("hora_consulta").value;
  const procedimento = document.getElementById("procedimento").value;

  if (
    email_paciente === "" ||
    data_consulta === "" ||
    hora_consulta === "" ||
    procedimento === ""
  ) {
    alert("Preencha todos os campos corretamente.");
    return;
  }

  if (!validateEmail(email_paciente)) {
    alert("Email inválido!");
    return;
  }

  const data_consulta_inicio = formatDateWithTime(data_consulta);
  const data_consulta_fim = addOneHourToDate(data_consulta);

  const body = {
    title: "Agendamento",
    description: "Sem detalhes",
    type: procedimento.trim(),
    start_datetime: data_consulta_inicio,
    end_datetime: data_consulta_fim,
  };

  await fetch(
    `https://3c71-2804-7f0-7f80-dba-5839-f953-62a9-c4a6.ngrok-free.app/api/appointment/doctor/${user.id}/patient/${email_paciente}`,
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    }
  )
    .then(({ status }) => {
      if (status >= 200 && status < 300) {
        alert("Agendamento criado com sucesso!");
        return;
      }

      alert("Erro ao criar o agendamento.");
    })
    .catch(() => {
      alert("Erro ao criar o agendamento.");
    });
}

document.addEventListener("DOMContentLoaded", function () {
  const page = document.body.getAttribute("data-page");
  const sideItems = document.querySelectorAll(".side-item");

  if (sideItems.length > 0) {
    sideItems.forEach((item) => {
      item.classList.remove("active");
    });

    let activeItem = null;

    switch (page) {
      case "agendar":
        activeItem = document.querySelector('.side-item a[href="index.html"]');
        break;
      case "medicos":
        activeItem = document.querySelector(
          '.side-item a[href="./medicos/medicos.html"]'
        );
        break;
      case "consultorios":
        activeItem = document.querySelector(
          '.side-item a[href="/consultorios.html"]'
        );
        break;
    }

    if (activeItem && activeItem.parentElement) {
      activeItem.parentElement.classList.add("active");
    }
  }

  const openBtn = document.getElementById("open-btn");
  if (openBtn) {
    openBtn.addEventListener("click", function () {
      const sidebar = document.getElementById("sidebar");
      if (sidebar) {
        sidebar.classList.toggle("open-sidebar");
      }
    });
  }

  const hoje = new Date();
  const dataHoje = hoje.toISOString().split("T")[0];
  const dataLimite = new Date(hoje);
  dataLimite.setMonth(hoje.getMonth() + 1);
  const dataLimiteString = dataLimite.toISOString().split("T")[0];
  const inputData = document.getElementById("idate");

  if (inputData) {
    inputData.setAttribute("min", dataHoje);
    inputData.setAttribute("max", dataLimiteString);
  }
});

function formatDateWithTime(dateString) {
  const date = new Date(dateString);

  const formattedDate =
    `${date.getFullYear()}-${(date.getMonth() + 1)
      .toString()
      .padStart(2, "0")}-${date.getDate().toString().padStart(2, "0")} ` +
    `${date.getHours().toString().padStart(2, "0")}:${date
      .getMinutes()
      .toString()
      .padStart(2, "0")}:${date.getSeconds().toString().padStart(2, "0")}` +
    `.000000`;

  return formattedDate;
}

function addOneHourToDate(dateString) {
  const date = new Date(dateString);
  date.setHours(date.getHours() + 1);

  const formattedDateWithAddedHour =
    `${date.getFullYear()}-${(date.getMonth() + 1)
      .toString()
      .padStart(2, "0")}-${date.getDate().toString().padStart(2, "0")} ` +
    `${date.getHours().toString().padStart(2, "0")}:${date
      .getMinutes()
      .toString()
      .padStart(2, "0")}:${date.getSeconds().toString().padStart(2, "0")}` +
    `.000000`;

  return formattedDateWithAddedHour;
}

function nomeMenu() {
  const user = JSON.parse(localStorage.getItem("user"));

  if (user) {
    document.getElementById("name_menu").innerText = user.first_name;
    document.getElementById("last_name_menu").innerText = user.last_name;
  }
}
nomeMenu();
verificaSessao();
