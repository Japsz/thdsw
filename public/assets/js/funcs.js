const isLogged = localStorage.getItem('isLogged')
if (isLogged !== 'true') window.location.href = '/login'
function logout() {
  localStorage.setItem('isLogged', null)
  localStorage.setItem('userInfo', null)
  window.location.href = '/login'
}
function getLoggedUser() {
  return JSON.parse(localStorage.getItem('userInfo'))
}
window.getUser = getLoggedUser
