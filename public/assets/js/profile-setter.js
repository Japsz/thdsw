$(document).ready(() => {
  const user = JSON.parse(localStorage.getItem('userInfo'))
  document.getElementById('userEmail').text = user.empleado.cargo
  document.getElementById('userName').text = user.username
  document.getElementById('userCard').innerHTML = `
  ${user.username}
  <span class="user-level">${user.empleado.cargo}</span>
  <span class="caret"></span>
  `
})
