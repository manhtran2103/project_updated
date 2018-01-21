"use strict";
const media_id = window.location.search.substr(1);
const user_name = document.cookie;
if(!user_name){
   document.querySelector('#view').setAttribute('style', 'display: none');
   window.location = '/ex3/login.html';
}
fetch(`/ex3/page/api/media/${media_id}`).then(res => res.json()).then(json => {
    console.log(json);
    document.querySelector('#img-01').setAttribute('src', `${json.mediaUrl}`);
});