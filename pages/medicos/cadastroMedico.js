const createDentistForm = document.querySelector('#create-dentist-form');

createDentistForm.addEventListener('submit', e => {
    e.preventDefault();

    const formData = new FormData(createDentistForm);
    const requestBody = createJsonWithFormFields(formData);
    const { office } = retrieveLoggedUserData();
    const jsonRequestBody = JSON.stringify(requestBody);

    sendData(
        `${API_BASE_URL}/office/${office.id}/dentist`,
        jsonRequestBody
    ).then(({ status }) => {
        if (status >= 200 && status < 300) {
            window.alert('Usuário criado com sucesso!');
            return;
        }

        window.alert('Não foi possível criar o usuário!');
    })
});

function createJsonWithFormFields(formData) {
    const json = {};

    formData.forEach((value, key) => {
        json[key] = value;
    });

    return json;
}

function sendData(endpoint, bodyData) {
    return new Promise((resolve, reject) => {
        fetch(endpoint, {
            method: 'POST',
            body: bodyData,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            resolve(response);
        }).catch(error => {
            reject(error);
        });
    });
}