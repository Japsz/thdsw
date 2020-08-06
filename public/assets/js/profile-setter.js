$(document).ready(() => {
  const user = JSON.parse(localStorage.getItem('userInfo'))
  document.getElementById('userEmail').innerText = user.empleado.cargo
  document.getElementById('userName').innerText = user.persona.nombre
  document.getElementById('userCard').innerHTML = `
  ${user.username}
  <span class="user-level">${user.empleado.cargo}</span>
  <span class="caret"></span>
  `
})
