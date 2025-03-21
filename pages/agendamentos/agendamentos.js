async function carregarAgendamentos() {
  const user = JSON.parse(localStorage.getItem("user"));

  const response = await fetch(
    `http://localhost:8080/api/appointment/office/${user.office.id}`,
    {
      method: "GET",
    }
  );

  const appointments = await response.json();

  let table = '<table id="medicosTable">';
  table += `
  <thead>
              <tr>
                <th>Consultorio</th>
                <th>Paciente</th>
                <th>Procedimento</th>
                <th>Médico</th>
                <th>Data</th>
                <th>Horário de Inicio</th>
                <th>Horário de Fim</th>
              </tr>
            </thead>
            <tbody>
  `;

  appointments.forEach((element, index) => {
    table = table + `<tr>`;
    table = table + `<td>${element.office.name}</td>`;
    table =
      table +
      `<td>${
        element.patient.first_name + " " + element.patient.last_name
      }</td>`;
    table = table + `<td>${element.appointment_type}</td>`;
    table = table + `<td>${element.user.first_name}</td>`;
    table = table + `<td>${formatTimestampToDate(element.start_time)}</td>`;
    table = table + `<td>${formatTimestampToTime(element.start_time)}</td>`;
    table = table + `<td>${formatTimestampToTime(element.end_time)}</td>`;
    table += `</tr>`;
  });
  table += "</tbody></table>";
  document.getElementById("table-container").innerHTML = table;
}

function formatTimestampToDate(timestamp) {
  const date = new Date(timestamp);

  const day = String(date.getDate()).padStart(2, "0");
  const month = String(date.getMonth() + 1).padStart(2, "0");
  const year = date.getFullYear();

  return `${day}/${month}/${year}`;
}

function formatTimestampToTime(timestamp) {
  const date = new Date(timestamp);
  const hours = String(date.getHours()).padStart(2, "0");
  const minutes = String(date.getMinutes()).padStart(2, "0");
  const seconds = String(date.getSeconds()).padStart(2, "0");

  return `${hours}:${minutes}:${seconds}`;
}

carregarAgendamentos();
