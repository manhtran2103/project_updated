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

const like = () => {
  const data = JSON.stringify({
      user_name: user_name,
      media_id: media_id
  });
  console.log(data);
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

const comment = (e) => {
    e.preventDefault();
    const comment = document.querySelector('[name="comment"]').value;
    const data = JSON.stringify({
      user_name: user_name,
      media_id: media_id,
      comment: comment
    });
    console.log(data);
    const body = {
      method: 'POST',
      body: data
  };
  fetch('/ex3/page/api/comments/add', body).then(res => res.text()).then(text => {
      console.log(text);
      if(text === 'success'){
        document.querySelector('[name="comment"]').value = "";  
      }
  });
};
document.querySelector('form').addEventListener('submit', comment);