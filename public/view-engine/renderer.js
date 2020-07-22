
const renderer = {
  backendApi: axios.create({
    baseURL: 'http://localhost:8080'
  }),
  localApi: axios.create({
    baseURL: 'http://localhost:8081'
  }),
  //Renderiza una vista desde la carpeta web-components con los argumentos otorgados.
  //params:
  // documentId: id del DOM donde renderizar la vista.
  // viewName: Nombre de la vista a renderizar.
  // viewData: Argumentos a pasar a la vista.
  async render(documentId, viewName, viewData) {
    try {
      let html;
      try {
        const {data} = await this.localApi.request({
          url: `/view-engine/web-components/${viewName}.ejs`
        })
        html = ejs.render(data, viewData)
      } catch(e) {
        html = "Ocurrió un error desconocido"
      }
      document.getElementById(documentId).innerHTML = html
    } catch(e) {
      console.log(e)
      console.log('ERROR RENDERING %s', e.message)
    }
  },
  //Hace una petición al backend y retorna la respuesta.
  //params:
  // url: url de la petición.
  // bodyData: Argumentos a pasar a la petición.
  // type: Metodo HTTP (Get, Post, ...)
  async request(url, bodyData, method) {
    try {
      const {data, status} = await this.backendApi.request({
        url,
        method,
        data: bodyData
      })
      console.log(status)
      return {err: false, msg: "Ha ocurrido un error desconocido", data}
    } catch (e) {
      console.log('ERROR DE REQUEST: %s', JSON.stringify({url, bodyData, method}, null, 2))
      console.log(e)
      return {err: true, msg: "Ha ocurrido un error desconocido"}
    }
  }
}
