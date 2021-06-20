// Превращаем объект юзера в его строку в таблице
function jsonToRow(jsonObject) {

    let newRow =
        "<tr id='tr"+jsonObject.id+"'>" +
        "<td>" + jsonObject.id + "</td>" +
        "<td>" + jsonObject.firstName + "</td>" +
        "<td>" + jsonObject.lastName + "</td>" +
        "<td>" + jsonObject.age + "</td>" +
        "<td>" + jsonObject.username + "</td>" +
        "<td>" + rolesToString(jsonObject.roles) + "</td>" +
        "<td><button class='btn btn-info eBtn' data-toggle='modal' onclick='editUserModal("+jsonObject.id+")'>Edit</button></td>" +
        "<td><button class='btn btn-danger eBtn' data-toggle='modal' onclick='deleteUserModal("+jsonObject.id+")' id='deleteButton'>Delete</button></td>"+
        "</tr>";
    return newRow;
}

// Заполнение таблицы пользователей
// json object -> html-блок -> в переменную usersTable
function fetchUsersToTable(data) {
    usersTable = document.getElementById("allUsersTableFetch")
    data.forEach((dataItem) => {
        usersTable.insertAdjacentHTML('beforeend', jsonToRow(dataItem))
        // usersTable.append(jsonToRow(dataItem))
    })
}

// Пользовательская панель: наполняем таблицу текущего пользователя (себя)
function fetchYourselfToTable(data) {
    singleUserTable = document.getElementById("singleUserTableFetch")
    singleUserTable.innerHTML = ''
    let userRow = document.createElement("tr");
    userRow.innerHTML =
        "<td>" + data.id + "</td>" +
        "<td>" + data.firstName + "</td>" +
        "<td>" + data.lastName + "</td>" +
        "<td>" + data.age + "</td>" +
        "<td>" + data.username + "</td>" +
        "<td>" + rolesToString(data.roles) + "</td>";
    singleUserTable.append(userRow)
}

// Запуск и получение нужных ресурсов
function onStartup() {
    $(document).ready(
        () => {
            // Все пользователи с сервера
            // json object -> пихаем в метод заполнения таблицы пользователей
            sendGet(requestURL).then(response => fetchUsersToTable(response))
            // Текущий пользователь с сервера
            // json object
            sendGet(requestURL + 'current').then(response => fetchYourselfToTable(response))
            // Все возможные роли с сервера
            // json object -> в переменную roles
            sendGet(requestURL + 'roles').then(data => {
                roles = data
            })
            // Все возможные роли с сервера
            // html-блок из option-ов -> в переменную roleOptions
            roleOptions = '';
            sendGet(requestURL + 'roles').then(response => {
                response.forEach((role) => {
                    roleOptions += "<option id="
                    roleOptions += role.id
                    roleOptions += " class=\"optionItem"
                    roleOptions += role.id
                    roleOptions += "\">"
                    roleOptions += role.name
                    roleOptions += "</option>"
                })
            })
            // Отрисовка и заполнение статус-бара
            sendGet(requestURL + 'current').then(response => {
                let headerInfoLine = document.getElementById("headerInfoLine");
                headerInfoLine.innerHTML = ''
                let headerBlock = document.createElement("div")
                headerBlock.className = "row"
                headerBlock.innerHTML =
                    "<div class='col-md-9 text-left bg-dark text-light align-middle pt-2'>" + response.username + ' with roles: ' + rolesToString(response.roles) + "</div>" +
                    "<div class='col-md-3 text-right bg-dark'><form method='POST' action='/logout'><button class='btn btn-link text-muted text-decoration-none' type='submit'>Logout</button></form></div>";
                headerInfoLine.append(headerBlock)
            })
        })
}

onStartup()