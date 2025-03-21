const API_BASE_URL = "http://localhost:8080/api";

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

function retrieveLoggedUserData() {
  const userStoredData = localStorage.getItem('user');

  return JSON.parse(userStoredData);
}