//SeRVer info
const SRV_PROTOCOL = 'http'
const SRV_IP = 'localhost'
const SRV_PORT = '8080'

//server connection
const SRV = SRV_PROTOCOL + '://' + SRV_IP + ':' + SRV_PORT

/* -- app -- */

//initial func
const init = () => {
    fetch(SRV + '/getAll')
        .then(resp => resp.json())
        .then(resp => {
            console.log(resp)
            let html = '<article>'
            resp.forEach(article => {
                html += '<h2>' + article.title + '</h2>'
                html += '<h4> Kategoria: ' + article.category + ' | Autor: ' + article.author + '</h4>'
                html += '<h3>' + article.description + '</h3>'
                html += '<a href="#" class="button">Czytaj dalej</a>'
                html += '</article>'
            })
            document.getElementById('articles').innerHTML = html
        })
}

//start js script
window.onload = init