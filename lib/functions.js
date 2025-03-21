function validateEmail(email) {
  const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return re.test(String(email).toLowerCase());
}

function deslogar() {
  const user = localStorage.getItem("user");

  if (user) {
    localStorage.removeItem("user");
    window.location = "/pages/login/index.html";
  }
}
