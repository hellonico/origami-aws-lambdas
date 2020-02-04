aws lambda invoke \
--function-name dnn \
--payload '"https://image.cnbcfm.com/api/v1/image/105992231-1561667465295gettyimages-521697453.jpeg?v=1561667497&w=630&h=354","https://a57.foxnews.com/static.foxnews.com/foxnews.com/content/uploads/2019/07/931/524/creepy-cat.jpg","https://a57.foxnews.com/static.foxnews.com/foxnews.com/content/uploads/2019/07/931/524/creepy-cat.jpg","https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=900&q=60"' \
dnn.log