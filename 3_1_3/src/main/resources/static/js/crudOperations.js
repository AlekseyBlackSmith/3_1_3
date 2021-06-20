// Админ панель: модальное окно удаления пользователя - список ролей юзера
function rolesToString(roles) {
    let rolesAsString = '';
    roles.forEach((singleRole) => {
        rolesAsString += singleRole.name + " ";
    })
    return rolesAsString;
}

// Админ панель: модальное окно создания пользователя
function newUserModal() {
    $("#newUserModal").modal('show')
    let roleSelector = document.getElementById("newModalRoleSelector")
    roleSelector.innerHTML = roleOptions
}

// Создаём пользователя
function newUser() {
    let rolesArray = []
    let allOptions = document.getElementById("newModalRoleSelector").options
    let body = {}
    for (let i = 0; i < allOptions.length; i++) {
        if (allOptions[i].selected) {
            rolesArray.push({
                id: allOptions[i].id,
                name: allOptions[i].value
            })
        }
    }
    body = {
        firstName: $("#newUserFirstName").val(),
        lastName: $("#newUserLastName").val(),
        age: $("#newUserAge").val(),
        username: $("#newUserEmail").val(),
        password: $("#newUserPassword").val(),
        roles: rolesArray
    }
    sendPost(requestURL, body)
        .then(() => {
            document.getElementById("allUsersTableFetch").innerHTML = ''
            onStartup()
        })
        .then(clearNewUserForms())

}

// Чистим поля модальное окна создания пользователя
function clearNewUserForms() {
    $("#newUserFirstName").val("");
    $("#newUserLastName").val("");
    $("#newUserAge").val("");
    $("#newUserEmail").val("");
    $("#newUserPassword").val("");
}

// Админ панель: модальное окно редактирования пользователя
function editUserModal(userId) {
    $("#editUserModal").modal('show');
    sendGet(requestURL + userId)
        .then(response => {
            return response;
        })
        .then(response => {
                $("#editId").val(response.id)
                $("#editFirstName").val(response.firstName)
                $("#editLastName").val(response.lastName)
                $("#editAge").val(response.age)
                $("#editEmail").val(response.username)
                $("#editPassword").val(response.password)
                let roleSelector = document.getElementById("editModalRoleSelector")
                roleSelector.innerHTML = roleOptions
            }
        )
}

// Редактируем пользователя
function editUser() {
    let rolesArray = []
    let body = {}
    let allOptions = document.getElementById("editModalRoleSelector").options
    for (let i = 0; i < allOptions.length; i++) {
        if (allOptions[i].selected) {
            rolesArray.push({
                id: allOptions[i].id,
                name: allOptions[i].value
            })
        }
    }
    body = {
        id: $("#editId").val(),
        firstName:  $("#editFirstName").val(),
        lastName:   $("#editLastName").val(),
        age:        $("#editAge").val(),
        username:   $("#editEmail").val(),
        password:   $("#editPassword").val(),
        roles: rolesArray
    }
    sendPut(requestURL, body)
        .then(() => {
            let userId = parseInt(document.getElementById("editId").value)
            $('#tr' + userId).replaceWith(jsonToRow(body))
        })
        .then($("#editUserModal").modal('hide'))
}

// Удаляем пользователя
function deleteUser() {
    const idOfDeletedUser = $("#deleteId").val();
    sendDelete(requestURL + idOfDeletedUser)
        .then(() => {
            let deletedUserId = parseInt(document.getElementById("deleteId").value)
            $('#tr' + deletedUserId).remove()
        })
        .then($("#deleteUserModal").modal('hide'))
}

// Админ панель: модальное окно удаления пользователя
function deleteUserModal(userId) {
    // let id = event.target.parentNode.parentNode.id;
    $("#deleteUserModal").modal('show');
    sendGet(requestURL + userId)
        .then(response => {
            $("#deleteId").val(response.id),
                $("#deleteFirstName").val(response.firstName),
                $("#deleteLastName").val(response.lastName),
                $("#deleteAge").val(response.age),
                $("#deleteEmail").val(response.username),
                $("#deletePassword").val(response.password),
                $("#deleteRoles").val(rolesToString(response.roles))
        })
}


