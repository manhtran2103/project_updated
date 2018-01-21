"use strict";
//console.log(document.cookie);
const username = document.cookie;
if(!username){
    document.querySelector('#content').setAttribute("style", "display: none");
   
}

const html = document.querySelector('#message');
const upload = (evt) => {
    evt.preventDefault();
    html.innerHTML = "Upload in progress...";
    const input = document.querySelector('input[type="file"]');
    const data = new FormData();
    data.append("uploadFile", input.files[0]);
    const settings = {
        method: 'POST',
        body: data,
        headers: new Headers({"user_name": `${username}`})
    };
    
    fetch('http://localhost:8080/ex3/UploadServlet', settings).then((response) => {
        console.log(response);
        return response.text();
    }).then((text) => {
            html.innerHTML = text;
            setTimeout(()=>{
                window.location = '/ex3/home.html';
            }, 2000);
        
    }).catch((err) => {
        console.log(err);
    });
};

document.querySelector('form').addEventListener('submit', upload);
   





