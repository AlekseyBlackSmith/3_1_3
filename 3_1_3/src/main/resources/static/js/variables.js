const requestURL = 'http://localhost:8080/users/';

// html-блок, локальная таблица всех пользователей
let usersTable = '';

// html-блок, локальная таблица текущего пользователя (самого себя)
let singleUserTable = '';

// html-блок из option-ов, все возможные роли с сервера
let roleOptions = '';

// json object, все возможные роли с сервера
let roles;