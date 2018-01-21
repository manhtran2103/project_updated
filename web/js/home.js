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

const listMedia = document.querySelector('#media');
fetch('/ex3/page/api/media').then((res) => {
    return res.json();
}).then((json) => {
    console.log(json);
    let html = "";
    json.map((media, index) => {
       html += ` <div>                   
                    <img src="${media.mediaUrl}" alt="image" class="image">
                    <div>
                        <p><span class="by_user">by</span><span class="user">user</span>
                            <a href="/ex3/view.html?${media.mediaId}" class="right"><img src ="img/like_home.png" width="20px" height="20px"></a>
                            <span class="like_number">${media.mediaLike}</span>
                            <a href="/ex3/view.html?${media.mediaId}" class="right"><img src="img/comments_home.png" width="23px" height="23px"></a></p>
                    </div>
                 </div>`;
    });
    listMedia.innerHTML = html;
});
