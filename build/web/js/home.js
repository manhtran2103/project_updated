"use strict";
console.log(document.cookie);
const username = document.cookie;
if(username){
    document.querySelector('#signup').setAttribute('style', 'display: none');
    document.querySelector('#login').setAttribute('style', 'display: none');
    document.querySelector('#logout').setAttribute('style', 'display: block');
    document.querySelector('#account').setAttribute('style', 'display: block');
    document.querySelector('#account').innerHTML = username;
   
}
const logout = (e) => {
    e.preventDefault();
    let now = new Date();
    now.setMonth(now.getMonth() - 1);
    console.log(now.toUTCString());
    document.cookie = ""+username+";expires = " +now.toUTCString()+ ";";
    console.log('logouted');
    window.location = '/ex3/home.html';
    
};

document.querySelector('#logout').addEventListener('click', logout);
