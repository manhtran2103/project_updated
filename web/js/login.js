"use strict";
const login = (evt) => {
    evt.preventDefault();
    const user_name = document.querySelector('[name="user_name"]').value;
    const user_password = document.querySelector('[name="user_password"]').value;
    const data = JSON.stringify({
        user_name: user_name,
        user_password: user_password
    });
    const settings = {
        method: 'POST',
        body: data
    };
    fetch('http://localhost:8080/ex3/page/api/login', settings).then((response) => {
        if(response.status == 200){
            document.querySelector('#error').innerHTML = "";
            return response.text();
        }
         document.querySelector('#error').innerHTML = "password or username invalid";  
    }).then((text) => {
        if(text !== undefined){
            document.cookie = ""+text+"";
            document.cookie = ""+text+"; expires=Thu, 18 Dec 2018 12:00:00 UTC; path=/upload.html";
            document.cookie = ""+text+"; expires=Thu, 18 Dec 2018 12:00:00 UTC; path=/home.html";
            window.location = 'http://localhost:8080/ex3/home.html';
        }
    });
};
document.querySelector('form').addEventListener('submit', login);


