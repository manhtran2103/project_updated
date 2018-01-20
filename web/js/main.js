/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global fetch */

'use strict';

const html = document.querySelector('#message');
const upload = (evt) => {

    evt.preventDefault();
    html.innerHTML = "Upload in progress...";
    const input = document.querySelector('input[type="file"]');
    const data = new FormData();
    data.append("fileup", input.files[0]);
    const settings = {
        method: 'POST',
        // credentials: 'same-origin', 
        body: data
    };
    console.log(settings);

    fetch('http://localhost:8080/ex2/Servlet', settings).then((response) => {
        return response.text();
    }).then((text) => {
        console.log(text);
        html.innerHTML = 'upload complete';
        //document.querySelector('img').src = json.src;
    });
};
console.log(document.cookie);
//document.querySelector('form').addEventListener('submit', upload);
   


