const API_BASE_URL = "https://3c71-2804-7f0-7f80-dba-5839-f953-62a9-c4a6.ngrok-free.app/api";

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