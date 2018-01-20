"use strict";
console.log(document.cookie);
const username = document.cookie;
if(!username){
    document.querySelector('#content').setAttribute("style", "display: none");
}


