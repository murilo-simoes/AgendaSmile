function verificaSessao() {
  const user = localStorage.getItem("user");

  if (!user) {
    window.location = "/pages/login/index.html";
  }
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

verificaSessao();
