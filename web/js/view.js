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

// like
const like = () => {
  const data = JSON.stringify({
      user_name: user_name,
      media_id: media_id
  });
  const body = {
      method: 'POST',
      body: data
  };
  fetch('/ex3/page/api/like', body).then(res => res.text()).then(text => {
      if(text === 'success'){
          document.querySelector('#like').setAttribute('src','img/like.png');
      }
  });
};
document.querySelector('#like').addEventListener('click', like);

// fetching comments
fetch('/ex3/page/api/comments').then(res => res.json()).then(json => {
    let html = '';
    json.map((comment) => {
      html += `<div class="div-comment">
                        <div class="img-user"><img src="img/user.png"></div>
                        <div>
                        <a class="username" href="#">${comment.userName}</a>
                        <p class="comment">${comment.content}</p>
                        </div>
                    </div>
         `;  
    });
    document.querySelector('#content').innerHTML = html;
});

//comment
const comment = (e) => {
    e.preventDefault();
    const comment = document.querySelector('[name="comment"]').value;
    const data = JSON.stringify({
      user_name: user_name,
      media_id: media_id,
      comment: comment
    });
    const body = {
      method: 'POST',
      body: data
  };
  fetch('/ex3/page/api/comments/add', body).then(res => res.text()).then(text => {
      if(text === 'success'){
        const e = document.createElement('div');
        e.setAttribute('class', 'div-comment');
        e.innerHTML = `<div class="img-user"><img src="img/user.png"></div>
                        <div>
                        <a class="username" href="#">${user_name}</a>
                        <p class="comment">${comment}</p>
                        </div>`;
        document.querySelector('#content').appendChild(e);
        document.querySelector('[name="comment"]').value = "";  
      }
  });
};
document.querySelector('form').addEventListener('submit', comment);


