"use strict";
const login = (evt) => {
    evt.preventDefault();
    const userName = document.querySelector('[name="userName"]').value;
    const userPassword = document.querySelector('[name="userPassword"]').value;
    const data = JSON.stringify({
        userName: userName,
        userPassword: userPassword
    });
    console.log(data);
    const settings = {
        method: 'POST',
        body: data
    };
    fetch('http://localhost:8080/ex3/page/api/login', settings).then((response) => {
        if(response.status != 200){
            console.log("password or username invalid");
            document.querySelector('#error').innerHTML = "password or username invalid";
        }
        return response.text();
    }).then((text) => {
        console.log(text);
        document.cookie()
    });
};
document.querySelector('form').addEventListener('submit', login);


