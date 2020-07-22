const views = {
  'lists': '<%' +
      'if(data.length) {' +
      '  for(let i = 0; i< data.length; i++){' +
      '  const user = data[i];' +
      '%>' +
      '<li><b>Username:</b>&nbsp;<%=user.username%>&nbsp;Id: <%=user.id%></li>' +
      '<%' +
      '  }' +
      '} else {' +
      '%>' +
      '<li>No Users Found</li>' +
      '<%' +
      '}' +
      '%>'
}
