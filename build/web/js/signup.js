"use strict";
const signup = (evt) => {
    evt.preventDefault();
    const user_name = document.querySelector('[name="user_name"]').value;
    const user_email = document.querySelector('[name="user_email"]').value;
    const user_password = document.querySelector('[name="user_password"]').value;
    const data = JSON.stringify({
        user_name: user_name,
        user_email: user_email,
        user_password: user_password
    });
    const settings = {
        method: 'POST',
        body: data
    };
    fetch('http://localhost:8080/ex3/page/api/signup', settings).then((response) => {
        return response.text();
    }).then((text) => {
        document.querySelector('#message').innerHTML = text;
        if(text === 'Success'){
            setTimeout(() => {
                window.location = '/ex3/login.html';
                document.querySelector('#message').innerHTML = "";
            }, 2000);
        }
    });
};
document.querySelector('form').addEventListener('submit', signup);


