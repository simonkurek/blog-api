//SeRVer info
const SRV_PROTOCOL = 'http'
const SRV_IP = 'localhost'
const SRV_PORT = '8080'

//server connection
const SRV = SRV_PROTOCOL + '://' + SRV_IP + ':' + SRV_PORT

/* -- app -- */

//article loading func
const loadArticle = (id) => {
    fetch(SRV + '/getByID?id=' + id)
        .then(resp => resp.json())
        .then(article => {
            console.log(article)
            let html = '<article>'
            html += '<h2>' + article.title + '</h2>'
            html += '<h4> Kategoria: ' + article.category + ' | Autor: ' + article.author + '</h4>'
            html += '<p>' + article.content + '</p>'
            html += '<a href="#" class="button" onclick="window.location = \'http://localhost:8080/\'">Wróć do strony głównej</a>'
            html += '</article>'
            document.getElementById('articles').innerHTML = html
        })
}

//initial func
const init = () => {
    fetch(SRV + '/getAll')
        .then(resp => resp.json())
        .then(resp => {
            console.log(resp)

            resp.forEach(article => {
                let html = '<article>'
                html += '<h2>' + article.title + '</h2>'
                html += '<h4> Kategoria: ' + article.category + ' | Autor: ' + article.author + '</h4>'
                html += '<h3>' + article.description + '</h3>'
                html += '<a href="#" class="button" onclick="loadArticle(' + article.id + ')">Czytaj dalej</a>'
                html += '</article>'
                document.getElementById('articles').innerHTML += html
            })
        })
}

//start js script
window.onload = init