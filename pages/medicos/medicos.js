const searchBtn = document.querySelector("#search-btn");
const searchInput = document.querySelector(".search-input");
const allDentists = [];
const dataTableContentContainer = document.querySelector('.datatable-content');

fetchAllDentists().then(async response => {
    const dentists = await response.json();
    allDentists.push(...dentists);
    updateDataTableData(allDentists);
}).catch(() => {
    window.alert('Não foi possível obter os dentistas. Tente novamente mais tarde!');
});

searchBtn.addEventListener('click', async e => {
    e.preventDefault();

    const filterValue = searchInput.value;
    
    const filteredDentists = filterDentists(allDentists, filterValue);
    console.log(filteredDentists);
    updateDataTableData(filteredDentists)
});

function fetchAllDentists() {
    return new Promise((resolve, reject) => {
        const { office } = retrieveLoggedUserData();
        
        fetch(`${API_BASE_URL}/office/${office.id}/dentist`, {
            method: 'GET'
        }).then(response => {
            resolve(response);
        }).catch(error => {
            reject(error);
        });
    });
}

async function updateDataTableData(dataTableData) {
    clearDataTableRows().then(() => {
        const rows = [];
    
        dataTableData.forEach(dentistRow => {
            const row = document.createElement('tr');
            columnOrderProperties = ['first_name', 'last_name', 'email', 'created_at'];
    
            for (const column of columnOrderProperties) {
                const rowColumn = document.createElement('td');
                rowColumn.innerHTML = dentistRow[column];
                row.appendChild(rowColumn);
            }
            
            rows.push(row);
        });
        
        rows.forEach(row => {
            dataTableContentContainer.appendChild(row);
        });
    });
}

function filterDentists(dentistsArray, filterValue) {
    return dentistsArray.filter(dentist => {
        
        for (const data in dentist) {
            if (! dentist[data].match(`/*${filterValue}/*`)) {
                continue;
            }

            return true;
        }

        return false;
    });
}

function clearDataTableRows() {
    return new Promise((resolve) => {
        const rows = dataTableContentContainer.children;
    
        for (let i = rows.length - 1; i >= 0; i--) {
            rows.item(i).remove();
        }

        resolve();
    });
} 