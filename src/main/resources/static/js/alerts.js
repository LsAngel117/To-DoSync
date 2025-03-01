// alerta.js

// Función para obtener el valor de un parámetro de consulta en la URL
function getParameterByName(name) {
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(window.location.href);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}
// Comprobar si hay un parámetro de consulta 'success' en la URL
var successParam = getParameterByName('success');
if (successParam === 'true') {
    // Mostrar un mensaje de alerta si se encuentra el parámetro 'success'
    alert("¡Tarea guardada con éxito!\nSerá redirigido a su lista de tareas...");
}
